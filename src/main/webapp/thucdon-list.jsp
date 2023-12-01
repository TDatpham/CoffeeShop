<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>
<style>
	.image1{
		height:200px;
		weight:200px;
	}
	.div-right {
	position: absolute;
	right: 10%;
}
</style>
<title>ThucDon Management</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="<%= request.getContextPath()%>/UserController" class="navbar-brand"> User </a>
			</div>
			
			<div>
				<a href="" class="navbar-brand"> Thực Đơn</a>
			</div>

			<div>
				<a href="<%= request.getContextPath()%>/LoaiController" class="navbar-brand"> Loại</a>
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
			<h3 class="text-center">Danh sách Thực Đơn</h3>
			<br>

			<hr>
			<div class="container text-left">

				<a href="ThucDonController?act=new" class="btn btn-success">Thêm thực đơn mới</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						
						<th>Id </th>
						<th>Tên Món</th>
						<th>Image</th>
						<th>Đơn giá </th>
						<th>Loại </th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
			
					
					<c:forEach var="thucdon" items="${listthucdon}">
						<tr>
							
					
							<td><c:out value="${thucdon.thucdon_id}"></c:out></td>
							<td><c:out value="${thucdon.ten_mon}"></c:out></td>
							<td><img src="<c:out value="Photos/${thucdon.images}"></c:out>" alt="Girl in a jacket" class="image1"> </td>
							<td><c:out value="${thucdon.don_gia}"></c:out></td>
							<td><c:out value="${thucdon.loai_id}"></c:out></td>
							<td><a
								href="ThucDonController?act=edit&thucdon_id=<c:out value='${thucdon.thucdon_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="ThucDonController?act=delete&thucdon_id=<c:out value='${thucdon.thucdon_id}' />">Delete</a></td>
						</tr>


					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>