
$(document).on('click', '.findPwbtn', function() { 
  	  
  	  $.ajax({
  	    url: "/emailAuth", 
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
  	  
  	});

