<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
	$(document).ready(function() {

		getData2();
	});
	var key = "298fb66cdb0e78493a307a5f6cc7b71f";
	var targetWeek = "";
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	targetWeek = yyyy + mm + dd - 7;
	function getData2() {
		$.ajax({
					url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=298fb66cdb0e78493a307a5f6cc7b71f&weekGb=0&targetDt='
							+ targetWeek,
					success : function(data) {
						parsing2(data);
					}
				});
	};
	function parsing2(data) {
		var ts = $(data).find('weeklyBoxOffice');
		var markerPosition3;
		ts.each(function(index, item) {
			if ($(this).find('rank').text() == 6) //상위 5개
				return false;
			var marker5;
			var name = $(this).find('movieNm').text();
			var lat = $(this).find('audiAcc').text();
			var str="";			
			$('#chart').append('<h2>' + name +" <h4>"+lat +"명 </h4></h2>");
		});
	}
</script>
</head>
<div class="center_page">
	<div id="mvscreen">
		<div id="chart"></div>
	</div>
</div>