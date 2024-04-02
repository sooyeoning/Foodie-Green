/*1 각 입력값 null 체크
  2 모든 입력값이 null이 아닐때 회원가입
  3 email: 중복체크 + 유효성검증(이메일인증번호전달)
  4 닉네임 중복체크
  
 
*/
var nickCheck = false;

$(document).ready(function() {

	//JQuery 동적으로 생성된 버튼에 이벤트 달기
	$(document).on("click", ".eyes", function() {

		if ($("#pw").attr("type") == "password") {
			$("#pw").attr("type", "text");
			$(".pweye").attr('class', "fa-solid fa-eye-slash pweye-slash");
		} else {
			$("#pw").attr("type", "password");
			$(".pweye-slash").attr('class', "fas fa-eye pweye");
		}
	});
	
	//JQuery 동적으로 생성된 버튼에 이벤트 달기
	$(document).on("click", ".check_eyes", function() {

		if ($("#checkpw").attr("type") == "password") {
			$("#checkpw").attr("type", "text");
			$(".checkpweye").attr('class', "fa-solid fa-eye-slash checkpweye-slash");
		} else {
			$("#checkpw").attr("type", "password");
			$(".checkpweye-slash").attr('class', "fas fa-eye checkpweye");
		}
	});
	
	
});
