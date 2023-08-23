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
<link rel="stylesheet" href="/css/home/main2.css">
</head>

<body>
	<!-- body -->
	<!-- main 부분 -->
	<main>

		<!--
 Author: Hendry Sadrak
-->

		<div class="container">
			<section>
				<div class="image" data-type="background" data-speed="2"></div>
				<div class="stuff" data-type="content">
					<h1>가장 신선한 채소들을 소비자에게 전달합니다.</h1>
					<h2>Foodie&Green</h2>
				</div>
			</section>

			<section>
				<div class="image" data-type="background" data-speed="7"></div>
				<div class="stuff" data-type="content">
					<h2>우리의 미션</h2>
					<br>
					<p>생산부터 유통까지 친환경을 선택합니다.</p>
					<p>소비자의 건강한 식탁과 미래를 위한 환경이 지속가능하게 이끕니다.</p>
				</div>
			</section>

			<section>
				<div class="image" data-type="background" data-speed="6"></div>
				<div class="stuff" data-type="content">
					<h2>더 쉽고 건강해진 채소 생활</h2>
					<br>
					<p>유통구조를 간소화하여 가격은 낮추고,</p>
					<p>소비자들에게 더 빠르고 신선한 채소를 전달합니다.</p>
				</div>
			</section>

			<section>
				<div class="image" data-type="background" data-speed="5"></div>
				<div class="stuff" data-type="content">
					<h2>건강한 채소생활을 위한 공유 플랫폼</h2>
					<br>
					<p>매주 제공되는 신선한 채소를 바탕으로,</p>
					<p>소비자들이 각자의 채소 경험을 공유하도록 이끕니다.</p>
				</div>
			</section>

			<section>
				<div class="image" data-type="background" data-speed="3"></div>
				<div class="stuff" data-type="content">
					<h2>환경 보호를 통한 지속가능한 식탁</h2><br>
					<p>버려지는 농산물의 최소화를 지향합니다.</p>
					<p>자원의 낭비를 막고 환경보호에 기여합니다.</p>
				</div>
			</section>

		</div>



	</main>
</body>

<script>
	//makes the parallax elements
	function parallaxIt() {
		// create variables
		var $fwindow = $(window);
		var scrollTop = window.pageYOffset
				|| document.documentElement.scrollTop;

		var $contents = [];
		var $backgrounds = [];

		// for each of content parallax element
		$('[data-type="content"]').each(function(index, e) {
			var $contentObj = $(this);

			$contentObj.__speed = ($contentObj.data('speed') || 1);
			$contentObj.__fgOffset = $contentObj.offset().top;
			$contents.push($contentObj);
		});

		// for each of background parallax element
		$('[data-type="background"]').each(function() {
			var $backgroundObj = $(this);

			$backgroundObj.__speed = ($backgroundObj.data('speed') || 1);
			$backgroundObj.__fgOffset = $backgroundObj.offset().top;
			$backgrounds.push($backgroundObj);
		});

		// update positions
		$fwindow
				.on(
						'scroll resize',
						function() {
							scrollTop = window.pageYOffset
									|| document.documentElement.scrollTop;

							$contents.forEach(function($contentObj) {
								var yPos = $contentObj.__fgOffset - scrollTop
										/ $contentObj.__speed;

								$contentObj.css('top', yPos);
							})

							$backgrounds
									.forEach(function($backgroundObj) {
										var yPos = -((scrollTop - $backgroundObj.__fgOffset) / $backgroundObj.__speed);

										$backgroundObj.css({
											backgroundPosition : '50% ' + yPos
													+ 'px'
										});
									});
						});

		// triggers winodw scroll for refresh
		$fwindow.trigger('scroll');
	};

	parallaxIt();
</script>
</html>