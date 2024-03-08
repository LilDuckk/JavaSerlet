package nguyenngocviet.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nguyenngocviet.beans.NguyenNgocViet_2110900054_Product;



public class nguyenngocviet_ProductUtils {
	public static List<NguyenNgocViet_2110900054_Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.MaSP_2110900054, a.TenSP_2110900054, a.SoLuong_2110900054, a.DonGia_2110900054, a.Anh_2110900054 from nguyenngocviet_2110900054_product a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<NguyenNgocViet_2110900054_Product> list = new ArrayList<NguyenNgocViet_2110900054_Product>();
		while (rs.next()) {
			String maSP = rs.getString("MaSP_2110900054");
			String tenSP = rs.getString("TenSP_2110900054");
			int soLuong = rs.getInt("SoLuong_2110900054");
			float donGia = rs.getFloat("DonGia_2110900054");
			String anh = rs.getString("Anh_2110900054");
			NguyenNgocViet_2110900054_Product product = new NguyenNgocViet_2110900054_Product();
			product.setMaSP(maSP);
			product.setTenSP(tenSP);
			product.setSoLuong(soLuong);
			product.setDonGia(donGia);
			product.setAnh(anh);
			list.add(product);
		}
		return list;
	}
	
	public static NguyenNgocViet_2110900054_Product findProduct(Connection conn, String maSP) throws SQLException {
		String sql = "Select a.MaSP_2110900054, a.TenSP_2110900054, a.SoLuong_2110900054, a.DonGia_2110900054, a.Anh_2110900054 from nguyenngocviet_2110900054_product a where a.MaSP_2110900054=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maSP);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String tenSP = rs.getString("TenSP_2110900054");
			int soLuong = rs.getInt("SoLuong_2110900054");
			float donGia = rs.getFloat("DonGia_2110900054");
			String anh = rs.getString("Anh_2110900054");
			NguyenNgocViet_2110900054_Product product = new NguyenNgocViet_2110900054_Product(maSP, tenSP, soLuong, donGia, anh);
			return product;
		}
		return null;
	}
	public static void insertProduct(Connection conn, NguyenNgocViet_2110900054_Product product) throws SQLException {
		String sql = "Insert into nguyenngocviet_2110900054_product(MaSP_2110900054, TenSP_2110900054, SoLuong_2110900054, DonGia_2110900054, Anh_2110900054) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,  product.getMaSP());
		pstm.setString(2, product.getTenSP());
		pstm.setInt(3, product.getSoLuong());
		pstm.setFloat(4, product.getDonGia());
		pstm.setString(5, product.getAnh());
		pstm.executeUpdate();
	}
	
	public static void updateProduct(Connection conn, NguyenNgocViet_2110900054_Product product) throws SQLException  {
		String sql = "Update nguyenngocviet_2110900054_product set TenSP_2110900054 =?, SoLuong_2110900054=?, DonGia_2110900054=?, Anh_2110900054=? where MaSP_2110900054=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getTenSP());
		pstm.setInt(2, product.getSoLuong());
		pstm.setFloat(3, product.getDonGia());
		pstm.setString(4, product.getAnh());
		pstm.setString(5,  product.getMaSP());
		pstm.executeUpdate();
	}
	
	public static void deleteProduct(Connection conn, String maSP) throws SQLException {
		String sql = "Delete From nguyenngocviet_2110900054_product where MaSP_2110900054=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maSP);
		pstm.executeUpdate();
	}
}
