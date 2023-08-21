<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/recipes/recipesdetail.css">
<script defer="defer" src="/js/recipes/recipesdetail.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<header>
		<%@ include file="../home/header.jsp"%>
	</header>
	<div class="main-container">
<div class="main-container">
	<h2>${recipes.recipe_name}</h2>
	안녕
	<img src="${recipes.photo}" alt="이미지" />
	<p>Category: ${recipes.category}</p>
	<p>Hashtags: ${recipes.hashtag}</p>
	<!-- 다른 필드들도 이와 같이 표시할 수 있습니다 -->
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
	<footer>
		<%@ include file="../home/footer.jsp"%>
	</footer>
</body>
</html>