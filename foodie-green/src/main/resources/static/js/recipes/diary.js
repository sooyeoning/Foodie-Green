
document.addEventListener('DOMContentLoaded', function() {
	const floatingButton = document.querySelector('.floating-button');
	const dropdownLayer = document.querySelector('.write-dropdown');
	const diaryWriteButton = document.querySelector('a[href="/diarywrite"]');
	const recipesWriteButton = document.querySelector('a[href="/recipeswrite"]');
	const recentButton = document.getElementById("recentButton");
	const popularButton = document.getElementById("popularButton");
	floatingButton.addEventListener('click', function(event) {
		event.stopPropagation(); // 클릭 이벤트가 상위 요소로 전파되지 않도록 차단
		dropdownLayer.classList.toggle('active');
	});

	document.addEventListener('click', function(event) {
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
	var loading = false;

	function loadDiaries(order) {
		if (loading) return;
		loading = true;


		var xhr = new XMLHttpRequest();
		xhr.open("GET", "getDiaries?order=" + order, true);

		xhr.onreadystatechange = function() {
			if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
				var diaries = JSON.parse(xhr.responseText);
				var contentDiv = order === 'recent' ? document.getElementById('recentContent') : document.getElementById('popularContent');
				contentDiv.innerHTML = '';

				diaries.forEach(function(diary) {
					var diaryDiv = document.createElement('div');
					diaryDiv.className = 'diary-item';

					var thumbnail = document.createElement('img');
					thumbnail.src = diary.photo;
					diaryDiv.appendChild(thumbnail);

					var contents = document.createElement('p');
					contents.textContent = diary.contents;
					diaryDiv.appendChild(contents);

					var likeButton = document.createElement('button');
					likeButton.textContent = '좋아요';
					diaryDiv.appendChild(likeButton);

					var likeCount = document.createElement('span');
					likeCount.textContent = diary.likeCount + '개의 좋아요';
					diaryDiv.appendChild(likeCount);

					contentDiv.appendChild(diaryDiv);
				});
				loading = false;
			}
		};

		xhr.send();
	}

	window.addEventListener('scroll', function() {
		if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight - 100) { // 스크롤이 페이지 하단에 근접하면
			var order = document.getElementById('popularContent').style.display === "block" ? 'popular' : 'recent';
			loadMoreDiaries(order); // 추가 내용 로딩
		}
	});

	function toggleButtons() {
		recentButton.style.display = recentButton.style.display === "none" ? "block" : "none";
		popularButton.style.display = popularButton.style.display === "none" ? "block" : "none";
	}

	recentButton.addEventListener("click", function() {
		loadDiaries('recent');
		document.getElementById('recentContent').style.display = "flex";
		document.getElementById('popularContent').style.display = "none";
		toggleButtons();
	});

	popularButton.addEventListener("click", function() {
		loadDiaries('popular');
		document.getElementById('recentContent').style.display = "none";
		document.getElementById('popularContent').style.display = "flex";
		toggleButtons();
	});

	// 최초로 최신순 버튼을 보이게 하고 인기순 버튼을 숨깁니다.
	recentButton.style.display = "block";
	popularButton.style.display = "none";
	document.getElementById('recentContent').style.display = "flex";
	document.getElementById('popularContent').style.display = "none";


	loadDiaries('recent');
});