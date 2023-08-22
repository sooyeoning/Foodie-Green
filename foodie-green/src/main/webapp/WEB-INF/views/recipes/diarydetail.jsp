<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/recipes/diarydetail.css">
<script defer="defer" src="/js/recipes/diarydetail.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var user = "${sessionScope.user}";
		var isLoggedIn = "${sessionScope.login}" == 'ok';
		var loggedInUserNickname = user ? user.nickname : '';
		var loggedInUserNickname = "${sessionScope.nickname}"; // 로그인한 사용자의 닉네임
		var writer = "${diary.writer}"; // 글 작성자의 닉네임
		var diary_id = "${diary.id}"; // JSP에서 diary_id 값을 가져옴
	</script>

	<!-- header -->
	<header style="margin-top: -22px;">
		<%@ include file="../home/header.jsp"%>
	</header>

	<h2>${diary.writer}의식단일기</h2>

	<div class="img-sum">
		<img alt="이미지" src="${diary.photo }">
	</div>

	<div class=detail-container>

		<div class="detail-title">
			<span class="title-date">${diary.title}</span>
			<div class="title-actions">
				<input class="title-like like-button" type="button" value="좋아요">
				<input class="title-like" type="button" value="신고하기">
				<button id="delete-button" style="display: none;">글 삭제</button>
				<button id="edit-button" style="display:none;">글 수정</button>
			</div>
		</div>


		<div class="detail-content">
			<div class="detail-user">
				<span style="font-size: 14px;">${diary.writer }</span><br> <span
					style="font-size: 12px;">${diary.writing }</span><br>
			</div>

			<div class="contents">

				<span style="font-size: 18px;">${diary.contents}</span> <br>
			</div>

			<!-- 			<div class="detail-tag">
				<input type="button" value="가지"> <input type="button"
					value="토마토">
			</div> -->

			<span style="font-size: 18px;">좋아요 ${diary.likecnt}</span>
		</div>
	</div>



	<div class="floating-button-wrapper">
		<div class="floating-button">
			<span class="move-recipes">
				<button class="recipes-btn">+업로드</button>
			</span>
			<div class="write-dropdown">
				<a href="recipeswrite">레시피</a><br> <a href="diarywrite">식단일기</a>
			</div>
		</div>
	</div>



	<!-- footer -->
	<footer style="margin-top: 10%;">
		<%@ include file="../home/footer.jsp"%>
	</footer>
</body>
</html>