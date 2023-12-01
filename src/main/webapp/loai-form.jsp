 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Loai Form</title>
</head>
<body>
	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<span  class="navbar-brand"> Loai Management </span>
			</div>

	
		</nav>
	</header>
	
	<br>
	
	<div class="container col-md-5">
	
		<div class="card">
		
			<div class="card-body">
			
				<c:if test="${loai != null}">
					<form action="LoaiController?act=update" method="post">
					
				</c:if>
				<c:if test="${loai == null}">
					<form action="LoaiController?act=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${loai != null}">
            			Sửa Loại
            		</c:if>
						<c:if test="${loai == null}">
            			Thêm Loại mới
            		</c:if>
					</h2>
				</caption>

				<c:if test="${loai != null}">
					<input type="hidden" name="loai_id" value="<c:out value='${loai.loai_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Tên Loại</label> <input type="text"
						value="<c:out value='${loai.ten_loai}' />" class="form-control"
						name="ten_loai" required="required">
				</fieldset>
					
				<button type="submit" class="btn btn-success">Save</button>
				</form>
				
			</div>
			
		</div>
		
	</div>
	
	
</body>
</html> 