<%@page import="model.Loai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>Food Form</title>


</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<span  class="navbar-brand"> Thuc Don Management </span>
			</div>
			
		</nav>
	</header>

	<br>
	
	<div>
			
				
		
			
		
	</div>
	<div class="container col-md-5">

		<div class="card">


			<div class="card-body">

				<c:if test="${thucdon != null}">
					<form action="ThucDonController?act=update" method="post" enctype="multipart/form-data">
				</c:if>
				<c:if test="${thucdon == null}">
					<form action="ThucDonController?act=insert" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${thucdon != null}">
            			Sửa Thực Đơn
            			</c:if>
						<c:if test="${thucdon == null}">
            			Thêm Thực Đơn mới
            			</c:if>
					</h2>
				</caption>

				<c:if test="${thucdon != null}">
					<input type="hidden" name="thucdon_id"
						value="<c:out value='${thucdon.thucdon_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Tên Món</label> <input type="text"
						value="<c:out value='${thucdon.ten_mon}' />" class="form-control"
						name="ten_mon" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Hình ảnh</label> <input type="file"
						value="<c:out value='${thucdon.images}' />" class="form-control"
						name="images" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Đơn giá</label> <input type="text"
						value="<c:out value='${thucdon.don_gia}' />" class="form-control"
						name="don_gia" required="required">
				</fieldset>

				<fieldset class="form-group">
							<label >Loại</label>
							<select name="loai_id" class="form-control" >
								<c:forEach var="loai" items="${listLoai1}">
								<option value="${loai.loai_id}" > ${loai.loai_id}</option>
								</c:forEach>
							</select>
				</fieldset>
				


				<button type="submit" class="btn btn-success">Save</button>
				</form>

			</div>

		</div>

	</div>


</body>
</html>