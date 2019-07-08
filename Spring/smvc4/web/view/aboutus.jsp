<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>About us</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<script>
	function chart1(pdata) {
		// Create the chart
		Highcharts.chart('container',{
		chart : {
			type : 'column'},
		title : {
			text : 'Browser market shares. January, 2018'},
			subtitle : {
			text : 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'},
			xAxis : {
			type : 'category'
			},
			yAxis : {
				title : {
				text : 'Total percent market share'
				}
			},
			legend : {
				enabled : false
			},
			plotOptions : {
				series : {
					borderWidth : 0,
					dataLabels : {
						enabled : true,
						format : '{point.y:.1f}%'}
				}
			},
			tooltip : {
				headerFormat : '<span style="font-size:11px">{series.name}</span><br>',
				pointFormat : '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'},
				series : [ {
					name : "Browsers",
					colorByPoint : true,
					data : pdata
				} ]
			});
	};
	$(document).ready(function() {
		$.ajax({
			url : 'pchart.mc',
			success : function(data) {
				chart1(data);
			}
		})

	});
</script>
<body>
	<h1>Olla, we are students</h1>
	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>