<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/signin.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css"/>

</head>
<body>
	<div class="menu">메뉴</div>
	<p class="signin_title">회원가입</p>
	<form method="post" id="signinForm">
	<p class="font20">이름</p>
	<input type="text" class="input" placeholder="이름을 입력해주세요" id="name" name="name">
	<p class="font20">닉네임</p>
	<input type="text" class="input" placeholder="닉네임을 입력해주세요" id="nickname" name="nickname">
	<p class="font20 bottom0">이메일</p>
	<p class="font15 top1vh pointcolor">비밀번호 찾을때 인증메일이 가는 주소입니다.</p>
	<input type="email" class="input" placeholder="이메일을 입력해주세요" id="email" name="email">
	<!-- <button class="email_check">이메일 중복확인</button> -->
	<!-- <button class="email_auth_btn">인증번호 요청</button>
	<input type="text" placeholder="인증번호 입력" id="email_auth_key"> -->
	<p class="font20 bottom0">비밀번호</p>
	<p class="font15 top1vh pointcolor">영문,숫자,특수문자 조합으로 이루어진 6~15자리 비밀번호</p>
	<input type="text" class="input" placeholder="비밀번호를 입력해주세요" id="pw" name="pw">
	<p class="font20">휴대폰 번호</p>
	<input type="text" class="input" placeholder="휴대폰 번호를 입력하세요" id="phone" name="phone">
	<button type="button" class="signinbtn">회원가입 완료</button>
	</form>
</body>
</html>
