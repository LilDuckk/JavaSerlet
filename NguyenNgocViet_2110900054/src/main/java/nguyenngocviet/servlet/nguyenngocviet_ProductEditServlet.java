package nguyenngocviet.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenngocviet.beans.NguyenNgocViet_2110900054_Product;
import nguyenngocviet.conn.nguyenngocvietConnection;
import nguyenngocviet.utils.nguyenngocviet_ProductUtils;


@WebServlet("/nguyenngocviet_ProductEdit")
public class nguyenngocviet_ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public nguyenngocviet_ProductEditServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductEdit.jsp");
		String maSP = (String) request.getParameter("maSP");
		if(maSP == null || maSP == "") {
			errorString="Bạn chưa chọn sản phẩm cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		NguyenNgocViet_2110900054_Product product = null;
		errorString = null;
		try {
			conn = nguyenngocvietConnection.getMySQLConnection();
			product = nguyenngocviet_ProductUtils.findProduct(conn, maSP);
			if(product==null) {
				errorString="Không tìm thấy sản phẩm có mã" + maSP;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || product == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		dispatcher.forward(request, response);
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String maSP = (String) request.getParameter("maSP");
		String tenSP = (String) request.getParameter("tenSP");
		String soLuongStr = (String) request.getParameter("soLuong");
		String donGiaStr = (String) request.getParameter("donGia");
		String anh = (String) request.getParameter("anh");
		float donGia = 0;
		try {
			donGia = Float.parseFloat(donGiaStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		int soLuong = 0;
		try {
			soLuong = Integer.valueOf(soLuongStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		NguyenNgocViet_2110900054_Product product = new NguyenNgocViet_2110900054_Product(maSP, tenSP, soLuong, donGia, anh);
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = nguyenngocvietConnection.getMySQLConnection();
			nguyenngocviet_ProductUtils.updateProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/nguyenngocviet_ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
	}
}
