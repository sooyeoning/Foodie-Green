$(document).ready(function() {

	$(".login_email").click(function() {
		$(".result").html(`
	<p class="login_title_email">이메일로 계속하기</p>	
	<form method="post" id="signinForm" action="/userlogin">
	<input type="text" name="email" placeholder="이메일을 입력해주세요" id="loginemail" class="emailwhite">
	<div class="pw_eyes">
  	<input type="password" id="loginpw" class="pwwhite" placeholder="비밀번호를 입력해주세요.">
  	<div class="eyes">
  		<i class="fas fa-eye" style="color: #ffb3a7;"></i>
 	 </div>
	</div>
	
	<button type="submit" id="loginbtn" class="loginbtn">로그인</button>
	</form>
	<button class="emailbtn">이메일 찾기</button>
	<button class="pwbtn">비밀번호 찾기</button>`);
	})
	
	//JQuery 동적으로 생성된 버튼에 이벤트 달기
	$(document).on("click", ".eyes", function() {

		if ($("#loginpw").attr("type") == "password") {
			$("#loginpw").attr("type", "text");
			$(".fa-eye").attr('class', "fa-solid fa-eye-slash");
		} else {
			$("#loginpw").attr("type", "password");
			$(".fa-eye-slash").attr('class', "fas fa-eye");
		}
	});

	//JQuery 동적으로 생성된 버튼에 이벤트 달기
	$(document).on("click", ".emailbtn", function() {
		alert("이메일 찾기 창으로 이동합니다.");
		location.href = "/findId";
	});

	//JQuery 동적으로 생성된 버튼에 이벤트 달기
	$(document).on("click", ".pwbtn", function() {
		alert("비밀번호 찾기 창으로 이동합니다.");
		location.href = "/findPw";
	});

});//ready end
