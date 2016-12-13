package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public uploadServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 ��ȡFileItem���� ��
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024*500);//500K
		//�������500K��ŵ���ʱ�ļ���
		File temp=new File("d:\\temp");
		factory.setRepository(temp);
		//����һ���ϴ��ļ���Handler
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		servletFileUpload.setFileSizeMax(1024*1024*5);//�����ܵĴ�С
		try {
			//����Items
			List<FileItem> items=servletFileUpload.parseRequest(request);
			for (FileItem fileItem : items) {
				if(fileItem.isFormField()){  //����  ��ӡ��Ϣ
					String name=fileItem.getFieldName();
					String value=fileItem.getString();
					System.out.println(name+","+value);
				}else{
					//�ļ���  ���浽d:\\files��
					String fieldName=fileItem.getFieldName();
					String fileName=fileItem.getName();
					String[] names=fileName.split("\\\\");
					String contentType=fileItem.getContentType();
					long size=fileItem.getSize();
					System.out.println(fieldName+","+fileName+","
							+contentType+","+size);
					InputStream inputStream=fileItem.getInputStream();
					byte[] buff=new byte[1024];
					int len=0;
					fileName="d:\\files\\"+names[names.length-1];
					System.out.println(fileName);
					OutputStream outputStream=new FileOutputStream(fileName);	
					while ((len=inputStream.read())!=0) {
						outputStream.write(buff,0,len);	
					}
					outputStream.close();
					inputStream.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
