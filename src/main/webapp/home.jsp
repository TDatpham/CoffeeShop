<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>User Management</title>
<title>Home Page</title>
<style>
.div-right {
	position: absolute;
	right: 10%;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="<%=request.getContextPath()%>/UserController" class="navbar-brand"> User </a>
			</div>

			<div>
				<a href="<%=request.getContextPath()%>/ThucDonController"
					class="navbar-brand"> Thực Đơn</a>
			</div>

			<div>
				<a href="<%=request.getContextPath()%>/LoaiController"
					class="navbar-brand"> Loại</a>
			</div>
			
			<div>
				<a href="<%=request.getContextPath()%>/OrderController"
					class="navbar-brand"> Orders</a>
			</div>
			
			<div class="div-right"
				style="margin-right: 15px; color: pink; font-size: 20px;">

				<span style="margin-right: 15px; color: pink; font-size: 15px;"> Welcome: ${session_name} </span> 
				
				<a href="<%=request.getContextPath()%>/LogoutService" style="color: white; font-size: 15px;"> Logout </a>
			</div>

		</nav>
	</header>
</body>
</html>