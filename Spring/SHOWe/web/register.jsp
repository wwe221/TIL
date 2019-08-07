<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SHOWer 회원가입</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("input[name='id']").keypress(function () { // blur는 동작이 사라진 후 실행		
		if ($(this).val().length >= 3) {
			$("input[name='nickname']").removeAttr('disabled');
		} // 요소를 비활성화 하는 'disabled'이용하여 조건에 따라 입력창 제어
		else {
			$("input[name='nickname']").attr('disabled');
			$('#idlable').text("ID를 세 글자 이상 입력해주세요.");
			
		}
	});	
	$("input[name='nickname']").keypress(function () {
		if ($(this).val().length >= 1) {
			$("input[name='pwd']").removeAttr('disabled');
		}
		else {
			$("input[name='pwd']").attr('disabled');
			$('#nicklable').text("Nickname을 입력해주세요.");
		}
	});
	$("input[name='pwd']").keypress(function () {
		if ($(this).val().length >= 3) {
			$("input[name='pwdck']").removeAttr('disabled');
		}
		else {
			$("input[name='pwdck']").attr('disabled');
			$('#pwdlable').text("password를 다섯글자 이상  입력해주세요.");
		}
	});
	
	$("input[name='pwdck']").keypress(function () {
		if ($(this).text() == $('input[name=pwd]').text()) {
			$("input[name='email']").removeAttr('disabled');
		}
		else {
			$("input[name='email']").attr('disabled');
			$('#pwdcklable').css("color","red").text("password를 다시 확인해주세요.");
		}
	});
	$("input[name='email']").keypress(function () {
		if ($(this).val().length > 1) {
			$("input[name='register']").removeAttr('disabled');
		}
		else {
			$("input[name='register']").attr('disabled');
			$('#emaillable').text("email을 다시 확인해주세요.");
		}
	});
});
</script>
</head>

<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header"><a href="main.sh">SHOWer</a></div>
      <div class="card-body">
        <form action="useraddimpl.sh" method="POST">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="firstName" name="id"class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                  <label for="firstName" id="idlable">아이디</label>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="lastName" name="nickname" class="form-control" placeholder="Last name" required="required" disabled>
                  <label for="lastName" id="nicklable">별명<label>
                </div>
              </div>
            </div>
          </div>
          
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="inputPassword" name="pwd" class="form-control" placeholder="Password" required="required" disabled>
                  <label for="inputPassword" id="pwdlable">비밀번호</label>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" name="pwdck" class="form-control" placeholder="Confirm password" required="required" disabled>
                  <label for="confirmPassword" id="pwdcklable">비밀번호 확인</label>
                </div>
              </div>
            </div>
		  </div>
		  <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required="required" disabled>
              <label for="inputEmail" id="emaillable">이메일 주소</label>
            </div>
          </div>
		  <input type="hidden" value="default" name=icon>
          <input type="submit" name="register" class="btn btn-primary btn-block" value="가입하기" disabled>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">로그인하기</a>
          <!-- <a class="d-block small" href="forgot-password.html">Forgot Password?</a> -->
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
