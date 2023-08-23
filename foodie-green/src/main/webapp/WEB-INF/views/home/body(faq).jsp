<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script src="/js/jquery-3.6.4.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" href="/css/home/main.css">
<link rel="stylesheet" href="/css/home/faq.css">
</head>

<body>
	<!-- body -->
	<!-- main 부분 -->
	<main>
		<div class="container" style="height:100px; padding-top:100px; display:flex; justify-content:center">
			<div class="faq-section">
				<div>
					<h1>자주 묻는 질문</h1>
				</div>
<!-- 				<div class="search-container">
					<form action="#">
						<input class="search-input" type="text" id="search" name="search"
							placeholder="여기에 검색어를 입력하세요">
						<button class="search-btn" type="submit">검색</button>
					</form>
				</div> -->

			</div>

		</div>
	</main>
<!--클릭하면 숨겨진 div를 보여주기 -->
<script>
	function toggleContent(postNumber) {
		var content = document.getElementById('content-' + postNumber);
		content.classList.toggle('show');
	}
</script>
<script>
document.addEventListener('DOMContentLoaded', function() {
//모든 li 요소들을 선택합니다.
const listItems = document.querySelectorAll('.category-list li');

// 각 li 요소에 클릭 이벤트 리스너를 추가합니다.
listItems.forEach(item => {
    item.addEventListener('click', function() {
        // 현재 활성화된 li 요소의 active 클래스를 제거합니다.
        document.querySelector('.category-list li.active').classList.remove('active');
        
        // 클릭한 li 요소에 active 클래스를 추가하여 색상을 변경합니다.
        this.classList.add('active');
    });
});
}
</script>
</body>
</html>
