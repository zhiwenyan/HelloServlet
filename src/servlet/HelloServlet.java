package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloServlet implements Servlet {
	public HelloServlet() {
		System.out.println("HelloServlet Constructs");

	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}
	
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}
	/**
	 * ServletConfig  封装了 Servlet的配置信息
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		String user=servletConfig.getInitParameter("user");
		System.out.println(user); //root
		Enumeration<String> enumeratios=servletConfig.getInitParameterNames();
		while (enumeratios.hasMoreElements()) {
			String name = enumeratios.nextElement();
			String value=servletConfig.getInitParameter(name);//获取Value
			System.out.println(name);
			System.out.println(value);
		}
		
		System.out.println(servletConfig.getServletName());
		ServletContext servletContext=	servletConfig.getServletContext();
		String path=servletContext.getContextPath();
		System.out.println(path);
		String driver=servletContext.getInitParameter("driver");
		System.out.println(driver);
		Enumeration<String> sEnumeration=servletContext.getInitParameterNames();
		while (sEnumeration.hasMoreElements()) {
			String name1 = (String) sEnumeration.nextElement();
			System.out.println(name1);
			String value1=servletContext.getInitParameter(name1);
			System.out.println(value1);
		}
		
		ClassLoader classLoader=getClass().getClassLoader();
		InputStream inputStream=classLoader.getResourceAsStream("note.txt");
		System.out.println(inputStream);
		InputStream inputStream1= servletContext.getResourceAsStream("note.txt");
		System.out.println(inputStream1);		
	} 
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}
}
