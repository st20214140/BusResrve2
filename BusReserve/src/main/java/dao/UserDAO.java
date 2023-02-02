package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBean;

//import java.sql.*;

public class UserDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://fukushima-pc/BusReserve";
	private final String DB_USER = "teamE";
	private final String DB_PASS = "eggfruitMySQL";
	
	/**
	 findUser()メソッド<br>
	 * userName, callNumberからUserIDを検索(SELECT)します。<br>
	 * @param employeeBean
	 * @return boolean (成功時:True / 失敗時:False)
	 */
	public String findUserID(UserBean user) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = 
					"SELECT user_id " + 
					"FROM   users" + 
					"WHERE name = ? AND call_number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			return rs.getString("user_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String insert(UserBean user) {
		// データベースへ接続
		String result;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文を接続
			String sql = 
					"INSERT INTO users(user_id, user_name, call_number)"
					+ "SELECT COALESCE(MAX(user_id)+1,1), ?, ?"
					+ "FROM users";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());
			
			// INSER文を実行し、実行結果をresultに格納
			result = findUserID(user);
			
		} catch (SQLException e) {
			System.out.println("!! レコードは格納(INSERT)されませんでした。");
			e.printStackTrace();
			return null;
		}
		
		System.out.println("!! レコードは正常に追加(INSERT)されました。");
		return result;
	}
}
