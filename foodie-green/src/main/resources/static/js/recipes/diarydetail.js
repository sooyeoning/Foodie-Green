document.addEventListener('DOMContentLoaded', function() {
	// 기존 코드
	const floatingButton = document.querySelector('.floating-button');
	const dropdownLayer = document.querySelector('.write-dropdown');
	const likeButton = document.querySelector('.like-button');
	const likeCountElement = document.querySelector('p');

	// 좋아요 버튼 클릭 이벤트
	likeButton.addEventListener('click', function() {
		console.log('Is logged in:', isLoggedIn);

		if (!isLoggedIn) {
			console.log('Is logged in2:', isLoggedIn);

			// 로그인되지 않은 경우 얼럿 표시
			alert('로그인이 필요한 기능입니다.');
			// 로그인 페이지로 리다이렉트
			window.location.href = '/login';
			return;
		}

		// 로그인된 경우 좋아요 업데이트
		const url = `/toggleLike/${diary_id}`;
		fetch(url, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
		})
			.then(response => response.text()) // 응답을 텍스트로 처리
			.then(data => {
				if (data === "Success") {
					window.location.reload();
				} else {
					// 실패 시 수행할 작업
				}
			})
			.catch(error => {
				console.error('An error occurred:', error);
			});

		// 기존 코드
		floatingButton.addEventListener('click', function(event) {
			event.stopPropagation();
			dropdownLayer.classList.toggle('active');
		});
		document.addEventListener('click', function(event) {
			if (!floatingButton.contains(event.target)) {
				dropdownLayer.classList.remove('active');
			}
		});
	});
});