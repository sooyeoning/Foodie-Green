
$(document).on('click', '.findIdbtn', function() {
  	  
  	  let params = {"name": document.getElementById('name').value,
  	    "phone":document.getElementById('phone').value};
  	    	 
  	  
  	  $.ajax({
  	    url: "/findId", 
  	    type: "POST",
  	    data: JSON.stringify(params),
        contentType: "application/json",
  	    success: function(response) {
  	      alert(response);
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      alert("아이디 찾기 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  });
  	  
  	});

