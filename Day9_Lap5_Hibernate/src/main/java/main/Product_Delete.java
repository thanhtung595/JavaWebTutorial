package main;

import dao.ProductDAOImpl;

public class Product_Delete {
	public static void main(String[] args) {
		boolean flag = new ProductDAOImpl().deleteProduct("P0004");
		if(flag == true) {
			System.out.printf("Đã xoá sản phẩm có mã P004  !!!");
		}else {
			System.out.printf("Sảy ra lỗi khi xoá sản phẩm :))");
		}
	}
}
