<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/recipes/diary.css ">
<script defer="defer" src="/js/recipes/diary.js"></script>
<title>recipes</title>
</head>
<body>
	<!-- header -->
	<header style="margin-top: -22px;">
		<%@ include file="../home/header.jsp"%>
	</header>


	<h2>구독자 식단일기</h2>

	<br>
	<div class="searchdiv">
		<input id="search" placeholder="요리나 재료를 검색해보세요"> <input
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
	<div class="mydiary-container">
		<input type="checkbox"> <span class="mydiary-title">내
			식단일기만 보기</span> <input class="diary-filter" type="button" value="최신순"
			id="recentButton"> <input class="diary-filter" type="button"
			value="인기순" id="popularButton">
	</div>

	<div id="contentContainer">
		<div id="recentContent" class="content">
			<!-- 서버에서 불러온 최신순 식단일기 목록을 여기에 표시합니다. -->
			<c:forEach var="diary" items="${recentDiaries}">
				<div class="diary-item">
					<a href="/diarydetail/${diary.id}"> <!-- 해당 게시글의 상세 페이지로 링크 -->
						<img src="${diary.photo}" alt="Diary Image">
					</a> <span style="margin:0px; padding:0px;">${diary.writer}</sapn><br><p>${diary.writing}</p>
					<a href="/diarydetail/${diary.id}"> <!-- 해당 게시글의 상세 페이지로 링크 -->
						<p>${diary.contents}</p>
					</a>
						<p style="text-align: right;">좋아요 ${diary.likecnt}</p>
					<!-- 필요한 경우 더 많은 일기 내용을 여기에 추가하세요. -->
				</div>
			</c:forEach>
		</div>
		<div id="popularContent" class="content" style="display: none;">
			<!-- 서버에서 불러온 인기순 식단일기 목록을 여기에 표시합니다. -->
			<c:forEach var="diary" items="${popularDiaries}">
				<div class="diary-item">
					<a href="/diarydetail/${diary.id}"> <!-- 해당 게시글의 상세 페이지로 링크 -->
						<img src="${diary.photo}" alt="Diary Image">
					</a> <span>${diary.writer}</span><br> <span>${diary.writing}</span>
					<a href="/diarydetail/${diary.id}"> <!-- 해당 게시글의 상세 페이지로 링크 -->
						<p>${diary.contents}</p>
					</a>
					<p style="text-align: right;">좋아요 ${diary.likecnt}</p>
					<!-- 필요한 경우 더 많은 일기 내용을 여기에 추가하세요. -->
				</div>
			</c:forEach>
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
	<%@ include file="../home/footer.jsp"%>
</body>
</html>