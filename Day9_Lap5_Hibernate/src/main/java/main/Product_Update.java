package main;

import dao.ProductDAOImpl;
import entity.TbProduct;

public class Product_Update {
	public static void main(String[] args) {
		TbProduct p = new ProductDAOImpl().getProductById("P0004");
		p.setMaSP("P0004");
		p.setTenSanPham("Kệ để giày nam");
		p.setAnhSanPham("P0004.jpg");
		p.setSoLuong(150);
		p.setDonGia(2990000d);
		
		boolean flag = new ProductDAOImpl().updateProduct(p);
		if(flag == true) {
			System.out.printf("Sửa đổi dữ liệu thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi sửa sản phẩm :))");
		}
		
	}
}
