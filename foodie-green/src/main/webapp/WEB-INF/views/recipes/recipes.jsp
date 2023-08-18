<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/recipes/imsiheaderfooter.css">
<link rel="stylesheet" href="/css/recipes/recipes.css">
<script defer="defer" src="js/recipes/recipes.js"></script>
<title>recipes</title>
</head>
<body>
	<header class="header">
		<nav class="navbar">
			<ul class="nav-list">
				<li><a href="/">Home</a></li>
				<li><a href="/recipes">Recipes</a></li>
				<!-- Add more menu items here -->
			</ul>
		</nav>
	</header>

	<h2 style="">오늘의 채소 요리는?</h2>
	<div class="input-container">
		<a href="fgrecipes">푸드앤그린 레시피</a>
		<a href="diary">식단일기</a>
		<a href="recipeswrite">북마크</a>
	<!-- 	<a href="recipeswrite">레시피 페이퍼</a> -->
	</div>
	<br>
	<div class="searchdiv">
		<input id="search" placeholder="요리나 재료를 검색해보세요!"> <input
			id="searchbutton" type="image" src="/img/recipes/heart (2).png"
			alt="검색">

		<div class="tag-container">
			<input type="button" value="전체"> <input type="button"
				value="중파"> <input type="button" value="혼합오곡"> <input
				type="button" value="유럽상추"> <input type="button" value="가지">
			<input type="button" value="완숙토마토"> <input type="button"
				value="미니단호박"> <input type="button" value="오이고추"> <input
				type="button" value="팽이버섯"><br> <input type="button"
				value="풋귤"> <input type="button" value="복숭아"> <input
				type="button" value="오이"> <input type="button" value="할라피뇨">
			<input type="button" value="표고버섯"> <input type="button"
				value="서리태 두유"> <input type="button" value="고수"> <input
				type="button" value="애호박"> <input type="button"
				value="흑보리개역"> <input type="button" value="바질">
		</div>
	</div>
	<div class="recipes-container">
		<div>
			<a href="/" >푸디앤그린 레시피 N ></a><br>
			<div class="recipes-buttons">
				<button id="recipes-button"></button>
				<button id="recipes-button"></button>
			</div>
			<div>
				<a href="/">HOT 인기 레시피 ></a><br>
				<div class="recipes-buttons">
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
				</div>
			</div>

			<div>
				<a href="/">내 채소 맞춤 레시피 ></a><br>
				<div class="recipes-buttons">
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
					<button id="recipes-button2"></button>
				</div>
			</div>

			<div>
				<a href="/">최신 레시피 N ></a><br>
				<div class="recipes-buttons">
					<button id="recipes-button3"></button>
					<button id="recipes-button3"></button>
					<button id="recipes-button3"></button>
					<button id="recipes-button3"></button>
				</div>
			</div>
		</div>
	</div>
	<div class="floating-button-wrapper">
		<div class="floating-button">
			<span class="move-recipes">
				<button class="recipes-btn">+업로드</button>
			</span>
			<div class="write-dropdown">
				<a href="recipeswrite">레시피</a><br>
				 <a href="diarywrite">식단일기</a>
			</div>
		</div>
	</div>


	<footer class="footer">
		<p>&copy; 2023 Your Company. All rights reserved.</p>
	</footer>
</body>
</html>