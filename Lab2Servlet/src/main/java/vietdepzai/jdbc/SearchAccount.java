package vietdepzai.jdbc;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchAccount")
public class SearchAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title><head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> KET QUA TIM KIEM </h1>");
		out.println("<form action = 'SearchAccount' method='post'>");
		out.println("<p> Input phone: ");
		out.println("<input	type=text name='phone' value='" + phone + "'/>");
		out.println("<p> <input type='submit' value='Search' />");
		out.println("</form>");
		try {
			String sql = "SELECT * FROM `user_account`";
			if(phone!=null && phone.length()!=0)
				sql +="WHERE CusPhone LIKE '%" + phone + "%'";
			Connection conn = ConnectionUtils.getMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<h2> Danh sach </h2>");
			out.println("<table border=1 align='center' style='width:100%'>");
			out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");
			if(rs!=null) {
				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString("CusUser") + "</td>");
					out.println("<td>" + rs.getString("CusName") + "</td>");
					out.println("<td>" + rs.getString("CusPhone") + "</td>");
					out.println("</tr>");
				}
			}
			rs.close();
			out.println("</table>");
		}catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + "</h1>");
			out.println("<p>" + ex.toString() + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
