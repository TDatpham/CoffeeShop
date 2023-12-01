
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>User Management</title>
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
				<a href="#" class="navbar-brand"> User </a>
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
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<br>

			<hr>
			<div class="container text-left">

				<a href="UserController?act=new" class="btn btn-success">Add New
					User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Username</th>
						<th>Password</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.user_id}" /></td>
							<td><c:out value="${user.user_name}" /></td>
							<td><c:out value="${user.pass_word}" /></td>
							<td><c:out value="${user.ten_nguoi_dung}" /></td>
							<td><c:out value="${user.sdt}" /></td>
							<td><a
								href="UserController?act=edit&user_id=<c:out value='${user.user_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a
								href="UserController?act=delete&user_id=<c:out value='${user.user_id}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="HistoryUser?user_id=<c:out value='${user.user_id}' />">History</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>
