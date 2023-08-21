
$(document).ready(function() {

	$('#v-pills-userDiary-tab').click(function() {
		$.ajax({
			url: "/mypage/userDiary",
			method: "get",
			success: function(list){
				$('.row').html(list);
			},
			error: function(){
			}
		})
	})

});

