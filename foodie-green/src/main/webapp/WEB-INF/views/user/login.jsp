<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.3.0/kakao.min.js"
	integrity="sha384-70k0rrouSYPWJt7q9rSTKpiTfX6USlMYjZUtr1Du+9o4cGvhPAWxngdtVZDdErlh"
	crossorigin="anonymous"></script>
<script>
	Kakao.init('32a3a30cbdb57b878110f956ff7a1ad6'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<script src="/js/user/login.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="../home/header.jsp"%>

	<div class="login_background">
	<div class="login_buttons">
	
	<p class="login_title paddingtop120">로그인/회원가입</p>
	
	<p class="login_subtitle">Foodie&Green</p>
	<p class="login_subtitle">우리 서비스는 친환경 채소로 당신의 건강을 책임집니다</p><br>
	<div class="result">
	<a id="kakao-login-btn" href="javascript:loginWithKakao()"> <img
		src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
		width="222px" alt="카카오 로그인 버튼" />
	</a><br>
	<button class="login_email">이메일로 계속하기</button>
	</div>
	
	<p class="signin">아직 회원이 아니신가요? <a href="/signin" class="signin_a"> 회원가입</a></p>
	</div>
	</div>

	<!-- 네이버 로그인 버튼 노출 영역
	<div id="naver_id_login"></div>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("EalNl28PbnY3xzYe7CFV", "http://localhost:8080/callback");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("white", 2,40);
        naver_id_login.setDomain("http://localhost:8080/callback");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
        </script>
        -->
        
	<!-- 카카오톡 로그인 버튼 노출 영역 -->
	<script type="text/javascript">
	function loginWithKakao() {
	    Kakao.Auth.authorize({
	      redirectUri: 'http://localhost:8888/login_kakao',
	      scope: "account_email profile_nickname"
	    });
	  }

	  
	</script>
<%@ include file="../home/footer.jsp"%>

</body>
</html>
