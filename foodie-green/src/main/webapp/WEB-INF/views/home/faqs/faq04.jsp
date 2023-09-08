<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/home/main.css">
<link rel="stylesheet" href="/css/home/faq.css">
<link rel="stylesheet" href="/css/home/faq-tile.css">
</head>
<body style="background-color: rgb(244, 243, 242);">
	<!-- header -->
	<%@ include file="/WEB-INF/views/home/header.jsp"%>
	<!-- body -->
	<%@ include file="/WEB-INF/views/home/body(faq).jsp"%>
	<div class="tile-container">
		<div class="left-tile">
			<%@ include file="/WEB-INF/views/home/faq_left_tiles/faq_left_tile04.jsp"%>
		</div>
		<div class="right-tile">
			<%@ include file="/WEB-INF/views/home/faq_right_tiles/faq_right_tile04.jsp"%>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/home/footer.jsp"%>
	
	<script>
const toggleLink = document.querySelector('.toggle-link');
const container = document.querySelector('.container');
const content = document.querySelector('.content');

toggleLink.addEventListener('click', function() {
  if (container.style.maxHeight) {
    container.style.maxHeight = null; // 초기 높이로 되돌림
  } else {
    container.style.maxHeight = content.scrollHeight + 'px'; // 컨텐츠의 높이로 설정
  }
});
</script>
</body>
</html>