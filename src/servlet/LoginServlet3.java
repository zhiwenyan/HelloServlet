package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.0.179/Alan_Test";
			String user = "root";
			String password2 = "storm";
			connection = DriverManager.getConnection(url, user, password2);
			String sql = "SELECT COUNT(id) FROM USERS WHERE USERNAME = ? " +
					"AND PASSWORD = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			StringBuilder result = new StringBuilder();
			result.append("<html>")
			.append(" <head>")
			.append(" </head>") 
			.append("</html>");			
			if(resultSet.next()){
				int count = resultSet.getInt(1);
				if(count > 0){
					out.print("Success");	
				}else{
					out.print("Sorry: " + username);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
