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
<link rel="stylesheet" href="/css/home/main3.css">
<link rel="stylesheet" href="/css/home/main4.css">
<link rel="stylesheet" href="/css/home/main5.css">
<link rel="stylesheet" href="/css/home/main6.css">
</head>

<body>
	<!-- body -->
	<!-- main 부분 -->
	<main>
		<!-- section 1 -->
		<div id="body" style="height: 700px; background-color: #FDEEDC;">
			<div class="slider">
				<div class="slide_viewer">
					<div class="slide_group">
						<div class="slide">
							<img src="/img/main-fruit01.jpg" alt="이미지슬라이드1">
						</div>
						<div class="slide">
							<img src="/img/main-fruit02.jpg" alt="이미지슬라이드2">
						</div>
						<div class="slide">
							<img src="/img/main-fruit03.jpg" alt="이미지슬라이드3">
						</div>
						<div class="slide">
							<img src="/img/main-fruit04.jpg" alt="이미지슬라이드4">
						</div>
					</div>
				</div>
			</div>
			<!-- End // .slider -->




			<div class="slide_buttons"></div>


			<div class="directional_nav">
				<div class="previous_btn" title="Previous">
					<svg version="1.1" xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
						width="65px" height="65px" viewBox="-11 -11.5 65 66">
      <g>
        <g>
          <path fill="#474544"
							d="M-10.5,22.118C-10.5,4.132,4.133-10.5,22.118-10.5S54.736,4.132,54.736,22.118
			c0,17.985-14.633,32.618-32.618,32.618S-10.5,40.103-10.5,22.118z M-8.288,22.118c0,16.766,13.639,30.406,30.406,30.406 c16.765,0,30.405-13.641,30.405-30.406c0-16.766-13.641-30.406-30.405-30.406C5.35-8.288-8.288,5.352-8.288,22.118z" />
          <path fill="#474544"
							d="M25.43,33.243L14.628,22.429c-0.433-0.432-0.433-1.132,0-1.564L25.43,10.051c0.432-0.432,1.132-0.432,1.563,0	c0.431,0.431,0.431,1.132,0,1.564L16.972,21.647l10.021,10.035c0.432,0.433,0.432,1.134,0,1.564	c-0.215,0.218-0.498,0.323-0.78,0.323C25.929,33.569,25.646,33.464,25.43,33.243z" />
        </g>
      </g>
    </svg>
				</div>
				<div class="next_btn" title="Next">
					<svg version="1.1" xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
						width="65px" height="65px" viewBox="-11 -11.5 65 66">
      <g>
        <g>
          <path fill="#474544"
							d="M22.118,54.736C4.132,54.736-10.5,40.103-10.5,22.118C-10.5,4.132,4.132-10.5,22.118-10.5	c17.985,0,32.618,14.632,32.618,32.618C54.736,40.103,40.103,54.736,22.118,54.736z M22.118-8.288	c-16.765,0-30.406,13.64-30.406,30.406c0,16.766,13.641,30.406,30.406,30.406c16.768,0,30.406-13.641,30.406-30.406 C52.524,5.352,38.885-8.288,22.118-8.288z" />
          <path fill="#474544"
							d="M18.022,33.569c 0.282,0-0.566-0.105-0.781-0.323c-0.432-0.431-0.432-1.132,0-1.564l10.022-10.035 			L17.241,11.615c 0.431-0.432-0.431-1.133,0-1.564c0.432-0.432,1.132-0.432,1.564,0l10.803,10.814c0.433,0.432,0.433,1.132,0,1.564 L18.805,33.243C18.59,33.464,18.306,33.569,18.022,33.569z" />
        </g>
      </g>
    </svg>
				</div>
			</div>
			<!-- End // .directional_nav -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		</div>



		<!-- section 2 -->
		<div id="body" style="height: 500px; background-color: #FDEEDC;">
			<div class="section2-container">
				<div class="box">
					<img src="/img/section2-pic01.png">
					<h2>가장 소량씩, 신선하게</h2>
					<br>
					<h4>적은 양으로 부담없이 즐겨요.</h4>
				</div>
				<div class="box">
					<img src="/img/section2-pic02.png">
					<h2>친환경 채소를 가장 저렴하게!</h2>
					<br>
					<h4>30% off, 합리적인 가격으로 만나요.</h4>
				</div>
				<div class="box">
					<img src="/img/section2-pic03.png">
					<h2>환경에 한 발 더 나은 선택</h2>
					<br>
					<h4>환경에 더 가까운 생산과 소비자를 지지해요.</h4>
				</div>
			</div>

		</div>




		<!-- section 3 -->
		<div id="body" style="height: 800px; background-color: #FDEEDC;">
			<div class="cont">
				<div class="mouse"></div>
				<div class="app">
					<div class="app__bgimg">
						<div class="app__bgimg-image app__bgimg-image--1"></div>
						<div class="app__bgimg-image app__bgimg-image--2"></div>
					</div>
					<div class="app__img">
						<img onmousedown="return false"
							src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/537051/whiteTest4.png"
							alt="city" />
					</div>

					<div class="app__text app__text--1">
						<div class="app__text-line app__text-line--4">신선한 채소 레시피</div>
						<div class="app__text-line app__text-line--3">풋마늘 겉절이</div>
						<div class="app__text-line app__text-line--2"><a href="http://localhost:8888/recipesdetail/1">바로가기</a></div>
						<div class="app__text-line app__text-line--1">
							<img
								src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/537051/opus-attachment.png"
								alt="" />
						</div>
					</div>

					<div class="app__text app__text--2">
						<div class="app__text-line app__text-line--4">쉽고 간단한 어린이 간식</div>
						<div class="app__text-line app__text-line--3">토마토 매실절임</div>
						<div class="app__text-line app__text-line--2"><a href="http://localhost:8888/recipesdetail/3">바로가기</a></div>
						<div class="app__text-line app__text-line--1">
							<img
								src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/537051/opus-attachment.png"
								alt="" />
						</div>
					</div>
				</div>
				<div class="pages">
					<ul class='pages__list'>
						<li data-target='1'
							class='pages__item pages__item--1 page__item-active'></li>
						<li data-target='2' class='pages__item pages__item--2'></li>
					</ul>
				</div>
			</div>

		</div>

		<!-- section 4 -->
		<div id="body" style="height: 500px; background-color: #FDEEDC;">
			<div
				style="display: flex; justify-content: center; align-items: center;">
				<h1 style="text-weight: bold text-align:center;">더 쉽고 건강해진 채소생활</h1>
			</div>
			<div class="section4-container">

				<div class="section4-box2">
					<div class="section4-smallBox">
					<img src="/img/section4-pic01.png"></div>
					<h2 style="color: orange;">미리 구출 품목을 확인해요</h2>
					<br>
					<h4>매주 알림톡을 통해</h4>
					<br>
					<h4>이번 주 구출된 품목을 알려드려요.</h4>
				</div>
				<div class="section4-box2">
					<div class="section4-smallBox">
					<img src="/img/section4-pic02.png">
					</div>
					<h2 style="color: orange;">품목 구성은 내 마음대로</h2>
					<br>
					<h4>원하는 구성으로 품목을 바꿀 수 있어요.</h4>
					<br>
					<h4>직접 바꾸지 않으면 추천 구성으로 보내드려요.</h4>
				</div>
			</div>

		</div>
	</main>
