package model;

import dao.UserDAO;

public class LoginLogic {
	/**
	 * excuteメソッド<br>
	 * ログインに関する処理を提供します。（ダミー処理）<br>
	 * 今回はパスワードが1234の時に認証が成功します。<br>
	 * @param UserBean(ユーザー情報のユーザ名／電話番号)<br>
	 * @return true…認証成功 / false…認証失敗
	 */
	public boolean execute(UserBean user_name,UserBean tel_number) {
		
		//UserBeanをインスタンス化
		UserBean userBean = new UserBean();
		
		
		
		
		// UserDAOをインスタンス化
		UserDAO userDAO = new UserDAO();
		
		// ユーザーIDの全リストを取得
		String userId = userDAO.findAll();
		
			//電話番号とフルネームがデータベースに存在したらtrue
			if(userBean.getUser_name()!=null && userBean.getTel_number()!=null) {
				return true;
	
			
			
			/*
			 * 例
			 * public boolean execute(UserBEan user){
			 * /パスワードが1234の時はtrue if(user.getpass().equals("1234")) {
			 * return false; 
			 * }
			 */
		}
	}
}