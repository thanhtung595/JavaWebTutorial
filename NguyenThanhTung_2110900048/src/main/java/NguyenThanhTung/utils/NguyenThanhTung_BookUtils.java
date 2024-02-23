package NguyenThanhTung.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import NguyenThanhTung.beans.NguyenThanhTung_2110900048_Book;


public class NguyenThanhTung_BookUtils {
	//Doc san pham
			public static List<NguyenThanhTung_2110900048_Book> queryBook(Connection conn)
				throws SQLException{
				String sql = "select a.MaSach_2110900048, a.TenSach_2110900048, a.SoLuong_2110900048, a.DonGia_2110900048, a.Anh_2110900048 from NguyenThanhTung_2110900048_Book a";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<NguyenThanhTung_2110900048_Book> list = new ArrayList<NguyenThanhTung_2110900048_Book>();
				while (rs.next()) {
					String maSach = rs.getString("MaSach_2110900048");
					String tenSach = rs.getString("TenSach_2110900048");
					int soLuong = rs.getInt("SoLuong_2110900048");
					float donGia = rs.getFloat("DonGia_2110900048");
					String anh = rs.getString("Anh_2110900048");
					NguyenThanhTung_2110900048_Book book = new NguyenThanhTung_2110900048_Book();
					book.setMaSach(maSach);
					book.setTenSach(tenSach);
					book.setSoLuong(soLuong);
					book.setDonGia(donGia);
					book.setAnh(anh);
					list.add(book);
				}
				return list;
			}
		// Tim kiem
			public static NguyenThanhTung_2110900048_Book findBook(Connection conn, String maSach)
				throws SQLException{
				String sql = "select a.MaSach_2110900048, a.TenSach_2110900048, a.SoLuong_2110900048, a.DonGia_2110900048, a.Anh_2110900048 from NguyenThanhTung_2110900048_Book a where a.MaSach_2110900048 =?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, maSach);
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String tenSach = rs.getString("TenSach_2110900048");
					int soLuong = rs.getInt("SoLuong_2110900048");
					float donGia = rs.getFloat("DonGia_2110900048");
					String anh = rs.getString("Anh_2110900048");
					NguyenThanhTung_2110900048_Book book = new NguyenThanhTung_2110900048_Book(maSach,tenSach,soLuong,donGia,anh);
					return book;
				}
				return null;
			}
		// Them moi
			public static void insertBook(Connection conn, NguyenThanhTung_2110900048_Book book)
				throws SQLException{
				String sql = "insert into NguyenThanhTung_2110900048_Book(MaSach_2110900048, TenSach_2110900048, SoLuong_2110900048, DonGia_2110900048, Anh_2110900048) values(?,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, book.getMaSach());
				pstm.setString(2, book.getTenSach());
				pstm.setInt(3, book.getSoLuong());
				pstm.setFloat(4, book.getDonGia());
				pstm.setString(5, book.getAnh());
				pstm.executeUpdate();
			}
		// Cap nhat
			public static void updateBook(Connection conn, NguyenThanhTung_2110900048_Book book)
				throws SQLException{
				String sql = "update NguyenThanhTung_2110900048_Book set TenSach_2110900048 = ?, SoLuong_2110900048 =?, DonGia_2110900048 =?, Anh_2110900048 =? where MaSach_2110900048 =?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, book.getTenSach());
				pstm.setInt(2, book.getSoLuong());
				pstm.setFloat(3, book.getDonGia());
				pstm.setString(4, book.getAnh());
				pstm.setString(5, book.getMaSach());
				pstm.executeUpdate();
			}
		// Xoa sp
			public static void deleteBook(Connection conn, String maSach)
				throws SQLException{
				String sql = "delete from NguyenThanhTung_2110900048_Book where MaSach_2110900048 = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, maSach);
				pstm.executeUpdate();
			}
}
