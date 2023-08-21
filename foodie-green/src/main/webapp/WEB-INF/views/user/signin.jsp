<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<%@ include file="../home/header.jsp"%>

	<p class="signin_title paddingtop120">회원가입</p>
	<div id="signinForm">
	<p class="font20 bottom0">이름</p>	
	<div class="font15 top1vh pointcolor" id="name_msg"> </div>
	<input type="text" class="input" placeholder="이름을 입력해주세요" id="name" >
	
	<p class="font20 bottom0">닉네임</p>
	<div class="font15 top1vh pointcolor" id="nickname_msg"></div>
	<input type="text" class="input" placeholder="닉네임을 입력해주세요" id="nickname" > 
	<button class="nick_check" onclick="nick_check();">닉네임 중복확인</button>
	
	<p class="font20 bottom0">이메일</p>
	<div class="font15 top1vh pointcolor " id="email_msg"></div>
	<input type="email" class="input" placeholder="이메일을 입력해주세요" id="email" >
	<button class="email_check" onclick="email_check();">이메일 중복확인</button>
	<!--
	<p class="font20 bottom0">이메일 인증번호 받기</p>
	<input type="text" class="input" placeholder="인증번호를 입력해주세요" id="secretkey" >
	<button class="secretkey_check" onclick="secretkey_check();">인증번호 받기</button>
	<div class="font15 top1vh pointcolor" id="secretkey_msg"></div>
	
	<button class="email_auth_btn">인증번호 확인</button>
	<input type="text" placeholder="인증번호 입력" id="email_auth_key"> -->
	
	<p class="font20 bottom0">비밀번호</p>
	<p class="font15 top1vh pointcolor " id="pw_msg">영문,숫자,특수문자 조합으로 이루어진 6~15자리 비밀번호</p>
	<input type="text" class="input" placeholder="비밀번호를 입력해주세요" id="pw">
	
	<p class="font20 bottom0">휴대폰 번호</p>
	<div class="font15 top1vh pointcolor " id="phone_msg"></div>
	<input type="text" class="input" placeholder="휴대폰 번호를 입력하세요" id="phone">
	 
	<button type="button" class="signinbtn" >회원가입 완료</button>
	</div>
	<%@ include file="../home/footer.jsp"%>
	
</body>

  
</html>
