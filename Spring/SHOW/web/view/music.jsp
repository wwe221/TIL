<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
.listtable {
	margin: 0 auto;
	padding-left: 300px;
	padding-top: 200px;
	width: 900px;
	border: 1px solid black;
	text-align: center;
}

.listtable>thead {
	background: #dddddd;
}

.writetable {
	margin: 0 auto;
	padding-left: 300px;
	padding-top: 200px;
	width: 900px;
}

#write_field {
	width: 800px;
	resize: none;
	<!--
	textarea
	사이즈고정
	-->
}
</style>

<div class="center_page">
	<h1>Music Page!!</h1>
	<div class="card mb-3">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>POST ID</th>
						<th>ARTIST</th>
						<th>TEXT</th>
						<th>Author</th>
						<th>REGDATE</th>
						<th>평점</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${plist}">
						<c:choose>
							<c:when test="${p.category eq 3 }">
								<tr>								
									<td>${p.title }</td>
									<td>${p.img1}</td>
									<td>${p.text }</td>
									<td>${p.writer }</td>
									<td>${p.regdate }</td>
									<td>
										<c:if test="${p.star == 0 }"> </c:if>
										<c:if test="${p.star == 1 }"> ★☆☆☆☆</c:if>
										<c:if test="${p.star == 2 }"> ★★☆☆☆</c:if>
										<c:if test="${p.star == 3 }"> ★★★☆☆</c:if>
										<c:if test="${p.star == 4 }"> ★★★★☆</c:if>
										<c:if test="${p.star == 5 }"> ★★★★★</c:if>
									</td>
									<td>
										 <c:choose>
											<c:when test="${p.writer == loginuser.id}">
											<a href="postdelete.sh?id=${p.id}&cate=3">삭제</a>
											</c:when>
									 	 </c:choose>										
									</td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	<c:choose>
	<c:when test="${loginuser!=null}">
	<form action="postaddimpl.sh" method="POST" name="insertFrm">
		<table class="writetable">
			<tbody>

				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="write_field"
						placeholder="제목을 입력해주세요"></td>
				</tr>
				<tr>
					<td>아티스트</td>
					<td><input type="text" name="img01" id="write_field"
						placeholder="아티스트명을 입력해주세요"></td>
				</tr>
				<!-- music에서 아티스트명 함께 표시하려면 DB에 추가해야 됨 -->
				<tr>
					<td>감상평</td>
					<td><textarea name="text" id="write_field"
							placeholder="감상평을 입력해주세요" onKeydown="len_chk()"></textarea></td>
				</tr>
				<tr>
					<td>평점</td>
					<td><select name="star" name="score">
							<option value="">별점을 선택해주세요</option>
							<option value="1">★☆☆☆☆ 1</option>
							<option value="2">★★☆☆☆ 2</option>
							<option value="3">★★★☆☆ 3</option>
							<option value="4">★★★★☆ 4</option>
							<option value="5">★★★★★ 5</option>
					</select></td>
				</tr>

				<tr>
					<td colspan=2 style="text-align: center">
					<input type="submit" value="확인"></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="writer" value="${loginuser.id}"> 
		<input type="hidden" name="img02" value="1"> 
		<input type="hidden" name="img03" value="1"> 
		<input type="hidden" name="category" value="3"> 
		<input type="hidden" name="contents" value="1"> 
		<input type="hidden" name="nav" value="music">

	</form>
	</c:when>
	</c:choose>
<script type="text/javascript">
	//글자수 제한 체크 
	function len_chk() {
		var frm = document.insertFrm.text;

		if (frm.value.length > 200) {
			alert("글자수는 100자로 제한됩니다.!");
			frm.value = frm.value.substring(0, 200);
			frm.focus();
		}

	}
</script>
</div>