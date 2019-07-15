<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#board{
margin : 0 auto;
padding-left : 300px;
padding-top : 200px;
}

#title_field {
width : 500px;
}

#content_field {
width:500px;
height : 550px;
resize : none; <!-- textarea의 크기 조정 방지 -->
}

</style>

<div class="center_page">
	<h1>Post Update Page</h1>

	<form action="postupdateimpl.mc" method="POST"
		enctype="multipart/form-data"> <!-- 사진 때문에 추가함 -->

<table id="board">
<tbody>
<tr><td colspan=2><h5>리뷰쓰기</h5></td></tr>
<tr><td>종류</td><td>선택한 콘텐츠 이름 출력</td></tr>
<!-- 종류와 콘텐츠 입력 값은 사용자 선택 값을 받아서 뿌려줌 -->

<tr><td>제목</td><td><input type="text" name="title" id="title_field" value="${postupdate.title} "></td></tr>
<!-- <tr><td>사진첨부</td><td><input type="file" name="img01" value="${postupdate.img01}"></td></tr> -->
<tr><td>내용</td><td><textarea name="text" id="content_field" value="${postupdate.text }" ></textarea></td></tr>

<tr><td>평점</td>
<td>
<select name="star" name="score">
<!-- 평점의 value 추가 해야됨 -->
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

	</form>

</div>