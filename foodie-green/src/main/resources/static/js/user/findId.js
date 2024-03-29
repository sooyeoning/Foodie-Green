/*
$(document).on('click', '.findIdbtn', function() {
  	  
  	  let findIdReq = 
  	   {"name": $('#name').val(),
  	    "phone":$('#phone').val()};
  	    	 
  	  
  	  $.ajax({
  	    url: "/findId", 
  	    type: "POST",
  	    data: JSON.stringify(findIdReq),
        contentType: "application/json; charset=utf-8",
  	    success: function(response) {
		  console.log(response);
		  if(response==="null"){
			  alert("입력하신 이름, 번호에 해당하는 이메일이 없습니다.");
		  }	else {
			  alert("아이디는 "+response +"입니다.");
		  }
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      alert("아이디 찾기 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  });
  	  
  	});

*/