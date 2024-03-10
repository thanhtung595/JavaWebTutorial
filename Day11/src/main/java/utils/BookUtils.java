package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Book;
import beans.Category;

public class BookUtils {
	// Doc san pham
	public static List<Book> queryBook(Connection conn) throws SQLException {
	    String sql = "SELECT a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId, c.CategoryName " +
	                 "FROM Book a " +
	                 "INNER JOIN Category c ON a.CategoryId = c.CategoryId";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    List<Book> list = new ArrayList<>();
	    while (rs.next()) {
	        String bookId = rs.getString("BookId");
	        String title = rs.getString("Title");
	        String author = rs.getString("Author");
	        int release = rs.getInt("Release");
	        float price = rs.getFloat("Price");
	        String picture = rs.getString("Picture");
	        int publisherId = rs.getInt("PublisherId");
	        int categoryId = rs.getInt("CategoryId");
	        String categoryName = rs.getString("CategoryName");

	        // Tạo đối tượng Category từ dữ liệu trong ResultSet
	        Category category = new Category(categoryId, categoryName);

	        // Tạo đối tượng Book và gán các giá trị từ ResultSet và đối tượng Category vào
	        Book book = new Book(bookId, title, author, release, price, picture, publisherId, categoryId, category);

	        // Thêm đối tượng Book vào danh sách
	        list.add(book);
	    }
	    return list;
	}

	// Tim kiem
	public static Book findBook(Connection conn, String bookId) throws SQLException {
		String sql = "select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId from Book a where a.BookId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, bookId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String title = rs.getString("Title");
			String author = rs.getString("Author");
			int release = rs.getInt("Release");
			float price = rs.getFloat("Price");
			String picture = rs.getString("Picture");
			int publisherId = rs.getInt("PublisherId");
			int categoryId = rs.getInt("CategoryId");
			Book book = new Book(bookId, title, author, release, price, picture, publisherId, categoryId);
			return book;
		}
		return null;
	}

	// Them moi
	public static void insertBook(Connection conn, Book book) throws SQLException {
		String sql = "insert into Book(BookId, Title, Author, Release, Price,Picture,PublisherId,CategoryId) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getBookId());
		pstm.setString(2, book.getTitle());
		pstm.setString(3, book.getAuthor());
		pstm.setInt(4, book.getRelease());
		pstm.setFloat(5, book.getPrice());
		pstm.setString(6, book.getPicture());
		pstm.setInt(7, book.getPublisherId());
		pstm.setInt(8, book.getCategoryId());
		pstm.executeUpdate();
	}

	// Cap nhat
	public static void updateBook(Connection conn, Book book) throws SQLException {
		String sql = "update Book set Title = ?, Author =?, Release =?, Price =? , Picture =?,PublisherId=? ,CategoryId= ? where BookId =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getTitle());
		pstm.setString(2, book.getAuthor());
		pstm.setInt(3, book.getRelease());
		pstm.setFloat(4, book.getPrice());
		pstm.setString(5, book.getPicture());
		pstm.setInt(6, book.getPublisherId());
		pstm.setInt(7, book.getCategoryId());
		pstm.setString(8, book.getBookId());
		pstm.executeUpdate();
	}

	// Xoa sp
	public static void deleteBook(Connection conn, String bookId) throws SQLException {
		String sql = "delete from Book where BookId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, bookId);
		pstm.executeUpdate();
	}
}
