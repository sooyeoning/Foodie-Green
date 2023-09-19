<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/signin_email.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="../home/header.jsp" %>
	<p class="signin_title paddingtop120">회원가입</p>
	<div id="emailForm" class="center">

	<p class="font20 bottom0">이메일</p>
	<div class="font15 top1vh pointcolor " id="email_msg"></div>
	<input type="email" class="input" placeholder="이메일을 입력해주세요" id="email" >
	<button class="email_check" onclick="email_check();">이메일 중복확인</button>
	
	<p class="font20 bottom0">이메일 인증번호</p>
	<div class="font15 top1vh pointcolor" id="secretkey_msg"></div>
	<div class="emailDiv">
	<input type="text" class="input" placeholder="인증번호를 입력해주세요" id="inputkey" >
	<div class="emailBtn">
	<button class="sendSecretkeyBtn" onclick="sendSecretkey();">요청</button>
	<button class="authSecretkeyBtn" onclick="authSecretkey();">확인</button>
	</div></div>
	<!--
	<input type="text" placeholder="인증번호 입력" id="email_auth_key"> -->
	<button type="button" class="formCheckbtn bottom10" id="formCheckbtn" onclick="checkForm();">다음 단계로 이동</button>
	
	</div>
	<%@ include file="../home/footer.jsp"%>
	
</body>

  
</html>
