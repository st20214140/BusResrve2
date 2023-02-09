package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BusBean;

public class BusDAO {
	private final String JDBC_URL="jdbc:mysql://fukushima-pc/BusReserve";
	private final String DB_USER = "teamE";
	private final String DB_PASS = "eggfruitMySQL";
	
	public List<BusBean> findAll(){
		List<BusBean> empList = new ArrayList<BusBean>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql = "SELECT bus_id,start_place,start_times,goal_place,goal_times FROM buses";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String busId = rs.getString("bus_id");
				String startPlace = rs.getString("start_place");
				String startTime = rs.getString("start_times");
				String goalPlace = rs.getString("goal_place");
				String goalTime = rs.getString("goal_times");

				BusBean BusBean = new BusBean(busId,startPlace,goalPlace,startTime,goalTime);
				empList.add(BusBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
}
