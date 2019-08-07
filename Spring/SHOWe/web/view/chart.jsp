<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
#chart {
	text-align: center;
	position: relative;
	left: 20px;
}
.img {
	position: relative;
	background-image:
		url('view/img/monitor.png');
	width: 390px;
	height: 275px;
	background-size: cover;
	padding-left: 15px;
	padding-top: 15px;
}
.newcontent{
	width: 400px;
	height: 300px;
}
.img-cover {
	position: absolute;
	height: 100%;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.7);
	z-index: 1;
}

.img .content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 5rem;
	color: white;
	z-index: 2;
	text-align: center;
}
.boxO{
	
}
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
		$
				.ajax({
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
			var str = "";

			$('#chart').append(
					'<tr><th><h5>' + name
							+ "&nbsp&nbsp&nbsp&nbsp</h5></th><th><h5>" + lat
							+ " 명 </h5></th></tr>");

		});
	}
</script>
<div class="img">
<span class="boxO">주간 박스오피스 순위</span>
	<div id="chart">	</div>
</div>
