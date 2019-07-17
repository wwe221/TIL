<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="js/myjs.js"></script>
<style>
#board {
	margin: 0 auto;
	padding-left: 300px;
	padding-top: 200px;
	width: 95%;
}
#title_field {
	width: 500px;
}
#content_field {
	width: 500px;
	height: 550px;
	resize: none;	
}
#comment_field {
	width: 500px;
	height: 200px;
	resize:none;
	
}

.post-detail td {
	border: 1px solid black;
}

.cmt_list {
	list-style: none;
	margin: 0;
}

.cmt_list_each {
	padding-top: 10px;
}

.bf_update {
	display: none;
}

.boxline {
	border-bottom-style: dashed;
	border-bottom-width: 1px;
	opacity: 0.3;
}

.detail {
	width: 100%;
	padding: 1rem;
}

.detail_img {
	width: 150px;
}

.detail_list {
	list-style: none;
}

.detail_review {
	width: 100%;
}
.rightBox{
float: right;
}
.detail_text{
	padding: 1.25rem;
	height:45vh;
}
.input_comm{
	width:100%;
}
</style>

<div class="center_page">
	<h1>Detail Page</h1>
	<!-- User가 작성한 게시글 리스트에서 하나 선택하면 여기로 이동 -->
	<!-- content 정보와 user가 작성한 게시글이 떠야됨 + 댓글 -->
	<!-- 댓글은 입력 후 등록이 가능하도록 -->
	<div class="detail">
		<table>
			<tr>
				<td class="detail_review">
					<table>
						<tbody>
							<tr valign="top">
								<td><span class=""> ${postdetail.title} </span></td>
								<td style="opacity: 0.5;">|</td>
								<td>${postdetail.pdate }</td>
								<td style="opacity: 0.5;">|</td>
								<td class="rightBox">${postdetail.writer}</td>
							</tr>
						</tbody>
					</table>
					<table class="rightBox">
						<tbody>
							<tr>
							<td>
							<c:choose>
							<c:when test="${postdetail.writer == loginuser.id}">
								<a href="postupdate.sh?id=${postdetail.id}">UPDATE</a>
								<a href="postdelete.sh?id=${postdetail.id }&cate=${postdetail.category}">DELETE</a>
							</c:when>
							</c:choose>
							</td>
							</tr>
						</tbody>
					</table>
					<div class="boxline"></div>
					<div class="detail_text">${postdetail.text}!!</div>
					
				<td>
					<ul class="detail_list">
						<c:if test="${contdetail.category ==1 }">
							<li><img src="${contdetail.poster}" class="detail_img"></li>
							<li><span>제목</span> :${contdetail.title}</li>
							<li><span>개봉일</span>: ${contdetail.open}</li>
							<li><span>장르</span>:${contdetail.genre}</li>
							<li><span>감독</span> :${contdetail.director}</li>
							<li><span>출연</span> :${contdetail.actor1} ,
								${contdetail.actor2} , ${contdetail.actor3}</li>
							<li><span>상영시간</span> :${contdetail.time}</li>
							<li><span>등급</span> :${contdetail.grade}</li>
							<li><span>평점</span> :${contdetail.rating}</li>
						</c:if>

						<!--  -->

						<c:if test="${contdetail.category ==2 }">
							<li><img src="${contdetail.poster}" class="detail_img"></li>
							<li><span>제목</span> :${contdetail.title}</li>
							<li><span>개막일</span>: ${contdetail.open}</li>
							<li><span>폐막일</span>: ${contdetail.close}</li>
							<li><span>종류</span>:${contdetail.genre}</li>
							<li><span>장소</span> :${contdetail.place}</li>

						</c:if>
					</ul>
				</td>
		</table>
		<!-- 종류와 콘텐츠 입력 값은 사용자 선택 값을 받아서 뿌려줌 -->
		<!-- content 정보도 표시해야 됨 -->

		<%-- <a href="#" onclick="down_menu('downmenu')"><h1>test</h1></a>
				<div class="downmenu">				
        		<a class="dropdown-item" href="mypage.sh?id=${loginuser.id }">My page</a>        
    	      	<a class="dropdown-item" href="mypost.sh">My Post</a>
    	      	</div>
	        	</div>  --%>
		<div class="boxline"></div>
		
	</div>
	<ul class="cmt_list">
		<c:forEach var="comm" items="${comments}">
			<li>
				<div class="com_list_each">${comm.writer}/${comm.regdate}</div>
				<div id="${comm.id}ori" class="origin_text">
					<p>${comm.text}</p>
				</div> <c:choose>
					<c:when test="${comm.writer == loginuser.id}">
						<button onclick="myShowFunction('${comm.id}')">수정</button>
						<div id="${comm.id}div" class="bf_update">
							<button onclick="myShowFunction('${comm.id}')">수정취소</button>
							<form action="postupdateimpl.sh" method="POST">
								<textarea class="input_comm" name="text">${comm.text}</textarea>
								<input type="hidden" name="id" value="${comm.id}"> <input
									type="hidden" name="title" value="${comm.title}"> <input
									type="hidden" name="contents" value="${comm.contents}">
								<input type="hidden" name="category" value="${comm.category}">
								<input type="hidden" name="writer" value="${comm.writer}">
								<input type="hidden" name="img1" value="${comm.img1}"> <input
									type="hidden" name="img2" value="${comm.img2}"> <input
									type="hidden" name="img3" value="${comm.img3}"> <input
									type="hidden" name="reid" value="${comm.reid}"> <input
									type="submit" value="수정">
							</form>
						</div>
						<a href="postdelete.sh?id=${comm.id}&cate=99">삭제</a>
					</c:when>
				</c:choose>
			</li>
			<hr>
		</c:forEach>
	</ul>


	<form action="postcommentadd.sh" method="POST">
		<table id="comment_field">
			<tr>
				<td><textarea name="text"></textarea></td>
			</tr>
			<tr>
				<td><input type="hidden" name="title" value="comment">
					<input type="hidden" name="category" value="99"> <input
					type="hidden" name="reid" value="${postdetail.id}"> <input
					type="hidden" name="contents" value="1"> <input
					type="hidden" name="writer" value="${loginuser.id}"> <input
					type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</div>