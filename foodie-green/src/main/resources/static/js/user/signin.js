/*1 각 입력값 null 체크
  2 모든 입력값이 null이 아닐때 회원가입
  3 email: 중복체크 + 유효성검증(이메일인증번호전달)
  4 닉네임 중복체크
  
 
*/
var nickCheck = false;
var emailCheck = false;
var secretkeyCheck = false;
 
$(document).ready(function() {

	$('.signinbtn').click(function() {
		signin_check();
	})

});

//닉네임 중복확인 및 null값 체크
function nick_check() {
	//var nick_check;
	let nickname = document.getElementById('nickname').value;
	if ($.trim(nickname) == "") {
		$('#nickname_msg').html("필수 입력 항목입니다.");
		nickCheck=false;
		return false;
	}
	$.ajax({
		url: "/nickCheck",
		method: "POST",
		data: { "nickname": nickname },
		async: false,
		success: function(response) {
			if (response == "이미 사용중인 닉네임입니다.") {
				//	$('.signinbtn').attr("disabled", true);
				$('#nickname_msg').html("이미 사용중인 닉네임입니다.");
				nickCheck=false;
			} else {
				$('#nickname_msg').html("사용 가능한 닉네임입니다.");
				nickCheck=true;
				//	$('.signinbtn').attr("disabled", false);
			}

		},
		error: function() {
			alert("ajax 오류");
		}
	})
	return nickCheck;
}

//이메일 중복체크 및 null값 체크
function email_check() {
//	var email_check;
	let email = document.getElementById('email').value;
	if ($.trim(email) == "") {
		$('#email_msg').html("필수 입력 항목입니다.");
		emailCheck=false;
		return false;
	}
	//alert($.trim(email));

	$.ajax({
		url: "/emailCheck",
		method: "POST",
		data: { "email": email },
		async: false,
		success: function(response) {
			if (response == "이미 가입된 회원입니다.") {
				//	$('.signinbtn').attr("disabled", true);
				$('#email_msg').html("이미 사용중인 이메일입니다.");
				emailCheck=false;
			} else {
				$('#email_msg').html("사용 가능한 이메일입니다.");
				//$('.signinbtn').attr("disabled", false);
				emailCheck=true;
			}

		},
		error: function() {
			alert("ajax 오류");
		}
	})
	return emailCheck;
}

//이메일 인증번호 체크
function secretkey_check() {
//	var secretkey_check;
	let email = document.getElementById('email').value;
	alert("입력하신 이메일로 인증번호가 전달되었습니다. 이메일 확인 후 인증번호를 기입해주세요.");
	
	$.ajax({
		url: "/emailAuth",
		method: "POST",
		data: { "email": email },
		async: false,
		success: function(response) {
			var secretkey = document.getElementById('secretkey').value;
			if (response == secretkey) {
				//	$('.signinbtn').attr("disabled", true);
				$('#secretkey_msg').html("인증번호 확인되었습니다.");				
				secretkeyCheck=true;		
			} else {
				$('#secretkey_msg').html("인증번호가 틀렸습니다."+secretkey+"/"+response);
				//$('.signinbtn').attr("disabled", false);
				 secretkeyCheck=false;
			}

		},
		error: function() {
			alert("ajax 오류");
		}
	})

	return secretkeyCheck;
}

//로그인 처리
function event_pass() {

	$.ajax({
		url: "/signin_request",
		type: "POST",
		data: {
			name: document.getElementById('name').value,
			nickname: document.getElementById('nickname').value,
			email: document.getElementById('email').value,
			pw: document.getElementById('pw').value,
			phone:document.getElementById('phone').value,
			logintype: document.getElementById('logintype').value
		}, 
		success: function(response) {
			console.log("success response:", response);
			alert("회원가입이 완료되었습니다.");
			window.location.href = "/login";
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log("error response:", jqXHR, textStatus, errorThrown);
			alert("회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
		}
	});


};//event_pass

function signin_check() {
	
	let name = document.getElementById('name').value;
	let pw = document.getElementById('pw').value;
	let phone = document.getElementById('phone').value;
	let nickname = document.getElementById('nickname').value;

	//let secretkey = document.getElementById('secretkey').value;

	let regExp_phone = /^01\d-?\d{3,4}-?\d{4}$/; //핸드폰 번호 정규식
	let regExp_pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,15}$///비밀번호 정규식

	$('#name_msg').html("");
	$('#pw_msg').html("");
	$('#phone_msg').html("");
	
	//$('.signinbtn').attr('disabled',true);
	if ($.trim(name) == "") {
		$('#name_msg').html("필수 입력 항목입니다.");
		return false;
	} else if ($.trim(nickname) == "") {
		$('#nickname_msg').html("필수 입력 항목입니다.");
		return false;
	} else if (!regExp_pw.test(pw)) {
		$('#pw_msg').html("영문+숫자+특수문자로 이루어진 6~15자리 비밀번호를 입력해주세요.");
		return false;
	} else if (!regExp_phone.test(phone)) {
		$('#phone_msg').html("01x-xxxx-xxxx 형식으로 입력해주세요");
		return false;
	} else if (!nickCheck ) {
		alert("닉네임 입력 후 중복확인해주세요.")
		return false;
	} else if (!emailCheck ) {
		alert("이메일 입력 후 중복확인해주세요.")
		return false;
	} 
	/*else if ($.trim(secretkey) == "") {
		$('#secretkey_msg').html("<p>인증번호 받기 버튼을 눌러 인증번호를 입력해주세요</p>");
		return false;
	} else if (!secretkeyCheck) {
		return false;
	} */
	else {
		//회원가입
		//$('.signinbtn').attr('disabled',false);
		event_pass();
	}
}