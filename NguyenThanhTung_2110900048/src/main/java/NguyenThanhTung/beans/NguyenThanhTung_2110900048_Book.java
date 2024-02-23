package NguyenThanhTung.beans;

public class NguyenThanhTung_2110900048_Book {
	private String maSach;
	private String tenSach;
	private int soLuong;
	private float donGia;
	private String anh;
	
	public NguyenThanhTung_2110900048_Book() {
		// TODO Auto-generated constructor stub
	}

	public NguyenThanhTung_2110900048_Book(String maSach, String tenSach, int soLuong, float donGia, String anh) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.anh = anh;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
}
