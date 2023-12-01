<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div>
		<form action ="UploadServlet"	method ="post"  enctype="multipart/form-data" >
			ID: <input type="text" name="id"><br><br>
			Name: <input type="text" name="name"><br><br>
			<input type="file" name="image"><br><br>
			<input type ="submit" name="Upload">
		</form>
	</div>
</body>
</html>