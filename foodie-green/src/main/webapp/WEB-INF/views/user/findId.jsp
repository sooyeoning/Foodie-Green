<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/findId.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="../home/header.jsp"%>

	<form action="/findId" model="findIdReq" method="post">
		<div class="center paddingtop120" >
		<p class="title">이메일 찾기</p>
		<p class="font20">이름</p>
		<input type="text" class="input" name="name" placeholder="이름을 입력해주세요" id="name">
		<p class="font20">휴대폰 번호</p>
		<input type="text" class="input" name="phone" placeholder="휴대폰 번호를 입력하세요" id="phone">
		<button type="submit" class="findIdbtn">이메일 찾기</button>
		</div>
	</form>
	
	<%@ include file="../home/footer.jsp"%>
	
</body>
</html>
