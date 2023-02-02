package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EmployeeBean;
import model.user;

//import java.sql.*;

public class UserDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://fukushima-pc/BusReserve";
	private final String DB_USER = "teamE";
	private final String DB_PASS = "eggfruitMySQL";
		
	public String getUserId(user user) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = 
					"SELECT user_id " + 
					"FROM   users" + 
					"WHERE name = ? AND call_number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getCallNumber());
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			return rs.getString("user_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insert(user user) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文を接続
			String sql = "INSERT INTO users(user_id, users, call_number) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, );
			pStmt.setString(2, user.getName());
			pStmt.setInt(3, user.getCallNumber());
			
			// INSER文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();
			
			// 成功すると1が戻るなで、1ではない時失敗
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは格納(INSERT)されませんでした。");
			e.printStackTrace();
			return false;
		}
		
		System.out.println("!! レコードは正常に追加(INSERT)されました。");
		return true;
	}
}
