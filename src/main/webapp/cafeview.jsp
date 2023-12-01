<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style2.css" rel="stylesheet" type="text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css"
	rel="stylesheet" />
<title>Coffe View</title>



			
			
</head>
<body>
<!---- thanh navbar	--->
	<jsp:include page="menu.jsp"></jsp:include>
<!---- 	--->
<h1 class = "divh3">${requestScope.ten_loai}</h1>
 <!-- card san pham -->


<!--  card -->

	<div class="flex-container">
		<c:forEach var="list" items="${listproduce}">
			<div class="div0">
				<div class="div1">
				<a href="DetailController?thucdon_id=<c:out value='${list.thucdon_id}'/>">
					<img src="<c:out value="Photos/${list.images}" ></c:out>"
						alt="card" class="image1" /> 
						<div style="background-color: rgba(251, 251, 251, 0.15);"></div>
					</a>
				</div>
				<div class="div22">
					<a style="color:black;" href="DetailController?thucdon_id=<c:out value='${list.thucdon_id}'/>" >
					<h5 class="card-title">
						<c:out value="${list.ten_mon}"></c:out>
					</h5>
					</a>
					<p class="card-text">
						<c:out value="${list.don_gia}"></c:out> đ
					</p>
					
				</div>
			</div>
		</c:forEach>
			
	</div>
	<!--   -->

<!--  -->

<div  class="divprevent">
<!-- footer -->

<jsp:include page="footer.jsp"></jsp:include>

<!-- footer -->
</div>


<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
</body>
</html>