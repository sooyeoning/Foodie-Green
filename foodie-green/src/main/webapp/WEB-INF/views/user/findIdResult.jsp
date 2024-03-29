<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/findIdResult.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="../home/header.jsp"%>

	<div class="center paddingtop120" >
		<p class="title">이메일 찾기</p>
		<div class="box">
			<p>${response }</p>
			<button class="signinBtn">회원가입</button>
			<button class="findPwBtn2">비밀번호 찾기</button>
		</div>
	</div>
	
	<%@ include file="../home/footer.jsp"%>
	
</body>

<style>
.box{
	background-color: white; 
	height: 300px; 
	width:30vw; 
	border: 1px solid #FFB3A7;
	text-align: center;
}
.findPwBtn2, .signinBtn{
    margin: auto 2px;
    height: 30px;
    font-size: 20px;
    cursor: pointer;
    border: 2px solid #FFB3A7;
    background-color: #FFB3A7;
    color: white;
    margin-top: 2vh;
    margin-bottom: 6vh;
    border-radius: 10px;
}
</style>

</html>

