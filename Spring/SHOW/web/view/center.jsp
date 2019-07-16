<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
#newcontent{
width:797px;
height : 550px;
background: skyblue;
}

#newchart{
}

#map{

}

</style>

<div class="center_page">
	<section class="center_page">
		<%-- <jsp:include page="chart.jsp"></jsp:include> --%>

		<div id="newcontent">
			<h5>최신 정보 슬라이드 제공</h5>
		</div>

		<div id="newchart">
			<h5>사용자 리뷰 기판 차트 제공</h5>
		</div>

		<div id="map">
			<h5>사용자 위치 주변 추천 장소 제공</h5>
		</div>

	</section>
</div>