</body>

<script>
	$('.slider').each(function() {
		var $this = $(this);
		var $group = $this.find('.slide_group');
		var $slides = $this.find('.slide');
		var bulletArray = [];
		var currentIndex = 0;
		var timeout;

		function move(newIndex) {
			var animateLeft, slideLeft;

			advance();

			if ($group.is(':animated') || currentIndex === newIndex) {
				return;
			}

			bulletArray[currentIndex].removeClass('active');
			bulletArray[newIndex].addClass('active');

			if (newIndex > currentIndex) {
				slideLeft = '100%';
				animateLeft = '-100%';
			} else {
				slideLeft = '-100%';
				animateLeft = '100%';
			}

			$slides.eq(newIndex).css({
				display : 'block',
				left : slideLeft
			});
			$group.animate({
				left : animateLeft
			}, function() {
				$slides.eq(currentIndex).css({
					display : 'none'
				});
				$slides.eq(newIndex).css({
					left : 0
				});
				$group.css({
					left : 0
				});
				currentIndex = newIndex;
			});
		}

		function advance() {
			clearTimeout(timeout);
			timeout = setTimeout(function() {
				if (currentIndex < ($slides.length - 1)) {
					move(currentIndex + 1);
				} else {
					move(0);
				}
			}, 4000);
		}

		$('.next_btn').on('click', function() {
			if (currentIndex < ($slides.length - 1)) {
				move(currentIndex + 1);
			} else {
				move(0);
			}
		});

		$('.previous_btn').on('click', function() {
			if (currentIndex !== 0) {
				move(currentIndex - 1);
			} else {
				move(3);
			}
		});

		$.each($slides, function(index) {
			var $button = $('<a class="slide_btn">&bull;</a>');

			if (index === currentIndex) {
				$button.addClass('active');
			}
			$button.on('click', function() {
				move(index);
			}).appendTo('.slide_buttons');
			bulletArray.push($button);
		});

		advance();
	});
</script>

<script>
	$(document).ready(
			function() {
				const $app = $('.app');
				const $img = $('.app__img');
				const $pageNav1 = $('.pages__item--1');
				const $pageNav2 = $('.pages__item--2');
				let animation = true;
				let curSlide = 1;
				let scrolledUp, nextSlide;

				let pagination = function(slide, target) {
					animation = true;
					if (target === undefined) {
						nextSlide = scrolledUp ? slide - 1 : slide + 1;
					} else {
						nextSlide = target;
					}

					$('.pages__item--' + nextSlide).addClass(
							'page__item-active');
					$('.pages__item--' + slide)
							.removeClass('page__item-active');

					$app.toggleClass('active');
					setTimeout(function() {
						animation = false;
					}, 3000);
				};

				let navigateDown = function() {
					if (curSlide > 1)
						return;
					scrolledUp = false;
					pagination(curSlide);
					curSlide++;
				};

				let navigateUp = function() {
					if (curSlide === 1)
						return;
					scrolledUp = true;
					pagination(curSlide);
					curSlide--;
				};

				setTimeout(function() {
					$app.addClass('initial');
				}, 1500);

				setTimeout(function() {
					animation = false;
				}, 4500);

				$(document).on('mousewheel DOMMouseScroll', function(e) {
					var delta = e.originalEvent.wheelDelta;
					if (animation)
						return;
					if (delta > 0 || e.originalEvent.detail < 0) {
						navigateUp();
					} else {
						navigateDown();
					}
				});

				$(document).on("click", ".pages__item:not(.page__item-active)",
						function() {
							if (animation)
								return;
							let target = +$(this).attr('data-target');
							pagination(curSlide, target);
							curSlide = target;
						});
			});
</script>
</html>
