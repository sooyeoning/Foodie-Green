<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.3.0/kakao.min.js"
	integrity="sha384-70k0rrouSYPWJt7q9rSTKpiTfX6USlMYjZUtr1Du+9o4cGvhPAWxngdtVZDdErlh"
	crossorigin="anonymous"></script>
<script>
	Kakao.init('32a3a30cbdb57b878110f956ff7a1ad6'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<link rel="stylesheet" href="/css/home/main.css">
</head>
<body>
	<header>
		<div class="menu">
			<span><a href="/"><img src="/img/favicon.png" alt="로고 이미지"
					class="favicon"></a></span> <span><a href="/store">야채가게</a></span> <span><a
				href="/recipes">레시피</a></span> <span><a href="/vision">브랜드 소개</a></span> <span><a
				href="/faq">고객센터</a></span> <span></span> <span></span> <span></span> <span></span>
			<span></span> <span></span>
			<%
			String login = null;
			String username = null;
			String logintype = null;
			String kakaokey = null;
			if ((String) session.getAttribute("login") != null && (UserDTO) session.getAttribute("user") != null) {
				login = (String) session.getAttribute("login");
				UserDTO userdto = (UserDTO) session.getAttribute("user");
				username = userdto.getName();
				logintype = userdto.getLogintype();
				System.out.println(logintype);
				if (session.getAttribute("kakaoKey") != null) {
					kakaokey = (String) session.getAttribute("kakaoKey");
				}
			}

			if (login == null) {
			%>
			<span style="float: right;"><a href="/login"
				style="color: black; font-weight: 700;">로그인</a></span>
			<%
			} else if (login != null) {
			%>
			<span style="float: right;"><a href="/mypage"><%=username%>님</a></span>
			<%
			if (logintype.equals("normal")) {
			%>
			<span style="float: right;"><a href="/logout"
				style="color: black; font-weight: 700;">로그아웃</a></span>
			<%
			} else if (logintype.equals("kakao")) {
			%>
			<span style="float: right;"><a href="javascript:kakaoLogout()"
				style="color: black; font-weight: 700;">로그아웃</a></span>
			<%
			}
			}
			%>
		</div>
	</header>

	<script type="text/javascript">
	function kakaoLogout(){
		Kakao.Auth.logout()
		  .then(function(response) {
		    console.log(Kakao.Auth.getAccessToken()); // null
		  })
		  .catch(function(error) {
		    console.log('Not logged in.');
		  });
		
		//window.location.href = "/logout";
	}
	
	</script>
</body>

</html>
