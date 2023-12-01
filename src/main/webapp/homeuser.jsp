<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style1.css" rel="stylesheet" type="text/css">
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

<title>Home Page</title>
<style>
</style>
</head>
<body>
	<!-- menu -->
	<jsp:include page="menu.jsp"></jsp:include>
	<!--  -->

	<!--  carosel -->
		<div id="carouselExampleCaptions" class="carousel slide" data-mdb-ride="carousel">
  <div class="carousel-indicators">
    <button
      type="button"
      data-mdb-target="#carouselExampleCaptions"
      data-mdb-slide-to="0"
      class="active"
      aria-current="true"
      aria-label="Slide 1"
    ></button>
    <button
      type="button"
      data-mdb-target="#carouselExampleCaptions"
      data-mdb-slide-to="1"
      aria-label="Slide 2"
    ></button>
    <button
      type="button"
      data-mdb-target="#carouselExampleCaptions"
      data-mdb-slide-to="2"
      aria-label="Slide 3"
    ></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" data-mdb-interval="2000">
      <img src="https://images.unsplash.com/photo-1497935586351-b67a49e012bf?auto=format&fit=crop&q=80&w=2071&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="d-block w-100" alt="Wild Landscape" height="600"/>
      <div class="carousel-caption d-none d-md-block">
        <!-- <h5>First slide label</h5> -->
        <p>Đảm bảo 100% cà phê nguyên chất.</p>
      </div>
    </div>
    <div class="carousel-item" data-mdb-interval="2000">
      <img src="https://images.unsplash.com/photo-1459755486867-b55449bb39ff?auto=format&fit=crop&q=80&w=2069&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="d-block w-100" alt="Camera" height="600"/>
      <div class="carousel-caption d-none d-md-block">
        <!-- <h5>Second slide label</h5> -->
        <p>Hương vị đậm đà từng thìa cà phê.</p>
      </div>
    </div>
    <div class="carousel-item" data-mdb-interval="2000">
      <img src="https://images.unsplash.com/photo-1523906630133-f6934a1ab2b9?auto=format&fit=crop&q=80&w=1854&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="d-block w-100" alt="Exotic Fruits" height="600" />
      <div class="carousel-caption d-none d-md-block">
        <!-- <h5>Third slide label</h5> -->
        <p>Trà xanh tươi 100%, chắc chắn làm bạn hài lòng.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	<!-- - -->
	
	
	
	
	
	
	
	<div class="divh3">
		<h3>Món Mới</h3>
	</div>




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

	<div  class="divprevent">
<!-- footer -->

<jsp:include page="footer.jsp"></jsp:include>

<!-- footer -->
</div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
</body>
</html>