
$(document).ready(function() {

	$('#v-pills-userLikedPost-tab').click(function() {
		$.ajax({
			url: "/mypage/likes",
			method: "post",
			success: function(list) {
				//alert("Success");
				$('#likeddiarylist').html('');

				for (var onediary of list) {
					$('#likeddiarylist').append(`<a href="/diarydetail/${onediary.id}"><div class="col">
          <div class="card shadow-sm">
            <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="`+ onediary.photo + `" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#55595c"></rect></svg>
            <div class="card-body">
              <p class="card-text">`+ onediary.contents + `</p>
              <div class="d-flex justify-content-end align-items-center">
                <small class="text-body-secondary">조회수: `+ onediary.likecnt + `<br></small>
              </div>
              <div class="d-flex justify-content-end align-items-center">
                <small class="text-body-secondary">작성자: `+ onediary.writer + `<br></small>
              </div>
               <div class="d-flex justify-content-end align-items-center">
                <small class="text-body-secondary">작성시간: `+ onediary.writing + `<br></small>
              </div>
            </div>
          </div>
        </div></a>`)
				}

			},
			error: function() {
			//	alert("error");

			}
		})
	})



});//ready end


