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
		<div class="container">

			<div class="section-container">
				<div class="left-section">
					<!-- 왼쪽 섹션 -->

					<ul id="categories" class="category-list"><!-- 
						<li id="faq-item-1"><h3>전체보기</h3></li> -->
						<a href="/faq/01"><li id="faq-item-2" style="background-color:#FFB3A7;"><h3>구독</h3></li></a>
						<a href="/faq/02"><li id="faq-item-3"><h3>레시피</h3></li></a>
						<a href="/faq/03"><li id="faq-item-4"><h3>정보 변경</h3></li></a>
						<a href="/faq/04"><li id="faq-item-5"><h3>결제</h3></li></a>
						<a href="/faq/05"><li id="faq-item-6"><h3>정지/미루기</h3></li></a>
					</ul>
				</div>
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
<script>
//왼쪽 타일의 li 요소들에 클릭 이벤트 리스너 추가
const faqItems = document.querySelectorAll('.faq-list li');
faqItems.forEach(item => {
    item.addEventListener('click', function() {
        // 클릭한 항목의 ID를 추출합니다.
        const faqItemId = this.id;
        
        // 오른쪽 타일에 해당 항목의 내용을 표시합니다.
        loadContentToRightTile(faqItemId);
    });
});

</script>
</body>
</html>