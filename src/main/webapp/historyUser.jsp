<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css"
  rel="stylesheet"
/>
<title>History User</title>
</head>
<body>


<!--  -->
	<%! int stt=1; %>
	

<c:forEach var="hoa_don" items="${dshoadon}">
<div class="card">
  <div class="card-body mx-4">
    <div class="container">
      <p class="my-5 mx-5" style="font-size: 30px;">Hóa Đơn &nbsp;<%= stt %><% stt++;%> </p>
      <div class="row">
      
        <ul class="list-unstyled">
          
          <li class="text-muted mt-1"><span class="text-black">Id Hóa đơn: </span> <c:out value="${hoa_don.hoadon_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Id Người bán: </span> <c:out value="${hoa_don.user_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Id Bàn: </span> <c:out value="${hoa_don.ban_id}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Ngày tạo: </span> <c:out value="${hoa_don.create_at}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Tên người mua: </span> <c:out value="${hoa_don.ten_nguoi_mua}"> </c:out> </li>
          <li class="text-muted mt-1"><span class="text-black">Phone number: </span> <c:out value="${hoa_don.so_dien_thoai}"> </c:out> </li>
          	
        </ul>
        
        <c:forEach items="${dschitiethoadon}" var="chitiet">
        <c:if test="${chitiet.hoadon_id == hoa_don.hoadon_id }">
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
        		
        

        </c:if>
        </c:forEach>
       
        <hr style="border: 2px solid black;">
      <div class="row text-black">

        <div class="col-xl-12">
          <p class="float-end fw-bold">Total: <c:out value="${hoa_don.thanh_tien}"></c:out> đ
          </p>
        </div>
        <hr style="border: 2px solid black;">
      </div>


    </div>
  </div>
</div>
</div>
</c:forEach>
<% stt=1; %>

<!--  -->
</body>
</html>