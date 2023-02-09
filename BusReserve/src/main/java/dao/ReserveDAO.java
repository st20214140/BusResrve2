package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReserveBean;

public class ReserveDAO {
	
	private final String JDBC_URL="jdbc:mysql://fukushima-pc/BusReserve";
	private final String DB_USER = "teamE";
	private final String DB_PASS = "eggfruitMySQL";

	public List<ReserveBean> findAll(){
		List<ReserveBean> empList = new ArrayList<ReserveBean>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql = "SELECT reserve_id,name,num_people,user_id,NAME,AGE FROM reserves";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String reserveId = rs.getString("reserve_id");
				String userId= rs.getString("user_id");
				String name = rs.getString("name");
				int peopleNum = rs.getInt("num_people");
				ReserveBean ReserveBean = new ReserveBean(reserveId,userId,name,peopleNum);
				empList.add(ReserveBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean insert(ReserveBean ReserveBean) {
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "INSERT INTO EMPLOYEE(reserve_id,user_id,name,num_people) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1,ReserveBean.getReserveId());
			pStmt.setString(2,ReserveBean.getUserId());
			pStmt.setString(3,ReserveBean.getName());
			pStmt.setInt(4,ReserveBean.getPeopleNum());
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
				System.out.println("!!レコードは更新（INSERT）されませんでした。");
				e.printStackTrace();
				return false;
		}
			System.out.println("!!レコードは正常に更新（INSERT）されました。");
			return true;
	}
	
	public boolean update(ReserveBean ReserveBean) {
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "UPDATE EMPLOYEE SET name = ? , num_people = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1,ReserveBean.getName());
			pStmt.setInt(2,ReserveBean.getPeopleNum());
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
				System.out.println("!!レコードは追加（INSERT）されませんでした。");
				e.printStackTrace();
				return false;
		}
			System.out.println("!!レコードは正常に追加（INSERT）されました。");
			return true;
	}
	
	public boolean delete(ReserveBean ReserveBean) {
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "DELETE  FROM EMPLOYEE WHERE reserve_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1,ReserveBean.getReserveId());
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
				System.out.println("!!レコードは削除（INSERT）されませんでした。");
				e.printStackTrace();
				return false;
		}
			System.out.println("!!レコードは正常に削除（INSERT）されました。");
			return true;
	}

}
