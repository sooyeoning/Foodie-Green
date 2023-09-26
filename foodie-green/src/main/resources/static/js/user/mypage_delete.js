
$(document).ready(function() {

	$('.deletebtn_normal').click(function() {		
		
		$.ajax({
			url: "/mypage/delete",
			method: "get",
			success: function() {
				alert("정상적으로 탈퇴되었습니다. 그동안 서비스를 이용해주셔서 감사합니다.");
				location.href = "/";
			},
			error: function() {
				alert("회원 탈퇴하는 과정 중 오류가 생겼습니다.");
			}
		})
		
	})
	
	$('.deletebtn_kakao').click(function() {		
		
		$.ajax({
			url: "/mypage/kakaounlink",
			method: "get",
			success: function() {
				alert("정상적으로 탈퇴되었습니다. 그동안 서비스를 이용해주셔서 감사합니다.");
				location.href = "/";
			},
			error: function() {
				alert("회원 탈퇴하는 과정 중 오류가 생겼습니다.");
			}
		})
		
	})


	
});



