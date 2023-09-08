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
	<%@ include file="../home/header.jsp"%>
	<!-- body -->
	<%@ include file="../home/body(faq).jsp"%>
	<div class="tile-container">
		<div class="left-tile">
			<%@ include file="../home/faq_left_tile.jsp"%>
		</div>
		<div class="right-tile">
			<%@ include file="../home/faq_right_tile.jsp"%>
		</div>
	</div>
	<!-- footer -->
	<%@   include file="../home/footer.jsp" %> 
</body>
</html>