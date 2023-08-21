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
<title>마이페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/mypage.js"></script>
<script src="/js/user/mypage_edit.js"></script>
<script src="/js/user/mypage_delete.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="../home/header.jsp"%>
	<%
	UserDTO userdto = (UserDTO) session.getAttribute("user");
	String nickname = userdto.getNickname();
	String name = userdto.getName();
	String email = userdto.getEmail();
	String phone = userdto.getPhone();
	String pw = userdto.getPw();
	%>
	<div class="d-flex align-items-start paddingtop120">
		<!-- 메뉴바 목록 -->
		<div class="nav flex-column nav-pills me-3" id="v-pills-tab"
			role="tablist" aria-orientation="vertical">
			<button class="nav-link" id="userInfo-tab" data-bs-toggle="pill"
				data-bs-target="#userInfo" type="button" role="tab"
				aria-controls="v-pills-home" aria-selected="false">내 회원정보</button>
			<button class="nav-link" id="purchasedItems-tab"
				data-bs-toggle="pill" data-bs-target="#purchasedItems" type="button"
				role="tab" aria-controls="v-pills-home" aria-selected="false">주문내역</button>
			<button class="nav-link" id="wishItems-tab" data-bs-toggle="pill"
				data-bs-target="#wishItems" type="button" role="tab"
				aria-controls="v-pills-home" aria-selected="false">찜한 상품목록</button>
			<button class="nav-link" id="userDiary-tab" data-bs-toggle="pill"
				data-bs-target="#userDiary" type="button" role="tab"
				aria-controls="v-pills-profile" aria-selected="false">내가 쓴
				식단일기</button>
			<button class="nav-link" id="userComments-tab" data-bs-toggle="pill"
				data-bs-target="#userComments" type="button" role="tab"
				aria-controls="v-pills-disabled" aria-selected="false">내가 쓴
				댓글?</button>
			<button class="nav-link" id="userLikedPost-tab" data-bs-toggle="pill"
				data-bs-target="#userLikedPost" type="button" role="tab"
				aria-controls="v-pills-messages" aria-selected="false">내가
				찜한 글</button>
			<button class="nav-link" id="userDelete-tab" data-bs-toggle="pill"
				data-bs-target="#userDelete" type="button" role="tab"
				aria-controls="v-pills-settings" aria-selected="false">회원탈퇴</button>
		</div>
		<div class="tab-content" id="v-pills-tabContent">

			<!-- 내 회원정보 -->
			<div class="tab-pane fade show active" id="userInfo" role="tabpanel"
				aria-labelledby="userInfo-tab" tabindex="0">
				<p class="edit_title">회원 정보를 확인하세요</p>
				<p class="font20 bottom0">이름</p>
				<input type="text" class="input" value=<%=name%> id="name"
					readonly="readonly">
				<p class="font20 bottom0">닉네임</p>
				<div class="font15 top1vh pointcolor" id="nickname_msg"></div>
				<input type="text" class="input" value=<%=nickname%> id="nickname">
				<button class="nick_check" onclick="nick_check();">닉네임 중복확인</button>
				<p class="font20 bottom0">이메일</p>
				<input type="email" class="input" value=<%=email%> id="email"
					readonly="readonly">
				<p class="font20 bottom0">비밀번호</p>
				<p class="font15 top1vh pointcolor " id="pw_msg"></p>
				<input type="text" class="input" value=<%=pw%> id="pw">
				<p class="font20 bottom0">휴대폰 번호</p>
				<div class="font15 top1vh pointcolor " id="phone_msg"></div>
				<input type="text" class="input" value=<%=phone%> id="phone">
				<button type="button" class="editbtn">수정 완료</button>
			</div>

			<!-- 주문 내역 -->
			<div class="tab-pane fade" id="purchasedItems" role="tabpanel"
				aria-labelledby="purchasedItems-tab" tabindex="0">서비스가 준비중입니다.</div>

			<!-- 상품 찜한 내역 -->
			<div class="tab-pane fade" id="wishItems" role="tabpanel"
				aria-labelledby="wishItems-tab" tabindex="0">서비스가 준비중입니다.</div>

			<!-- 글쓴 내역 -->
			<div class="tab-pane fade" id="userDiary" role="tabpanel"
				aria-labelledby="userDiary-tab" tabindex="0">(구현예정)</div>

			<!-- 댓글 내역 -->
			<div class="tab-pane fade" id="userComments" role="tabpanel"
				aria-labelledby="userComments-tab" tabindex="0">(구현예정)</div>

			<!-- 찜한 글 내역 -->
			<div class="tab-pane fade" id="userLikedPost" role="tabpanel"
				aria-labelledby="userLikedPost-tab" tabindex="0">(구현예정)</div>

			<!-- 회원 탈퇴 -->
			<div class="tab-pane fade" id="userDelete" role="tabpanel"
				aria-labelledby="userDelete-tab" tabindex="0">
				<p>탈퇴하기</p>
				<p>1. 탈퇴 시, 구독 정보와 회원 정보, 보유 쿠폰 등 모든 정보가 영구적으로 삭제되며 복구가 불가능합니다.</p>
				<p style="color:red;">2. 탈퇴 후 6개월간 동일한 계정으로 재가입이 불가능합니다.</p>
				<p>정말 탈퇴를 진행하시겠습니까?</p>
				<button class="deletebtn">탈퇴하기</button>
			</div>
		</div>

	</div>




	<%@ include file="../home/footer.jsp"%>
</body>
</html>