
var secretKey;

$(document).ready(function(){ 

	let hasCheckedEmailAuth = $('#hasCheckedEmailAuth').val();
  	
  	$('.sendKeyBtn').click(function(){
		  let phone = $('#phone').val();
		  let email = $('#email').val();
  	 	  let inputKey = $('#inputKey').val();

		  const findPwReq = {
		   		email: email,
		 		phone: phone,
		 		inputKey: inputKey,
	 	  };
	 	  
		  secretKey = sendSecretkeyFunc(findPwReq, secretKey);
		  
		  if(secretKey != null){
			 $(".hasSentEmailAuth").attr("value", true);
		 }
	})
	
	$('.authKeyBtn').click(function(){
		  let phone = $('#phone').val();
		  let email = $('#email').val();
  	 	  let inputKey = $('#inputKey').val();
		
		   const findPwReq = {
		   		email: email,
		 		phone: phone,
		 		inputKey: inputKey,
		 		secretKey: secretKey
	 	  };
	 	  
		 hasCheckedEmailAuth = authSecretkeyFunc(findPwReq, hasCheckedEmailAuth, secretKey);
		 
		 if(hasCheckedEmailAuth){
			 $(".hasCheckedEmailAuth").attr("value", true);
		 }
	})
  	  
 });
 
 function sendSecretkeyFunc(findPwReq, secretKey){ //인증번호 전달
	 $.ajax({
  	    url: "/pwAuth", 
  	    type: "POST",
  	    contentType: "application/json; charset=utf-8",
  	    data:  JSON.stringify(findPwReq),
  	    async: false,
  	    success: function(result) {
		  if(result.secretkey != null){
		  	secretKey = result.secretkey;
		  	//console.log("전송번호: "+result.secretkey);
		  	//console.log("js 전송번호: "+secretKey);
		  }
  	      alert(result.response);
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      alert("비밀번호 전달 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  })
  	  return secretKey;
  }
  
 function authSecretkeyFunc(findPwReq, hasCheckedEmailAuth){ //인증번호 확인
	  console.log("authSecretkeyFunc 시작");
	  if(findPwReq.secretKey==null){
		alert("인증번호를 받은 후 클릭해주세요.");
	  } else {
		  var inputkey = findPwReq.inputKey;
		  if(secretKey==inputkey){
			  //console.log("전송번호: "+inputkey);
		  	  //console.log("js 전송번호: "+secretKey);
		  	  hasCheckedEmailAuth = true;
			  alert("인증번호 확인되었습니다.");
		  } else{
			  alert("잘못된 인증번호입니다.");
		  }
	  }
	  
	  return hasCheckedEmailAuth;
  }
  
 
  
  

