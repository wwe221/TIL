<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SHOWer</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand " href="main.sh"><img src="view/img/SHOWer.png">&nbsp;SHOWer</a>
 
    <button class="btn btn-link btn-sm order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <!-- <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"> -->
      <div class="input-group">
      <!--   <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2"> -->
        <div class="input-group-append">
        <!--   <button class="btn btn-primary" type="button">
            <i class="fas fa-search"></i>
          </button> -->
        </div>
      </div>
<!--     </form> -->

		<c:choose>
			<c:when test="${loginuser.admin ==1}">
				<a href="adminmode.sh">관리자모드<i class="fas fa-cogs"></i></a>
			</c:when>
		</c:choose>

		<!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow mx-1">
      </li>
         <li>
     <c:choose>
	<c:when test="${loginuser != null }">
		<c:choose>
		<c:when test="${loginuser.admin == 1}"><div>Admin</div>
		<a class="dropdawn-item" href="#" data-toggle="modal" data-target="#logoutModal">로그아웃</a>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">        
          <div class="dropdown-divider"></div>
        </div>
		</c:when>
		<c:otherwise>
		</ul>		
		<a class="user_nick" href="mypage.sh?id=${loginuser.id }">${loginuser.nickname }</a>	
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="user_icon fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="mypage.sh?id=${loginuser.id }">마이페이지</a>                
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">로그아웃</a>
        </div>      
		</c:otherwise>
		</c:choose>
	</c:when>	
	<c:otherwise>
	<div class="mainsigninup">
		<a class="dropdown-item" href="login.jsp">로그인<i class="fas fa-sign-in-alt"></i></a>
          <a class="dropdown-item" href="register.jsp">회원가입</a>
          </div>
	</c:otherwise>
	</c:choose>
      </li>
    </ul>
  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="main.sh">
          <!-- <i class="fas fa-fw fa-tachometer-alt"></i> -->
          <i class="fas fa-home"></i>
          <span>홈</span>
        </a>
      </li>     
      <li class="nav-item">
        <a class="nav-link" href="movie.sh">
      	<i class="fas fa-video"></i>
          <span>영화</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="pe.sh">
          <i class="fas fa-fw fa-table"></i>
          <span>공연 / 전시</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="music.sh">
         <i class="fas fa-music"></i>
          <span>음악</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="drama.sh">        
         <i class="far fa-file-video"></i>
          <span>드라마</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="404.sh">        
         <i class="far fa-file-video"></i>
          <span>404</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">
 		<section class="center_page">
			<c:choose>
				<c:when test="${center==null}">
				<jsp:include page="center.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
				<jsp:include page="${center }.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</section>
		
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">SHOWer</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">로그아웃 하시겠습니까?</div>
        <div class="modal-footer">
        <a class="btn btn-primary" href="logout.sh">&nbsp;&nbsp;&nbsp;예&nbsp;&nbsp;&nbsp;</a>
          <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>
          
        </div>
      </div>
    </div>
  </div>

<!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <!-- <script src="vendor/chart.js/Chart.min.js"></script> -->
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>
  <script src="js/myjs.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>
  <!-- <script src="js/demo/chart-area-demo.js"></script> -->
  


</body>

</html>
