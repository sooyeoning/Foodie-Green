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

				<!-- 오른쪽 섹션 -->
				<div class="right-section">
					<div class="post-list">
						<div class="post-number"><img src="/img/home/lightbulb.png"></div>
						<div class="post-title">구독 정지는 어떻게 하나요?</div>
						<div class="expand-button">
							<img class="dropdown" src="/img/home/dropdown.png"
								onclick="toggleContent(1)">
						</div>

					</div>
					<div id="content-1" class="expanded-content">

						<p>구독 정지는 마이페이지에서 아래 경로를 통해 가능합니다.<br>
[로그인 > 마이페이지 하단 > 채소 플랜 > 구독 정지]</p>
					</div>

					<div class="post-list">
						<div class="post-number"><img src="/img/home/lightbulb.png"></div>
						<div class="post-title">구독 정지를 해제하고 다시 받을 수 있나요?</div>
						<div class="expand-button">
							<img class="dropdown" src="/img/home/dropdown.png"
								onclick="toggleContent(2)">
						</div>
					</div>
					<div id="content-2" class="expanded-content">

						<p>
네, 물론입니다. 언제든 원하실 때 다시 배송을 받을 수 있습니다.<br>
[로그인 > 내 채소박스 > 다시 시작하기]
						</p>
					</div>

<!-- 					<div class="post-list">
						<div class="post-number">3</div>
						<div class="post-title">품목 구성을 바꿀 수 있나요?</div>
						<div class="expand-button">
							<img class="dropdown" src="/img/home/dropdown.png"
								onclick="toggleContent(3)">
						</div>
					</div>
					<div id="content-3" class="expanded-content">
						<p>
[채소박스 품목 바꾸기]를 통해 구성을 변경할 수 있습니다. 이번 주 구출된 품목 중 이미 집에 많이 있거나 선호하지 않는 품목이 있다면 제외하고 다른 품목을 담아보세요. 고객님이 담고 최종 확정한 구성대로 결제 및 배송이 진행됩니다.
						</p>
					</div> -->

<!-- 					<div class="post-list">
						<div class="post-number">4</div>
						<div class="post-title">커뮤니티 탭과 여행지 추천 탭의 검색결과가 왜 다른가요?</div>
						<div class="expand-button">
							<img class="dropdown" src="/img/home/dropdown.png"
								onclick="toggleContent(4)">
						</div>
					</div>
					<div id="content-4" class="expanded-content">
						<p>
							위트에서 제공되는 검색 화면은 진입하는 탭마다 고객의 편의를 위해 검색 결과가 다를 수 있습니다. <br>
							<br> 여행지 추천 탭의 경우 위트에서 제공하는 콘텐츠를 소비하기 편리하도록 검색 결과를 구성하였습니다.
							<br> <br> 커뮤니티탭에서는 페이지 상단의 지역 탭에서 효과적으로 지역별 커뮤니티 검색 결과를
							확인하실 수 있습니다.<br> <br>
						</p>
					</div>

					<div class="post-list">
						<div class="post-number">5</div>
						<div class="post-title">
							<태블릿>모바일과 다른 언어로 보여요. 
						</div>
						<div class="expand-button">
							<img class="dropdown" src="/img/home/dropdown.png"
								onclick="toggleContent(5)">
						</div>
					</div>
					<div id="content-5" class="expanded-content">
						<p>
							안드로이드 태블릿 위트의 언어 설정은, 사용자가 OS에서 설정한 언어 설정을 따라 노출됩니다.<br> <br>
							휴대폰과 안드로이드 태블릿의 언어가 다르게 설정되어 있는 경우 각각 다르게 표시되는 것이 정상입니다.
						</p>
					</div> -->

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
</body>
</html>