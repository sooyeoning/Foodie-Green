/*1 각 입력값 null 체크
  2 모든 입력값이 null이 아닐때 회원가입
  3 email: 중복체크 + 유효성검증(이메일인증번호전달)
  4 닉네임 중복체크
  
 
*/
var duplicateEmailCheck = false; //이메일 중복 확인
var authSecretkeyCheck = false; //인증번호 확인 버튼
var sendSecretkeyCheck = false; //인증번호 요청 버튼
var secretkey;

//이메일 중복체크 및 null값 체크
function email_check() {
	let email = document.getElementById('email').value;
	if ($.trim(email) == "") {
		$('#email_msg').html("필수 입력 항목입니다.");
		duplicateEmailCheck = false;
		return false;
	}

	$.ajax({
		url: "/emailCheck",
		method: "POST",
		data: { "email": email },
		async: false,
		success: function(response) {
			if (response == "이미 가입된 회원입니다.") { //비밀번호 찾기 창으로 이동
				alert("이미 사용중인 이메일입니다. 비밀번호 찾기 창으로 이동됩니다.");
				location.href = "/findPw";
				duplicateEmailCheck = false;
			} else {
				$('#email_msg').html("사용 가능한 이메일입니다.");
				duplicateEmailCheck = true;
			}

		},
		error: function() {
			alert("ajax 오류");
		}
	})
	return duplicateEmailCheck;
}

//이메일 인증번호 전달: 이메일 중복확인 후 실행됨
function sendSecretkey() {
	if(duplicateEmailCheck===true){	
	let email = document.getElementById('email').value;
	alert("입력하신 이메일로 인증번호가 전달되었습니다. 이메일 확인 후 인증번호를 기입해주세요.");

	$.ajax({
		url: "/emailAuth",
		method: "POST",
		data: { "email": email },
		success: function(response) {
			secretkey=response;
			sendSecretkeyCheck=true;
		},
		error: function() {
			alert("인증번호 전송 - ajax 오류");
			
		}
	})
	} else{
		sendSecretkeyCheck=false;
		alert("이메일 중복확인 후 사용가능합니다.");
	}

}

//인증번호 유효성 확인: 인증번호 요청 후 사용가능
function authSecretkey() {
	if(sendSecretkeyCheck===true){
	var sentKey = secretkey;
	var inputKey = document.getElementById('inputkey').value;
	if (sentKey === inputKey) {
		$('#secretkey_msg').html("인증번호 확인되었습니다.");
		authSecretkeyCheck = true;
	} else if($.trim(inputKey)==="") {
		$('#secretkey_msg').html("인증번호를 입력해주세요.");
		authSecretkeyCheck = false;
	} else {
		$('#secretkey_msg').html("인증번호가 틀렸습니다. 확인 후 입력해주세요.");
		authSecretkeyCheck = false;
	} 
	return authSecretkeyCheck;
	} else {
		alert("인증번호 요청 후 사용가능합니다.")
	}
}

//이메일 인증번호 전달
function checkForm() {

	let inputkey = document.getElementById('inputkey').value;

	if (!duplicateEmailCheck) {
		alert("이메일 입력 후 중복확인해주세요.")
		return false;
	} else if ($.trim(inputkey) == "") {
		alert("인증번호를 입력해주세요");
		return false;
	} else if (!authSecretkeyCheck) {
		alert("인증번호 확인 후 사용해주세요")
		return false;
	}
	else {
		event_pass();
	}


	//로그인 처리
	function event_pass() {
	var email = document.getElementById('email').value;
	location.href="/signin?email="+email;
	

	};//event_pass
}