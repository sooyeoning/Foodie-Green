document.addEventListener('DOMContentLoaded', function() {
	// 기존 코드
	const floatingButton = document.querySelector('.floating-button');
	const dropdownLayer = document.querySelector('.write-dropdown');
	const likeButton = document.querySelector('.like-button');
	const deleteButton = document.getElementById('delete-button');
	const editButton = document.getElementById('edit-button');


	console.log('isLoggedIn:', isLoggedIn);
	console.log('loggedInUserNickname:', loggedInUserNickname);
	console.log('writer:', writer);

		// 기존 코드
		floatingButton.addEventListener('click', function() {
			/* event.stopPropagation(); */
			dropdownLayer.classList.toggle('active');
		});
		document.addEventListener('click', function(event) {
			if (!floatingButton.contains(event.target)) {
				dropdownLayer.classList.remove('active');
			}
		});


	// 로그인한 사용자와 글 작성자가 동일한 경우 삭제 버튼 표시
	if (isLoggedIn && loggedInUserNickname === writer) {
		deleteButton.style.display = 'inline-block'; // 이 부분 수정
		editButton.style.display = 'inline-block'; // 이 부분 추가
	}
	// 수정 버튼 클릭 이벤트
	editButton.addEventListener('click', function() {
		window.location.href = `/editDiary/${diary_id}`; // 수정 페이지로 이동
	});


	// 삭제 버튼 클릭 이벤트
	deleteButton.addEventListener('click', function() {
		if (confirm('정말로 글을 삭제하시겠습니까?')) {
			const url = `/deleteDiary/${diary_id}`;
			fetch(url, {
				method: 'POST',
			})
				.then(response => response.text())
				.then(data => {
					console.log(data);
					if (data === "Success") {
						window.location.href = '/diary'; // 삭제 후 리다이렉트
						alert('글이 삭제되었습니다.');
					} else {
						alert('글 삭제에 실패하였습니다.');
					}
				})
				.catch(error => {
					console.error('An error occurred:', error);
				});
		}
	});
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
	});
});