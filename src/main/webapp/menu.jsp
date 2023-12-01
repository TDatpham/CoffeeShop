<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
      span.circle {
        background: #e3e3e3;
        border-radius: 50%;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        color: #6e6e6e;
        display: inline-block;
        font-weight: bold;
        line-height: 15px;
        margin-right: 5px;
        text-align: center;
        width: 15px;
        font-size: 10px;
       background-color:pink;
        
      }
    </style>

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

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container-fluid">
    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!-- Navbar brand -->
      <a class="navbar-brand mt-2 mt-lg-0" href="HomeService">
        <img
          src="https://w7.pngwing.com/pngs/441/249/png-transparent-white-coffee-cappuccino-espresso-ristretto-coffee-logo-coffee-bean.png"
          height="40px"
          style="border-radius: 11%;"
          alt=" Logo"
          loading="lazy"
        ><span> My app</span>
      </a>
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
      	<c:forEach var ="list" items="${listcafetra}" >
      		<li class="nav-item">
          		<a class="nav-link" href="DisplayCoffee?loai_id=<c:out value='${list.loai_id}' />&ten_loai=<c:out value='${list.ten_loai}' /> "> <c:out value="${list.ten_loai}"></c:out> </a>
        	</li>
      	</c:forEach>

        <li class="nav-item">
          <a class="nav-link" href="DisplayOther">Other</a>
        </li>
      </ul>
      <!-- Left links -->
      <!-- search -->
    	
    	<form class="d-flex input-group w-auto" style="margin-bottom: 6px; margin-right: 20px" action="SearchService" method="post">
      		<input
        		type="search"
        		class="form-control rounded"
        		placeholder="Search"
        		aria-label="Search"
        		aria-describedby="search-addon"
        		name="txtSearch"
        		value="${requestScope.save_search}"
        		required ='required'
      		/>
      		<span class="input-group-text border-0" id="search-addon"> 
        		<button type="submit" style=" padding: 0; border: none; background: none;"> <i class="fas fa-search"></i> </button>
      		  </span> 
    	</form>
    
    	<!--  -->
      
      
      
    </div>
    <!-- Collapsible wrapper -->

	
	

    <!-- Right elements -->
    <div class="d-flex align-items-center">
    	
    
      <!-- Icon -->
      <a class="text-reset me-3" href="<%= request.getContextPath()%>/cart.jsp">
        <i class="fas fa-shopping-cart"></i>
		<span class="circle">${quantityofcart}</span>
      </a>
		
      <!-- Notifications -->
     

      <!-- Avatar -->
      <div class="dropdown">
        <a
          class="dropdown-toggle d-flex align-items-center hidden-arrow"
          href="#"
          id="navbarDropdownMenuAvatar"
          role="button"
          data-mdb-toggle="dropdown"
          aria-expanded="false"
        >
          <img
            src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
            class="rounded-circle"
            height="25"
            alt="Black and White Portrait of a Man"
            loading="lazy"
          >
        </a>
        <ul
          class="dropdown-menu dropdown-menu-end"
          aria-labelledby="navbarDropdownMenuAvatar"
        >
          <li>
            <a class="dropdown-item" href="#">My profile</a>
          </li>
          <li>
            <a class="dropdown-item" href="<%= request.getContextPath()%>/NewOrder">New Bill</a>
          </li>
          <li>
            <a class="dropdown-item" href="<%= request.getContextPath()%>/ListOder">Sales history</a>
          </li>
          <li>
            <a class="dropdown-item" href="<%= request.getContextPath()%>/LogoutUser">Logout</a>
          </li>
        </ul>
      </div>
    </div>
    <!-- Right elements -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->


<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"
></script>
