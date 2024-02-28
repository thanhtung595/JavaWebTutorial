package main;

import dao.ProductDAOImpl;
import entity.Product;

public class Product_Insert {
	public static void main(String[] args) {
		Product p = new Product();
		p.setMaSP("P0004");
		p.setTenSanPham("Kệ để giày");
		p.setAnhSanPham("P0005.jpg");
		p.setSoLuong(150);
		p.setDonGia(1990000d);
		
		
		boolean flag = new ProductDAOImpl().insertProduct(p);
		if(flag == true) {
			System.out.printf("Thêm mới thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi thêm mới sản phẩm :))");
		}
	}
}
