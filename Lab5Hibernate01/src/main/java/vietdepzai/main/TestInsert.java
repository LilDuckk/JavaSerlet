package vietdepzai.main;

import vietdepzai.dao.ProductDAOImpl;
import vietdepzai.entity.Product;

public class TestInsert {
	public static void main(String[] args) {
		Product p = new Product();
		p.setMaSP("P005");
		p.setTenSanPham("Kệ để giày");
		p.setAnhSanPham("P005.jpg");	
		p.setSoLuong(150);
		p.setDonGia(1990000d);
		
		boolean flag = new ProductDAOImpl().insertProduct(p);
		if(flag==true) {
			System.out.println("Thêm mới thành công!");
		}else {
			System.out.println("Sảy ra lỗi thêm mới sản phẩm");
		}
}

}

