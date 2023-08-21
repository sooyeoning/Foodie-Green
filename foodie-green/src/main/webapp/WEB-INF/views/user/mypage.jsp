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
<script src="/js/user/mypage_edit.js"></script>
<script src="/js/user/mypage_delete.js"></script>
<!-- <script src="/js/user/mypage_userDiary.js"></script> -->
<link href="/css/user/content.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="../home/header.jsp"%>
	
	<% UserDTO userdto = (UserDTO) session.getAttribute("user");
	String nickname = userdto.getNickname();
	String name = userdto.getName();
	String email = userdto.getEmail();
	String phone = userdto.getPhone();
	String pw = userdto.getPw();
	%>
	<div class="d-flex align-items-start paddingtop120">
	 <!-- 메뉴바 목록 -->
         <div class="d-flex align-items-start marginleft12">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link active" id="v-pills-userInfo-tab" data-bs-toggle="pill" data-bs-target="#v-pills-userInfo" type="button" role="tab" aria-controls="v-pills-userInfo" aria-selected="true">내 회원정보</button>
          <button class="nav-link" id="v-pills-purchasedItems-tab" data-bs-toggle="pill" data-bs-target="#v-pills-purchasedItems" type="button" role="tab" aria-controls="v-pills-purchasedItems" aria-selected="false">주문내역</button>
          <button class="nav-link" id="v-pills-wishItems-tab" data-bs-toggle="pill" data-bs-target="#v-pills-wishItems" type="button" role="tab" aria-controls="v-pills-wishItems" aria-selected="false">찜한 상품목록</button>
          <button class="nav-link" id="v-pills-userDiary-tab" data-bs-toggle="pill" data-bs-target="#v-pills-userDiary" type="button" role="tab" aria-controls="v-pills-userDiary" aria-selected="false">내가 쓴 식단일기</button>
          <button class="nav-link" id="v-pills-userComments-tab" data-bs-toggle="pill" data-bs-target="#v-pills-userComments" type="button" role="tab" aria-controls="v-pills-userComments" aria-selected="false">내가 쓴 댓글</button>
          <button class="nav-link" id="v-pills-userLikedPost-tab" data-bs-toggle="pill" data-bs-target="#v-pills-userLikedPost" type="button" role="tab" aria-controls="v-pills-userLikedPost" aria-selected="false">내가 찜한 글</button>
          <button class="nav-link" id="v-pills-userDelete-tab" data-bs-toggle="pill" data-bs-target="#v-pills-userDelete" type="button" role="tab" aria-controls="v-pills-userDelete" aria-selected="false">회원탈퇴</button>
        </div>
        <div class="tab-content paddingleft10" id="v-pills-tabContent">
          <div class="tab-pane fade show active" id="v-pills-userInfo" role="tabpanel" aria-labelledby="v-pills-userInfo-tab">
            <p class="edit_title">회원 정보를 확인하세요</p>
            <p class="font20 bottom0">이름</p>
            <input type="text" class="input" value=<%=name%> id="name"
              readonly="readonly">
            <p class="font20 bottom0">닉네임</p>
            <div class="font15 top1vh pointcolor" id="nickname_msg"></div>
            <input type="text" class="input" value=<%=nickname%> id="nickname"><br>
            <button class="nick_check" onclick="nick_check();">닉네임 중복확인</button>
            <p class="font20 bottom0">이메일</p>
            <input type="email" class="input" value=<%=email%> id="email"
              readonly="readonly">
            <p class="font20 bottom0">비밀번호</p>
            <p class="font15 top1vh pointcolor " id="pw_msg"></p>
            <input type="text" class="input" value=<%=pw%> id="pw">
            <p class="font20 bottom0">휴대폰 번호</p>
            <div class="font15 top1vh pointcolor " id="phone_msg"></div>
            <input type="text" class="input" value=<%=phone%> id="phone"><br>
            <button type="button" class="editbtn bottom10">수정 완료</button>
          </div>
          <div class="tab-pane fade" id="v-pills-purchasedItems" role="tabpanel" aria-labelledby="v-pills-purchasedItems-tab">서비스 제공 예정입니다.</div>
          <div class="tab-pane fade" id="v-pills-wishItems" role="tabpanel" aria-labelledby="v-pills-wishItems-tab">서비스 제공 예정입니다.</div>
          <div class="tab-pane fade" id="v-pills-userDiary" role="tabpanel" aria-labelledby="v-pills-userDiary-tab">서비스 제공 예정입니다.</div>
          <div class="tab-pane fade" id="v-pills-userComments" role="tabpanel" aria-labelledby="v-pills-userComments-tab">서비스 제공 예정입니다.</div>
          <div class="tab-pane fade" id="v-pills-userLikedPost" role="tabpanel" aria-labelledby="v-pills-userLikedPost-tab">서비스 제공 예정입니다.</div>
          <div class="tab-pane fade" id="v-pills-userDelete" role="tabpanel" aria-labelledby="v-pills-userDelete-tab"> <p class="delete_title">탈퇴하기</p>
            <p class="font20">1. 탈퇴 시, 구독 정보와 회원 정보, 보유 쿠폰 등 모든 정보가 영구적으로 삭제되며 복구가 불가능합니다.</p>
            <p class="font20" style="color:red;">2. 탈퇴 후 6개월간 동일한 계정으로 재가입이 불가능합니다.</p>
            <p class="font20">정말 탈퇴를 진행하시겠습니까?</p>
            <button class="deletebtn">탈퇴하기</button></div>
        
	<!-- 메뉴바 끝 -->
	</div></div></div>




	<%@ include file="../home/footer.jsp"%>
</body>
</html>
