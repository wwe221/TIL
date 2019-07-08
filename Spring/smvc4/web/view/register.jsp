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
	var map;
	$(document).ready(function() {
		var container = document.getElementById('map');
		var options = {
			center : new daum.maps.LatLng(36.500701, 126.670667),
			level : 12
		};
		map = new daum.maps.Map(container, options);
		// 마커가 지도 위에 표시되도록 설정합니다
		getData();
	});
	function getData() {
		$.ajax({
					url : 'https://openapi.gg.go.kr/Genrestrtcate?KEY=8e7d6b47a26a42659109342ac75c05da&Type=xml&pindex=1&pSize=600',
					success : function(data) {
						parsing(data);
					}
				});
	};
	function parsing(data) {
		var ts = $(data).find('row');
		var markerPosition3;
		ts.each(function(index, item) {
			var marker5;
			var name = $(this).find('BIZPLC_NM').text();
			var lat = $(this).find('REFINE_WGS84_LAT').text();
			var log = $(this).find('REFINE_WGS84_LOGT').text();
			markerPosition3 = new daum.maps.LatLng(lat, log);
			marker5 = new daum.maps.Marker({
				position : markerPosition3
			});
			marker5.setMap(map);
			var moveLatLon = new kakao.maps.LatLng(lat, log);
			map.setCenter(moveLatLon);
			var iwContent = '<div style="padding:5px;">' + name + '</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				content : iwContent
			});
			// 마커에 마우스오버 이벤트를 등록합니다
			kakao.maps.event.addListener(marker5, 'mouseover', function() {
				// 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
				infowindow.open(map, marker5);
			});
			// 마커에 마우스아웃 이벤트를 등록합니다
			kakao.maps.event.addListener(marker5, 'mouseout', function() {
				// 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
				infowindow.close();
			});
			kakao.maps.event.addListener(marker5, 'click', function() {
				// 마커 위에 인포윈도우를 표시합니다
				map.setCenter(moveLatLon);
				map.setLevel(9);
			});
		});
	}
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}

	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {

	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;

	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	}    
</script>
</head>
<div class="center_page">
	<spring:message code="welcome.txt" arguments="hi,mulcam" />
	<h1>Register Page</h1>	
		<div id="map" style="width: 500px; height: 500px;"></div>

</div>
