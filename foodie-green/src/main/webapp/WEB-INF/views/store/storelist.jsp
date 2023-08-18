<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/store/storelist.css">
</head>
<body>
<%@ include file="../home/header.jsp"%>
<div class="container">
<div class="row">
<div class="col-md-9">
	<div class="title"><span>야채 가게</span></div>
	
	<!-- 반복 -->
	<c:forEach items="${getStorelist}" var="storelist">
	<div class="col-sm-4 col-md-3 box-product-outer">
	
                <div class="tags">
                    <span class="label-tags"><span class="label label-danger">${storelist.badge }</span></span>
                    <!-- <span class="label-tags"><span class="label label-info">Featured</span></span>
                    <span class="label-tags"><span class="label label-warning">Polo</span></span> -->
                </div>
        <div class="box-product">
            <div class="img-wrapper">
                <a href="detail.html">
                    <img alt="Product" src=${storelist.imageurl} style="">
                </a>
                <div class="option">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Add to Cart">구매하기<i class="ace-icon fa fa-shopping-cart"></i></a>
                    
                </div>
            </div>
            <h4>${storelist.foodname}</h4>
            <div class="price">
                <div>${storelist.price }원<span class="price-down">${storelist.discount }%</span></div>
                <span class="price-old" style="text-decoration:line-through;">${storelist.beforeprice }원</span>
            </div>
            <div class="rating">
              
            </div>
        </div>
    </div>
	</c:forEach>
    

   
    
   
</div>
  </div>
  </div>
  <%@ include file="../home/footer.jsp"%>
</body>
</html>