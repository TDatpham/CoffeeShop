<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Detail</title>
</head>
<body>
<!-- menu -->
	<jsp:include page="menu.jsp"></jsp:include>
	<!--  -->
	
	
	
	<!-- detail produce -->
		<main class="mt-5 pt-4">
    <div class="container mt-5">
        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <img src="Photos/<c:out value='${thucdon.images}'/>" class="img-fluid" alt="" />
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <!--Content-->
                
                <div class="p-4">
                	<h3><c:out value="${thucdon.ten_mon}"></c:out> </h3>
                    <div class="mb-3">
                        <a href="">
                            <span class="badge bg-dark me-1">Category <c:out value="${thucdon.loai_id}"></c:out>  </span>
                        </a>
    
                    </div>

                    <p class="lead">

                        <span> <c:out value="${thucdon.don_gia}"></c:out> đ</span>
                    </p>

                    <strong><p style="font-size: 20px;">Description</p></strong>

                    <p>Một sản phẩm tuyệt vời bạn nên thử qua một lần trong đời.</p>

                    <form class="d-flex justify-content-left" method="post" action="ProcessController">
                        <!-- Default input -->
                        <div class="form-outline me-1" style="width: 100px;" >
                            <input type="number" name="sldetail" min="1" value="1" class="form-control"/>
                            <input type="hidden" name="iddetail"  value="<c:out value='${thucdon.thucdon_id}' />" />
                        </div>
                        <button class="btn btn-primary ms-1" type="submit">
                            Add to cart
                            <i class="fas fa-shopping-cart ms-1"></i>
                        </button>
                    </form>
                </div>
                <!--Content-->
            </div>
            <!--Grid column-->
        </div>
        <!--Grid row-->

        <hr />


    </div>
</main>
	<!--  -->
	<!-- footer -->

<jsp:include page="footer.jsp"></jsp:include>

<!-- footer -->

<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
		
</body>
</html>