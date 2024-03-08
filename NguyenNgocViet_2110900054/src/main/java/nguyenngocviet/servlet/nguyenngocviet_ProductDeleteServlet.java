package nguyenngocviet.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenngocviet.conn.nguyenngocvietConnection;
import nguyenngocviet.utils.nguyenngocviet_ProductUtils;


@WebServlet("/nguyenngocviet_ProductDelete")
public class nguyenngocviet_ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nguyenngocviet_ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorString = null;
		String maSP = (String)request.getParameter("maSP");
		Connection conn = null;
		try {
			conn = nguyenngocvietConnection.getMySQLConnection();
			nguyenngocviet_ProductUtils.deleteProduct(conn, maSP);
			
		} catch(Exception e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/nguyenngocviet_ProductList.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/nguyenngocviet_ProductList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
