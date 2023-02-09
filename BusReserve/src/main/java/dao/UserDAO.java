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
	 *  Usersテーブルから全行列をList<UserBean>型で取得<br>
	 * @param None
	 * @return List<UserBean>
	 */
	public List<UserBean> findAll() {
		List<UserBean> userList = new ArrayList<UserBean>();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT USER_ID, USER_NAME, CALL_NUMBER FROM USERS";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String callNumber = rs.getString("CALL_NUMBER");
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
			String sql = "SELECT USER_ID FROM USERS WHERE USER_NAME = '?' AND CALL_NUMBER = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());

			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				UserBean tmpUser = new UserBean(userId);
				userList.add(tmpUser);
			}

			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * insert()<br>
	 * Usersテーブルに挿入する(氏名, 電話番号)<br>
	 * @param UserBean
	 * @return true:成功 / false:失敗
	 */
	public boolean insert(UserBean user) {
		// データベースへ接続
		int result;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文を接続
			String sql = "INSERT INTO USERS(USER_ID, USER_NAME, CALL_NUMBER)"
					+ "SELECT COALESCE(MAX(USER_ID)+1,1), ?, ?"
					+ "FROM USERS";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getCallNumber());
			// INSER文を実行し、実行結果をresultに格納
			result = pStmt.executeUpdate();

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
	
	/**
	 * update()メソッド<br>
	 * USER_IDをもとに氏名、電話番号を更新します。<br>
	 * @param UserBean
	 * @return true:成功/false:失敗
	 */
	public boolean update(UserBean user) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			 // UPDATE文を準備
			String sql = "UPDATE USERS SET USER_NAME = ?, CALL_NUMBER = ? WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// UPDATE文の中の「？」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2,  user.getCallNumber());
			pStmt.setString(3,  user.getUserId());
			
			int result = pStmt.executeUpdate();
			
			// 成功すると1が戻るので、1ではないときには失敗
			if (result != 1) { return false ; }
			
		} catch (SQLException e) {
			System.out.println("!! レコードは更新(UPDATE)されませんでした。");
			e.printStackTrace();
			return true;
		}
		System.out.println("!! レコードは正常に更新(UPDATE)されました");
		return true;
	}
	
	/**
	 * delete()メソッド<br>
	 * USER_IDをもとに削除します。<br>
	 * @param UserBean
	 * @return true:成功/false:失敗
	 */
	public boolean delete(UserBean user) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// UPDATE文ぞ準備
			String sql = "DELETE FROM USERS WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// UPDATE文の中「？」に使用する値をセットし、
			pStmt.setString(1, user.getUserId());
			
			// INSERT文を実行
			int result = pStmt.executeUpdate();
			
			if (result != 1) { return false; }
		} catch (SQLException e) {
			System.out.println("!! レコードを削除(DELETE)されませんでした");
			e.printStackTrace();
			return false;
		}
		
		System.out.println("!! レコードは正常に削除(DELETE)されました");
		return true;
	}
	
	/**
	 * getUserId()メソッド()<br>
	 * usersテーブルから、氏名・電話番号から
	 * @param userName
	 * @param callNumber
	 * @return
	 */
	public String getUserId(String userName, String callNumber) {
		UserDAO userDAO = new UserDAO();
		List<UserBean> userList = userDAO.findAll();
		
		for (UserBean user : userList) {
			if (user.getUserName().equals(userName) && user.getCallNumber().equals(callNumber)) {
//				System.out.println("ID " + user.getUserId());
				return user.getUserId();
			}
		}
		return null;
	}
}
