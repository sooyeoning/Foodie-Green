<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/store/detail.css">
<script defer="defer" src="js/store/detail.js"></script>
<script defer="defer" src="js/store/detail2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js" type="text/javascript"></script>
</head>
<body >
<%@ include file="../home/header.jsp"%>
<span style="padding-top:20px;"></span>
<div class = "card-wrapper">
  <div class = "card">
    <!-- card left -->
    <div class = "product-imgs">
      <div class = "img-display">
        <div class = "img-showcase">
          <img src = ${getDetail.imageurl} alt = "shoe image">
          <img src = ${getDetail.imageurl1} alt = "shoe image">
          <img src = ${getDetail.imageurl2} alt = "shoe image">
          <img src = ${getDetail.imageurl3} alt = "shoe image">
        </div>
      </div>
      <div class = "img-select">
        <div class = "img-item">
          <a  data-id = "1">
            <img src = ${getDetail.imageurl} alt = "shoe image">
          </a>
        </div>
        <div class = "img-item">
          <a  data-id = "2">
            <img src = ${getDetail.imageurl1} alt = "shoe image">
          </a>
        </div>
        <div class = "img-item">
          <a href = "#" data-id = "3">
            <img src = ${getDetail.imageurl2} alt = "shoe image">
          </a>
        </div>
        <div class = "img-item">
          <a href = "#" data-id = "4">
            <img src = ${getDetail.imageurl3} alt = "shoe image">
          </a>
        </div>
      </div>
    </div>
    <!-- card right -->
    <div class = "product-content">
      <h2 class = "product-title">${getDetail.foodname }</h2>
      <a href = "#" class = "product-link">${getDetail.badge}</a>
      

      <div class = "product-price">
        <p class = "last-price">기존 가격: <span>${getDetail.beforeprice }원</span></p>
        <p class = "new-price">현재 가격: <span>${getDetail.price }원 (${getDetail.discount }%)</span></p>
      </div>

      <div class = "product-detail">
        <h2>구매 안내 </h2>
        <!-- <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo eveniet veniam tempora fuga tenetur placeat sapiente architecto illum soluta consequuntur, aspernatur quidem at sequi ipsa!</p>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur, perferendis eius. Dignissimos, labore suscipit. Unde.</p> -->
        <ul>
          <li>수확 장소<span>${getDetail.loc }</span></li>
          <li>재배 특징<span>${getDetail.feature }</span></li>
          <!-- <li>Category: <span>Shoes</span></li>
          <li>Shipping Area: <span>All over the world</span></li> -->
          <li>배송비<span>무료 배송</span></li>
        </ul>
      </div>

      <div class = "purchase-info">
        <input type = "number" min = "0" value = "1">
        <button type = "button" class = "btn" id="money-btn">
          <p>즉시 구매하기</p> <i class = "fas fa-shopping-cart"></i>
        </button>
        <button type = "button" class = "btn"><p>장바구니 담기</p></button>
      </div>

      <div class = "social-links">
        <p>공유하기 &nbsp </p>
        <a href = "#">
          <i class = "fab fa-facebook-f"><img src="img/store/link.png"></i>
        </a>
        <a href = "#">
          <i class = "fab fa-twitter"><img src="img/store/facebook.png"></i>
        </a>
        <a href = "#">
          <i class = "fab fa-instagram"><img src="img/store/kakao.png"></i>
        </a>
        <a href = "#">
          <i class = "fab fa-whatsapp"><img src="img/store/line.png"></i>
        </a>
        <a href = "#">
          <i class = "fab fa-pinterest"><img src="img/store/instagram.png"></i>
        </a>
      </div>
    </div>
  </div>
</div>



<div style="width:66%; text-align:center; margin:0 auto;">
<h2>상세 정보</h2>
<img src=img/store/${getDetail.id}.png>
</div>
<%@ include file="../store/topbutton.jsp"%>



 <%@ include file="../home/footer.jsp"%>
</body>
</html>