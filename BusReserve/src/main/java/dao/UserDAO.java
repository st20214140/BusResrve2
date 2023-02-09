package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBean;

//import java.sql.*;

public class UserDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://fukushima-pc/BusReserve";
	private final String DB_USER = "teamE";
	private final String DB_PASS = "eggfruitMySQL";
	
	/**
	 *  findAll()メソッド<br>
	 *  Usersテーブルから
	 * @return
	 */
	public List<UserBean> findAll() {
		List<UserBean> userList = new ArrayList<UserBean>();
<<<<<<< HEAD
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT user_id, user_name, call_number FROM users";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String userId   = rs.getString("user_id");
				String userName = rs.getString("user_name");
				String callNumber = rs.getString("call_number");
				UserBean UserBean = new UserBean(userId, userName, callNumber);
				userList.add(UserBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	
	/**
	 findUser()メソッド<br>
	 * userName, callNumberからUserIDを検索(SELECT)します。<br>
	 * @param UserBean
	 * @return boolean (成功時:True / 失敗時:False)
	 */
	public List<UserBean> findUserID(UserBean user) {
		List<UserBean> userList = new ArrayList<UserBean>();
		
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = 
					"SELECT user_id FROM users WHERE user_name = '?' AND call_number = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());
=======
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT user_id, user_name, call_number FROM users";
			PreparedStatement pStmt = conn.prepareStatement(sql);
>>>>>>> Loginlogic作成
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
<<<<<<< HEAD
			while (rs.next()) {
				String userId   = rs.getString("user_id");
				UserBean userBean = new UserBean(userId);
=======
			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String userId   = rs.getString("user_id");
				String userName = rs.getString("user_name");
				String callNumber = rs.getString("call_number");
				UserBean UserBean = new UserBean(user_id, user_name, tel_number);
				userList.add(UserBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	
	/**
	 findUser()メソッド<br>
	 * userName, callNumberからUserIDを検索(SELECT)します。<br>
	 * @param UserBean
	 * @return boolean (成功時:True / 失敗時:False)
	 */
	public List<UserBean> findUserID(UserBean user) {
		List<UserBean> userList = new ArrayList<UserBean>();
		
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = 
					"SELECT user_id FROM users WHERE user_name = '?' AND call_number = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getUser_name());
			pStmt.setString(2, user.getTel_number());
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String userId   = rs.getString("user_id");
				UserBean userBean = new UserBean(user_id);
>>>>>>> Loginlogic作成
				userList.add(userBean);
			}
			
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insert(UserBean user) {
		// データベースへ接続
<<<<<<< HEAD
		boolean result;
=======
		String result;
>>>>>>> Loginlogic作成
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文を接続
			String sql = 
					"INSERT INTO users(user_id, user_name, call_number)"
					+ "SELECT COALESCE(MAX(user_id)+1,1), ?, ?"
					+ "FROM users";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
<<<<<<< HEAD
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());
			
			// INSER文を実行し、実行結果をresultに格納
			result = true;
=======
			pStmt.setString(1, user.getUser_name());
			pStmt.setString(2, user.getTel_number());
			
			// INSER文を実行し、実行結果をresultに格納
			result = findUserID(user);
>>>>>>> Loginlogic作成
			
		} catch (SQLException e) {
			System.out.println("!! レコードは格納(INSERT)されませんでした。");
			e.printStackTrace();
			return null;
		}
		
		System.out.println("!! レコードは正常に追加(INSERT)されました。");
		return result;
	}
}
