document.addEventListener('DOMContentLoaded', function() {
	const floatingButton = document.querySelector('.floating-button');
	const dropdownLayer = document.querySelector('.write-dropdown');

	floatingButton.addEventListener('click', function(event) {
		event.stopPropagation(); // 클릭 이벤트가 상위 요소로 전파되지 않도록 차단
		dropdownLayer.classList.toggle('active');
	});

	// 문서의 어느 곳이든 클릭 시 드롭다운 레이어 닫기
	document.addEventListener('click', function(event) {
		if (!floatingButton.contains(event.target)) {
			dropdownLayer.classList.remove('active');
		}
	});

	const recentButton = document.getElementById("recentButton");
	const popularButton = document.getElementById("popularButton");
	//const contentContainer = document.getElementById("contentContainer");
	//const recentContent = document.getElementById("recentContent");
	//const popularContent = document.getElementById("popularContent");

	recentButton.addEventListener("click", function() {
		recentButton.style.display = "none";
		popularButton.style.display = "inline-block";
		//recentContent.style.display = "flex";
		//popularContent.style.display = "none";
	});

	popularButton.addEventListener("click", function() {
		popularButton.style.display = "none";
		recentButton.style.display = "inline-block";
		//popularContent.style.display = "flex";
		//recentContent.style.display = "none";
	});
	    // 최신순 버튼만 표시하고 인기순 버튼은 숨기기
    recentButton.style.display = "inline-block";
    popularButton.style.display = "none";
    //recentContent.style.display = "flex";
    //popularContent.style.display = "none";
});
