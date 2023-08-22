
var nickCheck = false;
 
$(document).ready(function() {

	$('.editbtn_r').click(function() {
		edit_check();
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

//로그인 처리
function event_pass() {

	$.ajax({
		url: "/mypage/edit",
		type: "POST",
		data: {
			name: document.getElementById('name').value,
			nickname: document.getElementById('nickname').value,
			email: document.getElementById('email').value,
			pw: document.getElementById('pw').value,
			phone:document.getElementById('phone').value
		}, 
		success: function() {
			alert("회원정보가 수정되었습니다.");
			window.location.href = "/mypage/edit";
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log("error response:", jqXHR, textStatus, errorThrown);
			alert("회원정보 수정 중 오류가 발생했습니다. 다시 시도해주세요.");
		}
	});


};//event_pass

function edit_check() {
	
	let pw = document.getElementById('pw').value;
	let phone = document.getElementById('phone').value;
	let nickname = document.getElementById('nickname').value;

	let regExp_phone = /^01\d-?\d{3,4}-?\d{4}$/; //핸드폰 번호 정규식
	let regExp_pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,15}$///비밀번호 정규식

	$('#pw_msg').html("");
	$('#nickname_msg').html("");
	$('#phone_msg').html("");
	
	//$('.signinbtn').attr('disabled',true);
	if ($.trim(nickname) == "") {
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
	}else {
		event_pass();
	}
}