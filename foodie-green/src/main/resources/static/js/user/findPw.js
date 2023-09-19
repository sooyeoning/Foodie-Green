var sendSecretkeyCheck = false;
var authSecretkeyCheck = false;
var secretkey;

$(document).on('click', '.findPwbtn', function() { 
	
  	 var phone = document.getElementById('phone').value;
  	 var email = document.getElementById('email').value;
  	 var inputKey = document.getElementById('checkKey').value;

  	 if(phone===null || $.trim(phone)==""){
		 alert("휴대폰 번호를 입력해주세요.");
	 }else if(email===null || $.trim(email)==""){
		 alert("회원가입시 입력한 이메일 주소를 입력해주세요.")
	 }else if(sendSecretkeyCheck===false){
		 alert("인증번호 요청해주세요.")
	 }else if(inputKey===null || $.trim(inputKey)==""){
		 alert("입력하신 이메일 주소로 전달된 인증번호를 입력해주세요.")
	 }else if(authSecretkeyCheck===false){
		 alert("인증번호 확인버튼을 눌러주세요.")
	 }else{
  	  
  	  $.ajax({
  	    url: "/findPw", 
  	    type: "POST",
  	    data: 
  	    {"email":  document.getElementById('email').value,
  	    "phone":document.getElementById('phone').value },
  	    success: function(response) {
  	      alert(response);
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      alert("아이디 찾기 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  });
  	  
  	  }
  	  
 });
 
 function sendSecretkey(){ //인증번호 전달
	 $.ajax({
  	    url: "/pwAuth", 
  	    type: "POST",
  	    data: 
  	    {"email":  document.getElementById('email').value,
  	    "phone":document.getElementById('phone').value },
  	    success: function(result) {
		  sendSecretkeyCheck = true;
		  if(result.secretkey!=null){
		  secretkey = result.secretkey;
		  }
  	      alert(result.response);
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      alert("비밀번호 전달 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  });
  }
  
  function authSecretkey(){ //인증번호 확인
	  if(sendSecretkeyCheck==true){
		  var inputkey = document.getElementById('checkKey').value;
		  if(secretkey==inputkey){
			  authSecretkeyCheck = true;
			  alert("인증번호 확인되었습니다.");
		  } else{
			  authSecretkeyCheck = false;
			  alert("잘못된 인증번호입니다.");
		  }
	  }
  }
  
  

