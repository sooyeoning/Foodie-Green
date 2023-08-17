
	$(function(){
		//var email_auth_cd = '';
		
		
		$('.signinbtn').click(function(){
		let regExp_tel = /^01\d-?\d{3,4}-?\d{4}$/; //핸드폰 번호 정규식
		let regExp_email = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');//이메일 정규식
		let regExp_pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,15}$///비밀번호 정규식

		let name = document.getElementById('name').value;
		let nickname = document.getElementById('nickname').value;
		let email = document.getElementById('email').value;
		let pw = document.getElementById('pw').value;
		let phone = document.getElementById('phone').value;

		if (name == "") {
			alert("이름을 입력해주세요");
			name.focus();
			return;
		} 
		if (nickname == "") {
			alert("닉네임을 입력해주세요");
			nickname.focus();
			return;
		}
		if (email == "") { //이메일 인증번호
			alert("이메일을 입력해주세요");
			email.focus();
			return;
		}
		//이메일 중복확인
		
		/*if(email_auth_cd == ''){
			alert('인증번호를 요청하세요')
		}
		if($('#email_auth_key').val() != email_auth_cd){
			alert("인증번호가 일치하지 않습니다.");
			return;
		}*/
		if (pw == "") {
			alert("비밀번호를 입력해주세요");
			pw.focus();
			return;
		}
		if (!regExp_pw.test(pw)) {
			alert("6~15 자리의 비밀번호를 입력해주세요");
			pw.focus();
			return;
		}
		if (phone == "") {
			alert("핸드폰 번호를 입력해주세요");
			phone.focus();
			return;
		}

		if (!regExp_tel.test(phone)) { //핸드폰 번호 정규식 검사
			alert("01x-xxxx-xxxx 형식으로 입력해주세요");
			phone.focus();
			return;
		}
		
		event_pass();
		})
		});
	

//이메일 확인
$('.email_auth_btn').click(function(){
		let email = document.getElementById('email').value;

		 $.ajax({
			type : "POST",
			url : "/signup/emailAuth",
			data : {email : email},
			success: function(data){
				alert("인증번호가 발송되었습니다.");
				email_auth_cd = data;
			},
			error: function(data){
				alert("메일 발송에 실패했습니다.");
			}
		}); 
		
	})
	
	//이메일 확인
$('.email_check').click(function(){
		let email = document.getElementById('email').value;

		 $.ajax({
			type : "POST",
			url : "/signup/emailCheck",
			data : {email : email},
			success: function(response){
				alert(response);
				
			},
			error: function(){
				alert("이메일 중복체크 실패했습니다.");
			}
		}); 
		
	})
	
	//로그인 처리
	function event_pass() {
		
		$.ajax({
			url: "/signin",
			type: "POST",
			data: $("#signinForm").serialize(), //한번에 전송할 데이터가 많은 경우
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





