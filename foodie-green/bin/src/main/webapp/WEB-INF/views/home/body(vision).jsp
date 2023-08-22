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
						<h2>Made to be fast</h2>
						<p>Lorem Deserunt maiores minima ipsa. Adipisci, corrupti,
							voluptatibus! Similique quidem necessitatibus provident.</p>
					</div>
				</section>

				<section>
					<div class="image" data-type="background" data-speed="6"></div>
					<div class="stuff" data-type="content">Accusamus at ex amet
						perferendis atque fuga, ad earum, ipsa perspiciatis, dolore neque,
						accusantium consectetur quis voluptatibus culpa architecto animi
						natus facere expedita sed. Voluptatem odit explicabo amet neque
						aut.</div>
				</section>

				<section>
					<div class="image" data-type="background" data-speed="5"></div>
					<div class="stuff" data-type="content">Accusamus at ex amet
						perferendis atque fuga, ad earum, ipsa perspiciatis, dolore neque,
						accusantium consectetur quis voluptatibus culpa architecto animi
						natus facere expedita sed. Voluptatem odit explicabo amet neque
						aut.</div>
				</section>

				<section>
					<div class="image" data-type="background" data-speed="3"></div>
					<div class="stuff" data-type="content">Accusamus at ex amet
						perferendis atque fuga, ad earum, ipsa perspiciatis, dolore neque,
						accusantium consectetur quis voluptatibus culpa architecto animi
						natus facere expedita sed. Voluptatem odit explicabo amet neque
						aut.</div>
				</section>

				<section>
					<div class="image" data-type="background" data-speed="3"></div>
					<div class="stuff" data-type="content">Accusamus at ex amet
						perferendis atque fuga, ad earum, ipsa perspiciatis, dolore neque,
						accusantium consectetur quis voluptatibus culpa architecto animi
						natus facere expedita sed. Voluptatem odit explicabo amet neque
						aut.</div>
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