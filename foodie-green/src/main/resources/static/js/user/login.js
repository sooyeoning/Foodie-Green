$(document).ready(function() {
	
	$(".login_email").click(function(){
		$(".result").html(`
	<p class="login_title_email">이메일로 계속하기</p>	
	<form method="post" id="signinForm" action="/userlogin">
	<input type="text" name="email" placeholder="이메일을 입력해주세요" id="loginInput">
	<input type="text" name="pw" placeholder="비밀번호를 입력하세요(6자 이상)" id="loginInput">
	<button type="submit" id="loginbtn" class="loginbtn">로그인</button>
	</form>
	<button class="emailbtn">이메일 찾기</button>
	<button class="pwbtn">비밀번호 찾기</button>`);
	})
  
 	 //JQuery 동적으로 생성된 버튼에 이벤트 달기
 	 $(document).on("click", ".emailbtn", function() {
     	alert("이메일 찾기 창으로 이동합니다.");
     	location.href="/findId";
	});
	 
	 //JQuery 동적으로 생성된 버튼에 이벤트 달기
 	 $(document).on("click", ".pwbtn", function() {
     	alert("비밀번호 찾기 창으로 이동합니다.");
     	location.href="/findPw";
	});
	
});//ready end
