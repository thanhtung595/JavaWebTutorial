package ntt.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ntt.beans.KHACHHANG_NguyenThanhTung;

public class KHACHHANG_NguyenThanhTung_Utils {
	public static List<KHACHHANG_NguyenThanhTung> getAllKhachHang(Connection conn) throws SQLException {
		String sql = "SELECT a.MAKH_2110900048, a.HOTEN_2110900048, a.NGAYSINH_2110900048, a.GIOITINH_2110900048, a.ANH_2110900048, a.TINHTRANG_2110900048 "
				+ "FROM KHACHHANG_NguyenThanhTung a where a.TINHTRANG_2110900048 = 1";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<KHACHHANG_NguyenThanhTung> list = new ArrayList<>();
		while (rs.next()) {
			String MAKH_2110900048 = rs.getString("MAKH_2110900048");
			String HOTEN_2110900048 = rs.getString("HOTEN_2110900048");
			String NGAYSINH_2110900048 = rs.getString("NGAYSINH_2110900048");
			Boolean GIOITINH_2110900048 = rs.getBoolean("GIOITINH_2110900048");
			String ANH_2110900048 = rs.getString("ANH_2110900048");
			Boolean TINHTRANG_2110900048 = rs.getBoolean("TINHTRANG_2110900048");

			KHACHHANG_NguyenThanhTung kh = new KHACHHANG_NguyenThanhTung(MAKH_2110900048, HOTEN_2110900048,
					NGAYSINH_2110900048, GIOITINH_2110900048, ANH_2110900048, TINHTRANG_2110900048);

			list.add(kh);
		}
		return list;
	}

	public static void insertKhachHang(Connection conn, KHACHHANG_NguyenThanhTung kh) throws SQLException {
		String sql = "insert into KHACHHANG_NguyenThanhTung(MAKH_2110900048, HOTEN_2110900048, NGAYSINH_2110900048, GIOITINH_2110900048, ANH_2110900048,TINHTRANG_2110900048) values(?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, kh.getMAKH_2110900048());
		pstm.setString(2, kh.getHOTEN_2110900048());
		pstm.setString(3, kh.getNGAYSINH_2110900048());
		pstm.setBoolean(4, kh.getGIOITINH_2110900048());
		pstm.setString(5, kh.getANH_2110900048());
		pstm.setBoolean(6, kh.getTINHTRANG_2110900048());
		pstm.executeUpdate();
	}
}
