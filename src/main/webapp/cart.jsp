<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/cartStyle.css" rel="stylesheet" type="text/css">
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
<title>Shopping cart checkout</title>

</head>
<body>

	<section class="h-100 h-custom" style="background-color: #eee;">
		<div class="container h-100 py-5">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card shopping-cart" style="border-radius: 15px;">
						<div class="card-body text-black">

							<div class="row">
								<div class="col-lg-6 px-5 py-4">

									<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Your
										products</h3>

									<c:forEach var="item" items="${cart.items}">
										<!-- san pham -->
										<div class="d-flex align-items-center mb-5">
											<div class="flex-shrink-0">
												<img src="Photos/<c:out value='${item.thucdon.images}'/>"
													class="img-fluid" style="width: 150px;"
													alt="Generic placeholder image">
											</div>
											<div class="flex-grow-1 ms-3">
												<!-- remove san pham -->
												<a
													href="<%=request.getContextPath()%>/AddAndRemove?num=0&id=<c:out value='${item.thucdon.thucdon_id }' />"
													class="float-end text-black"><i class="fas fa-times"></i></a>
												<!--  -->
												<h5 class="text-primary">
													<c:out value="${item.thucdon.ten_mon }"></c:out>
												</h5>
												<div class="d-flex align-items-center">
													<p class="fw-bold mb-0 me-5 pe-3">
														<c:out value="${item.price}"></c:out>
														<span style="text-decoration: underline;">đ</span>
													</p>
													<div class="def-number-input number-input safari_only">
														<a
															href="<%=request.getContextPath()%>/AddAndRemove?num=-1&id=<c:out value='${item.thucdon.thucdon_id }' />">
															<button class="minus"></button>
														</a> <input class="quantity fw-bold text-black"
															name="quantity" type="number"
															value='<c:out value="${item.quantity }"></c:out>' /> <a
															href="<%=request.getContextPath()%>/AddAndRemove?num=1&id=<c:out value='${item.thucdon.thucdon_id }' />">
															<button class="plus"></button>
														</a>

													</div>
												</div>
												<h6 style="color: black;">
													Sum:
													<c:out value="${item.price * item.quantity}"></c:out>
													<span style="text-decoration: underline;">đ</span>
												</h6>
											</div>
										</div>
									</c:forEach>
									<!-- san pham -->
		

								

									<hr class="mb-4"
										style="height: 2px; background-color: #1266f1; opacity: 1;">


									<div class="d-flex justify-content-between p-2 mb-2"
										style="background-color: #e1f5fe;">
										<h5 class="fw-bold mb-0">Total:</h5>
										<h5 class="fw-bold mb-0">${cart.getTotalMoney()}
											<span style="text-decoration: underline;">đ</span>
										</h5>
									</div>

								</div>
								<div class="col-lg-6 px-5 py-4">

									<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>
									
									<!-- lay thong tin -->
									<form class="mb-5" method="post" action="BuyController">


										<div class="form-outline mb-5">
											<input type="text" id="typeName" name="buyer_name"
												class="form-control form-control-lg" size="17"
												required="required" /> <label class="form-label"
												for="typeName">Name</label>
										</div>

										<div class="form-outline mb-5" >
											<input name="buyer_number" type="text" id="typeText"
												class="form-control form-control-lg" size="17"
												required="required"  maxlength="19" /> <label
												class="form-label" for="typeText">Phone Number</label>
										</div>

										<fieldset class="form-group" style="margin-bottom:10px;">
											<label >Chọn Bàn</label>
												<select name="ban_id" class="form-control" >
													<c:forEach var="ban" items="${dstable}">
														
														<c:if test="${ban.status}">
															<option value="${ban.ban_id}" > ${ban.ten_ban}</option>
														</c:if>
													</c:forEach>
												</select>
										</fieldset>
										
										<h3 > Table list</h3>
										
										<div style="  padding: 12px; border-radius: 15px; ">
											
											<c:forEach var="table" items="${dstable}"> 		
													<div style=" margin-bottom: 12px;  ">
												 <label class="badge rounded-pill badge-light" style="font-size: 20px; ">${table.ten_ban}</label>
												<c:choose>
													<c:when test="${table.status}">
														<span class="badge badge-success" style="font-size: 15px; margin-right:30px;">Còn Trống</span>
													</c:when>
															
													<c:otherwise>
														<span class="badge badge-danger" style="font-size: 15px;">Đang Bận</span>
													</c:otherwise>
													
												</c:choose>
												<a href="<%= request.getContextPath()%>/ResetTableService?id_ban=<c:out value='${table.ban_id}'/>"><button type="button" class="btn btn-outline-info" data-mdb-ripple-color="dark">Reset</button></a> 
												<br>
														</div>
												</c:forEach>
											
										</div>

										<p class="mb-5" style="text-align: center;">Chi tiêu cho
											bản thân không bao giờ là lãng phí.</p>

										<button type="submit" class="btn btn-primary btn-block btn-lg">Buy
											now</button>

										<h5 class="fw-bold mb-5"
											style="position: absolute; bottom: 0;">
											<a href="<%=request.getContextPath()%>/HomeService"><i
												class="fas fa-angle-left me-2"></i>Back to shopping</a>
										</h5>

									</form>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- script -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
	<!--  -->

</body>
</html>