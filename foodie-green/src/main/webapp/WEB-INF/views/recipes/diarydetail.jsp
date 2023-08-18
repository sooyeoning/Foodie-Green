<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<link rel="stylesheet" href="/css/recipes/imsiheaderfooter.css">
<link rel="stylesheet" href="/css/recipes/diarydetail.css">
<script defer="defer" src="js/recipes/diary.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<nav class="navbar">
			<ul class="nav-list">
				<li><a href="/">Home</a></li>
				<li><a href="/recipes">Recipes</a></li>

			</ul>
		</nav>
	</header>

	<h2>연균의 식단일기</h2>

	<div class="img-sum">
		<img alt="이미지" src="img/recipes/imsi.png">
	</div>

	<div class=detail-container>

		<div class="detail-title">
			<span class="title-date">2023년 8월 15일 식단</span> <input
				class="title-like" type="button" value="좋아요"> <input
				class="title-like" type="button" value="신고하기">
		</div>

		<div class="detail-content">
			<div class="detail-user">
				<span style="font-size: 14px;">연균</span><br> <span
					style="font-size: 12px;">2023.08.15</span><br>
			</div>

			<div class="contents">

				<span>내용들</span> <br>
			</div>

			<div class="detail-tag">
				<input type="button" value="가지"> <input type="button"
					value="토마토">
			</div>

			<p>좋아요 N</p>
		</div>
		<p class=selectline></p>
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



	<footer class="footer">
		<p>&copy; 2023 Your Company. All rights reserved.</p>
	</footer>
</body>
</html>