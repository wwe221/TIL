<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.listtable{
margin : 0 auto;
padding-left : 300px;
padding-top : 200px;
width : 900px;
border : 1px solid black;
text-align : center;
}

.listtable > thead {
background: #dddddd;
}

.writetable{
margin : 0 auto;
padding-left : 300px;
padding-top : 200px;
width : 900px;
}

#write_field{
width : 800px;
resize : none; <!-- textarea 사이즈고정 -->
}
</style>
<script>
String mapping = "";
if(p.star == 0){
	mapping="☆☆☆☆☆";
}
else if(p.star == 1){
	mapping = "★☆☆☆☆";
}
else if(p.star == 2){
	mapping = "★★☆☆☆";
}
else if(p.star == 3){
	mapping="★★★☆☆";
}
else if(p.star == 4){
	mapping="★★★★☆";
}
else {
	mapping="★★★★★";
}

</script>
<div class="center_page">
<h1>Music Page!!</h1>
<table class="listtable">
<thead>
<tr><td>평점</td><td>제목</td><td>아티스트</td><td>감상평</td>
<td>글쓴이</td><td>작성일</td></tr></thead>
<!-- 감상평은 길어진 것 대비하여 사이즈 조정해야됨 -->
<tbody>
<!-- 지금 tbody에 입력된 것은 테스트용! 여기에 실제 DB에 저장 된 리뷰가 표시될 곳 -->
<c:forEach var="p" items="${plist}">
	<c:choose>
	<c:when test = "${p.category eq 3 }">
		<tr>
		<td><script type="text/javascript"> document.write(mapping); </script></td>
		<td>${p.title }</td>
		<td>벤</td>
		<td>${p.text }</td>
		<td>${p.writer }</td>
		<td>${p.regdate }</td>
		</tr>
	</c:when>
	</c:choose>
</c:forEach>


</tbody>
</table>
<br>
<br>

<form action="postaddimpl.sh" method="POST">
<table class="writetable">
<tbody>

<tr><td>제목</td><td><input type="text" name="title" id="write_field" placeholder="제목을 입력해주세요"></td></tr>
<tr><td>아티스트</td><td><input type="text" name="artist" id="write_field" placeholder="아티스트명을 입력해주세요"></td></tr>
<!-- music에서 아티스트명 함께 표시하려면 DB에 추가해야 됨 -->
<tr><td>감상평</td><td><textarea name="text" id="write_field" placeholder="감상평을 입력해주세요"></textarea></td></tr>
<!-- 작성자에 대한 정보와 날짜는 user가 입력하는게 아니라 받아오기 -->
<tr><td>평점</td>
<td>
<select name="star" name="score">
<option value="">별점을 선택해주세요</option>
<option value="1">★☆☆☆☆ 1</option>
<option value="2">★★☆☆☆ 2</option>
<option value="3">★★★☆☆ 3</option>
<option value="4">★★★★☆ 4</option>
<option value="5">★★★★★ 5</option>
</select>
</td>
</tr>

<tr><td colspan=2 style="text-align:center"><input type="submit" value="확인"></td></tr>
</tbody>
</table>
<input type="hidden" name="writer" value="${loginuser.id}">
<input type="hidden" name="category" value="3">
<input type="hidden" name="contents" value="659">
<input type="hidden" name="nav" value="music">

</form>
</div>