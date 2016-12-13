<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<!-- enctype="multipart/form-data" 设置成二进制文件-->
	<form action="uploadServlet" method="post"
		enctype="multipart/form-data">
		File:<input type="file" name="file"><br> desc:<input type="text"
			name="desc"><input type="submit" value="submit">
	</form>

</body>
</html>