 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Loai Management</title>
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
				<a href="<%= request.getContextPath()%>/UserController" class="navbar-brand"> User </a>
			</div>
			
			<div>
				<a href="<%= request.getContextPath()%>/ThucDonController" class="navbar-brand"> Thực Đơn</a>
			</div>

			<div>
				<a href="" class="navbar-brand"> Loại</a>
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
			<h3 class="text-center">Danh sách Loại</h3>
			<br>

			<hr>
			<div class="container text-left">

				<a href="LoaiController?act=new" class="btn btn-success">Thêm loại mới</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id </th>
						<th>Tên Loại</th>
						<th>Action </th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="loai" items="${listLoai}">
						<tr>

							<td><c:out value="${loai.loai_id}"></c:out></td>
							<td><c:out value="${loai.ten_loai}">
								</c:out></td>
							<td><a
								href="LoaiController?act=edit&loai_id=<c:out value='${loai.loai_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="LoaiController?act=delete&loai_id=<c:out value='${loai.loai_id}' />">Delete</a></td>
						</tr>


					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html> 