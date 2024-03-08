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

@WebServlet("/nguyenngocviet_ProductCreate")
public class nguyenngocviet_ProductCreateServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public nguyenngocviet_ProductCreateServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductCreate.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
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
		
		String regex = "\\w+";
		if (maSP == null || !maSP.matches(regex)) {
			errorString = "Product maSP invalid!";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
			try {
				conn = nguyenngocvietConnection.getMySQLConnection();
				nguyenngocviet_ProductUtils.insertProduct(conn, product);
				response.sendRedirect(request.getContextPath() + "/nguyenngocviet_ProductList");
				
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductCreate.jsp");
				dispatcher.forward(request, response);
			}
	}
}
