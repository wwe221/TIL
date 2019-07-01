<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<style>
</style>
<script>
	
</script>
<body>
	<h1>Product List page</h1>
	<div class="center_page">
		<h1>User List page</h1>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th>regdate</th>
							<th>imgname</th>

						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th>regdate</th>
							<th>imgname</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="p" items="${plist}">
							<h5>
								<tr>
									<td><a href="product.do?cmd=productdetail&id=${p.id}">${p.id}</a>
									<td>
									<td>${p.name}</td>
									<td>${p.price}</td>
									<td>${p.regdate}</td>
									<td>${p.imgname}</td>
							</h5>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>