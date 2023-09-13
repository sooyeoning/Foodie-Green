<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/store/cart.css">
<script defer="defer" src="js/store/cart.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="../home/header.jsp"%>

<div style="padding-top:100px; width:66%; margin:0 auto;">

<h1>장바구니</h1>

<div class="shopping-cart">

  <div class="column-labels">
    <label class="product-image">Image</label>
    <label class="product-details">Product</label>
    <label class="product-price">가격</label>
    <label class="product-quantity">수량</label>
    <label class="product-removal">구매 취소</label>
    <label class="product-line-price">총 가격</label>
  </div>

  <div class="product">
    <div class="product-image">
      <img src="https://d3cpiew7rze14b.cloudfront.net/photos/7a8ee8bd-0832-4dd2-a42f-a01076ab0fbd.jpeg?w=640">
    </div>
    <div class="product-details">
      <div class="product-title">유기농 양배추즙 120포</div>
     <!--  <p class="product-description">The best dog bones of all time. Holy crap. Your dog will be begging for these things! I got curious once and ate one myself. I'm a fan.</p>
     --></div>
    <div class="product-price">39990</div>
    <div class="product-quantity">
      <input type="number" value="2" min="1">
    </div>
    <div class="product-removal">
      <button class="remove-product">
        구매 취소
      </button>
    </div>
    <div class="product-line-price">79980</div>
  </div>

  <div class="product">
    <div class="product-image">
      <img src="https://d3cpiew7rze14b.cloudfront.net/photos/6cb355f2-ebab-476b-ba5c-d8afb98319ce.jpeg?w=1024">
    </div>
    <div class="product-details">
      <div class="product-title">유기농 블루베리&포도 주스 - 40포</div>
      <!-- <p class="product-description">Who doesn't like lamb and rice? We've all hit the halal cart at 3am while quasi-blackout after a night of binge drinking in Manhattan. Now it's your dog's turn!</p>
     --></div>
    <div class="product-price">29600</div>
    <div class="product-quantity">
      <input type="number" value="1" min="1">
    </div>
    <div class="product-removal">
      <button class="remove-product">
        구매 취소
      </button>
    </div>
    <div class="product-line-price">29600</div>
  </div>

  <div class="totals">
    <div class="totals-item">
      <label>상품가격</label>
      <div class="totals-value" id="cart-subtotal">109580</div>
    </div>
    <!-- <div class="totals-item">
      <label>Tax (5%)</label>
      <div class="totals-value" id="cart-tax">3.60</div>
    </div> -->
    <div class="totals-item">
      <label>배송비</label>
      <div class="totals-value" id="cart-shipping">3000</div>
    </div>
    <div class="totals-item totals-item-total">
      <label>총 합계</label>
      <div class="totals-value" id="cart-total">112580</div>
    </div>
  </div>
      
      <button class="checkout" id="money-btn">결제하기</button>

</div>
</div>


 <%@ include file="../home/footer.jsp"%>
</body>
</html>