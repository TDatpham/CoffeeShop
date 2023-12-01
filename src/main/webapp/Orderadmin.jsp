<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>List Of Orders</title>
<style>
.div-right {
	position: absolute;
	right: 10%;
}
</style>
</head>
<body>

<!--  -->

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="<%= request.getContextPath()%>/UserController" class="navbar-brand"> User </a>
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
				<a href=""
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
<!--  -->
<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Orders</h3>
			<br>

			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Table Id</th>
						<th>Total Money</th>
						<th>User Id</th>
						<th>Date Created</th>
						<th>Customer</th>
						<th>Phone Of Customer</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="list" items="${danhsach_hd}">

						<tr>
							<td><c:out value="${list.hoadon_id}"></c:out> </td>
							<td><c:out value="${list.ban_id}"></c:out> </td>
							<td><c:out value="${list.thanh_tien}"></c:out> </td>
							<td><c:out value="${list.user_id}"></c:out> </td>
							<td><c:out value="${list.create_at}"></c:out> </td>
							<td><c:out value="${list.ten_nguoi_mua}"></c:out> </td>
							<td><c:out value="${list.so_dien_thoai}"></c:out> </td>
							<td>
								<a
								href="EachUserOrderDetail?hoadon_id=<c:out value='${list.hoadon_id}' /> ">Detail</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>


	
</body>
</html>