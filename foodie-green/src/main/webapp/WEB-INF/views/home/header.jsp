<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/home/main.css">

</head>
<body>
<header>
		<div class="menu">
			<span><a href="/"><img src="/img/favicon.png" alt="로고 이미지" class="favicon"></a></span>
			<span><a href="/store">야채가게</a></span>
			<span><a href="/recipes">레시피</a></span>
			<span><a href="">브랜드 소개</a></span>
			<span><a href="/faq">고객센터</a></span>
			
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<% 
String login=null;
String username =null;
if((String)session.getAttribute("login")!=null && (UserDTO)session.getAttribute("user")!=null){
	login=(String)session.getAttribute("login");
	UserDTO userdto = (UserDTO)session.getAttribute("user");
	username = userdto.getName();
}

if (login==null){%>
			<span style="float:right; "><a href="/login" style="color:black; font-weight:700;">로그인</a></span>
		<%}else if (login!=null){ %>
			<span style="float:right; "><a href="/mypage"><%=username %>님</a></span>
			<span style="float:right; "><a href="/logout" style="color:black; font-weight:700;">로그아웃</a></span>
		<% }%>
		</div>
	</header>
</body>

</html>
