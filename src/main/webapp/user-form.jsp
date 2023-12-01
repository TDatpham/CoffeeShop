<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>User Form</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="#" class="navbar-brand"> User Management Application </a>
			</div>

		</nav>
	</header>
	
	<br>
	
	<div class="container col-md-5">
	
		<div class="card">
		
			<div class="card-body">
			
				<c:if test="${user != null}">
					<form action="UserController?act=update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="UserController?act=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="user_id" value="<c:out value='${user.user_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Username</label> <input type="text"
						value="<c:out value='${user.user_name}' />" class="form-control"
						name="user_name" required="required">
				</fieldset>
					
				<fieldset class="form-group">
					<label>User Password</label> <input type="text"
						value="<c:out value='${user.pass_word}' />" class="form-control"
						name="pass_word" required="required">
				</fieldset>	
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.ten_nguoi_dung}' />" class="form-control"
						name="ten_nguoi_dung" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Phone</label> <input type="text"
						value="<c:out value='${user.sdt}' />" class="form-control"
						name="sdt" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
				
			</div>
			
		</div>
		
	</div>
</body>
</html> 