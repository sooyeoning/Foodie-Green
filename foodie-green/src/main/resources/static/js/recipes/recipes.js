document.addEventListener('DOMContentLoaded', function() {
	const floatingButton = document.querySelector('.floating-button');
	const dropdownLayer = document.querySelector('.write-dropdown');
	const diaryWriteButton = document.querySelector('a[href="/diarywrite"]');
	const recipesWriteButton = document.querySelector('a[href="/recipeswrite"]');
	floatingButton.addEventListener('click', function() {
		dropdownLayer.classList.toggle('active');
	});

	// 클릭 이외의 영역을 클릭하면 드롭다운 레이어 닫기
	window.addEventListener('click', function(event) {
		if (!floatingButton.contains(event.target)) {
			dropdownLayer.classList.remove('active');
		}
	});
	function redirectToLoginIfNotLoggedIn(event) {
		if (!isLoggedIn) {
			alert('로그인이 필요한 기능입니다.');
			window.location.href = '/login';
			event.preventDefault();  // 기본 이벤트 방지 (href로 이동 방지)
		}
	}
	diaryWriteButton.addEventListener('click', redirectToLoginIfNotLoggedIn);
	recipesWriteButton.addEventListener('click', redirectToLoginIfNotLoggedIn);
});
