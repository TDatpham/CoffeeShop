<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

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
<title>New Bill </title>
</head>
<body>

<!-- menu -->

	<jsp:include page="menu.jsp"></jsp:include>
<!--  -->

	
	
		
		

		<c:if test="${hoadon1 != null}">
<div class="card">
  <div class="card-body mx-4">
    <div class="container">
      <p class="my-5 mx-5" style="font-size: 30px;">Hóa Đơn</p>
      <div class="row">
      
        <ul class="list-unstyled">
          
          <li class="text-muted mt-1"><span class="text-black">Id Hóa đơn: </span> <c:out value="${hoadon1.hoadon_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Id Người bán: </span> <c:out value="${hoadon1.user_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Id Bàn: </span> <c:out value="${hoadon1.ban_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Ngày tạo: </span> <c:out value="${hoadon1.create_at}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Tên người mua: </span> <c:out value="${hoadon1.ten_nguoi_mua}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Phone number: </span> <c:out value="${hoadon1.so_dien_thoai}"> </c:out> </li>
          	
        </ul>
        
        <c:forEach items="${dschitiethoadon}" var="chitiet">
       
       		<hr>
        		<div class="col-xl-10">
         		 <p><c:out value="${chitiet.tenThucDonById(chitiet.thucdon_id) }"> </c:out> 

         		 	 <span class="" style=" position: absolute;left: 600px;"><c:out value="${chitiet.don_gia}"></c:out> đ
          				</span>

          				<span class=""style=" position: absolute;right: 600px;"><c:out value="${chitiet.so_luong}"></c:out>
          				</span>
         		 </p>
         		 
         		 		
         		 	
        		</div>

        		
                <div class="col-xl-2" >
          			<p class="float-end"><c:out value="${chitiet.don_gia*chitiet.so_luong}"></c:out> đ
          			</p>
        		</div>
        		
        

        
        </c:forEach>
       
        <hr style="border: 2px solid black;">
      <div class="row text-black">

        <div class="col-xl-12">
          <p class="float-end fw-bold">Total: <c:out value="${hoadon1.thanh_tien}"></c:out> đ
          </p>
        </div>
        <hr style="border: 2px solid black;">
        
        <!-- chuueyn den trang in hoa don -->
        <div style="text-align: right; width:100%;	">
        	  <a href="<%= request.getContextPath()%>/DisplayInvoice">
        	  	<button type="button" class="btn btn-outline-dark btn-rounded" data-mdb-ripple-color="dark">Print</button>
        	</a>
        </div>
		<!--  -->
      
      </div>
		

    </div>
  </div>
</div>
</div>
</c:if>

<!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!--  -->
<!-- script -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
	<!--  -->
</body>
</html>