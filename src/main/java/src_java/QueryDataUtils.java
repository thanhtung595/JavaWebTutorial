package src_java;

import java.sql.*;

public class QueryDataUtils {
	public static ResultSet getAll(String sql)

			throws SQLException,ClassNotFoundException {

		// Lấy ra đối tượng Connection kết nối vào DB.
		Connection connection = ConnectionUtils.getMySQLConnection();
		// Tạo đối tượng Statement.
		Statement statement = connection.createStatement();

		// Thực thi câu lệnh SQL trả về đối tượngResultSet.

		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}

}
