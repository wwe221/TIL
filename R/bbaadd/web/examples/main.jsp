<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!--   Core JS Files   -->
<script src="/bbaadd/assets/js/core/jquery.min.js"></script>
<script src="/bbaadd/assets/js/core/popper.min.js"></script>
<script src="/bbaadd/assets/js/core/bootstrap.min.js"></script>
<script src="/bbaadd/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<!-- Place this tag in your head or just before your close body tag. -->
<!-- Chart JS -->
<script src="/bbaadd/assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="/bbaadd/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script src="/bbaadd/assets/js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->
<script src="/bbaadd/assets/demo/demo.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$()
								.ready(
										function() {
											$sidebar = $('.sidebar');
											$navbar = $('.navbar');
											$main_panel = $('.main-panel');

											$full_page = $('.full-page');

											$sidebar_responsive = $('body > .navbar-collapse');
											sidebar_mini_active = true;
											white_color = false;

											window_width = $(window).width();

											fixed_plugin_open = $(
													'.sidebar .sidebar-wrapper .nav li.active a p')
													.html();

											$('.fixed-plugin a')
													.click(
															function(event) {
																if ($(this)
																		.hasClass(
																				'switch-trigger')) {
																	if (event.stopPropagation) {
																		event
																				.stopPropagation();
																	} else if (window.event) {
																		window.event.cancelBubble = true;
																	}
																}
															});

											$(
													'.fixed-plugin .background-color span')
													.click(
															function() {
																$(this)
																		.siblings()
																		.removeClass(
																				'active');
																$(this)
																		.addClass(
																				'active');

																var new_color = $(
																		this)
																		.data(
																				'color');

																if ($sidebar.length != 0) {
																	$sidebar
																			.attr(
																					'data',
																					new_color);
																}

																if ($main_panel.length != 0) {
																	$main_panel
																			.attr(
																					'data',
																					new_color);
																}

																if ($full_page.length != 0) {
																	$full_page
																			.attr(
																					'filter-color',
																					new_color);
																}

																if ($sidebar_responsive.length != 0) {
																	$sidebar_responsive
																			.attr(
																					'data',
																					new_color);
																}
															});

											$('.switch-sidebar-mini input')
													.on(
															"switchChange.bootstrapSwitch",
															function() {
																var $btn = $(this);

																if (sidebar_mini_active == true) {
																	$('body')
																			.removeClass(
																					'sidebar-mini');
																	sidebar_mini_active = false;
																	blackDashboard
																			.showSidebarMessage('Sidebar mini deactivated...');
																} else {
																	$('body')
																			.addClass(
																					'sidebar-mini');
																	sidebar_mini_active = true;
																	blackDashboard
																			.showSidebarMessage('Sidebar mini activated...');
																}

																// we simulate the window Resize so the charts will get updated in realtime.
																var simulateWindowResize = setInterval(
																		function() {
																			window
																					.dispatchEvent(new Event(
																							'resize'));
																		}, 180);

																// we stop the simulation of Window Resize after the animations are completed
																setTimeout(
																		function() {
																			clearInterval(simulateWindowResize);
																		}, 1000);
															});

											$('.switch-change-color input')
													.on(
															"switchChange.bootstrapSwitch",
															function() {
																var $btn = $(this);

																if (white_color == true) {

																	$('body')
																			.addClass(
																					'change-background');
																	setTimeout(
																			function() {
																				$(
																						'body')
																						.removeClass(
																								'change-background');
																				$(
																						'body')
																						.removeClass(
																								'white-content');
																			},
																			900);
																	white_color = false;
																} else {

																	$('body')
																			.addClass(
																					'change-background');
																	setTimeout(
																			function() {
																				$(
																						'body')
																						.removeClass(
																								'change-background');
																				$(
																						'body')
																						.addClass(
																								'white-content');
																			},
																			900);

																	white_color = true;
																}

															});

											$('.light-badge')
													.click(
															function() {
																$('body')
																		.addClass(
																				'white-content');
															});

											$('.dark-badge')
													.click(
															function() {
																$('body')
																		.removeClass(
																				'white-content');
															});
										});
					});
</script>
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<script>
	window.TrackJS && TrackJS.install({
		token : "ee6fab19c5a04ac1a32a645abde4613a",
		application : "black-dashboard-free"
	});
</script>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<title>Black Dashboard by Creative Tim</title>
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<!-- Nucleo Icons -->
<link href="assets/css/nucleo-icons.css" rel="stylesheet" />
<!-- CSS Files -->
<link href="assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">

	<div class="wrapper">
		<div class="sidebar">
			<!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
    -->
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="main.sh" class="simple-text logo-mini"> BD
					</a> <a href="main.sh" class="simple-text logo-normal">
						BASD </a>
				</div>
				<ul class="nav">
					<li><a href="first.sh"> <i
							class="tim-icons icon-chart-pie-36"></i>
							<p>First</p>
					</a></li>
					<li><a href="second.sh"> <i
							class="tim-icons icon-puzzle-10"></i>
							<p>Second</p>
					</a></li>
					<li><a href="third.sh"> <i class="tim-icons icon-pin"></i>
							<p>Third</p>
					</a></li>
				</ul>
			</div>
		</div>


		<div class="main-panel">
			<div class="content">
				<c:choose>
					<c:when test="${center == null }">
						<jsp:include page="center.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="${center }.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>



	<footer class="footer">
		<div class="container-fluid">
			<div class="copyright">
				©
				<script>
					document.write(new Date().getFullYear())
				</script>
				2018 made with <i class="tim-icons icon-heart-2"></i> by <a
					href="javascript:void(0)" target="_blank">Creative Tim</a> for a
				better web.
			</div>
		</div>
	</footer>
	</div>


</body>

</html>
