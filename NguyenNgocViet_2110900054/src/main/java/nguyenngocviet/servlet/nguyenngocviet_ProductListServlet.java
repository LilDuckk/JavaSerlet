package nguyenngocviet.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenngocviet.beans.NguyenNgocViet_2110900054_Product;
import nguyenngocviet.conn.nguyenngocvietConnection;
import nguyenngocviet.utils.nguyenngocviet_ProductUtils;



@WebServlet("/nguyenngocviet_ProductList")
public class nguyenngocviet_ProductListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public nguyenngocviet_ProductListServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		List<NguyenNgocViet_2110900054_Product> list = null;
		try {
			conn = nguyenngocvietConnection.getMySQLConnection();
			
			try {
				list = nguyenngocviet_ProductUtils.queryProduct(conn);
				
			}catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("productList", list);
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
