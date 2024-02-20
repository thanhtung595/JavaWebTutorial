package thanhtung.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import thanhtung.beans.UserAccount;



public class LoginUntils {
	public static UserAccount findUser(Connection conn,
			String userName ,String password)
	throws SQLException{
		String sql = "select a.User_Name, a.Password,"
				+ "a.Gender from User_Account"
				+"where a.User_Name =? and a.password";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
	
	public static UserAccount findUser(Connection conn, String userName)
		throws SQLException {
		String sql = "select a.User_Name, a.Password,"
				+ "a.Gender from User_Account"
				+"where a.User_Name =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			String gender = rs.getString("Gender");
			String password = rs.getString("Password");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
}
