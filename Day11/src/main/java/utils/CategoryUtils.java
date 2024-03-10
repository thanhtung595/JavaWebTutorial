package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Book;
import beans.Category;

public class CategoryUtils {
	// Doc san pham
		public static List<Category> queryCategory(Connection conn) throws SQLException {
			String sql = "select a.CategoryId, a.CategoryName  from Category a";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {
				int categoryId = rs.getInt("CategoryId");
				String categoryName = rs.getString("CategoryName");
				

				Category cate = new Category();
				cate.setCategoryId(categoryId);
				cate.setCategoryName(categoryName);
				list.add(cate);
			}
			return list;
		}
}
