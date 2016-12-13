package EL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("To A Page");
		
		//ͨ��ת���ķ�ʽ��Ӧ a.jsp
		request.getRequestDispatcher("/a.jsp").forward(request, response);
		
		response.sendRedirect("a.jsp");
		
		response.sendRedirect(request.getContextPath() + "/a.jsp");
	}

}
