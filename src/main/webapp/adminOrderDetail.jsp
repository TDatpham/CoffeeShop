<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Order Detail of User</title>
</head>
<body>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Order Detail of User</h3>
			<br>

			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Id Thực Đơn</th>
						<th>Tên Món</th>
						<th>Quantity</th>
						<th>Đơn giá </th>
						<th>Thành Tiền</th>
						
					</tr>
				</thead>
				<tbody>

					<c:forEach var="list" items="${chitiethoadon_admin}">

						<tr>
							<td><c:out value="${list.hoadon_id}"></c:out> </td>
							<td><c:out value="${list.thucdon_id}"></c:out> </td>
							<td><c:out value="${list.tenThucDonById(list.thucdon_id)}"></c:out> </td>
							<td><c:out value="${list.so_luong}"></c:out> </td>
							<td><c:out value="${list.don_gia}"></c:out> </td>
							<td><c:out value="${list.don_gia * list.so_luong}"></c:out> </td>
							
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</body>
</html>