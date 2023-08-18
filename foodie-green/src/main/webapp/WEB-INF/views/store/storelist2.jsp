<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/store/storelist.css">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-md-9">
	<div class="title"><span>야채 가게</span></div>
	
	<!-- 반복 -->
	<c:forEach items="${getStorelist}" var="storelist">
	<div class="col-sm-4 col-md-3 box-product-outer">
	
        <div class="box-product">
            <div class="img-wrapper">
                <a href="detail.html">
                    <img alt="Product" src="https://d3cpiew7rze14b.cloudfront.net/photos/7a8ee8bd-0832-4dd2-a42f-a01076ab0fbd.jpeg?w=360">
                </a>
                <div class="tags">
                    <span class="label-tags"><span class="label label-danger">Sale</span></span>
                    <span class="label-tags"><span class="label label-info">Featured</span></span>
                    <span class="label-tags"><span class="label label-warning">Polo</span></span>
                </div>
                <div class="option">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Add to Cart">구매하기<i class="ace-icon fa fa-shopping-cart"></i></a>
                    
                </div>
            </div>
            <h6><a href="detail.html">IncultGeo Print Polo T-Shirt</a></h6>
            <div class="price">
                <div>${storelist.price }원<span class="price-down">${storelist.discount }%</span></div>
                <span class="price-old">${storelist.beforeprice }원</span>
            </div>
            <div class="rating">
              
            </div>
        </div>
    </div>
	</c:forEach>
    
  
    <div class="col-sm-4 col-md-3 hidden-xs box-product-outer">
        <div class="box-product">
            <div class="img-wrapper">
                <a href="detail.html">
                    <img alt="Product" src="https://bootdey.com/img/Content/avatar/avatar6.png">
                </a>
                <div class="tags">
                    <span class="label-tags"><span class="label label-danger">Sale</span></span>
                    <span class="label-tags"><span class="label label-info">Featured</span></span>
                    <span class="label-tags"><span class="label label-warning">Polo</span></span>
                </div>
                <div class="option">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Add to Cart"><i class="ace-icon fa fa-shopping-cart"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Compare"><i class="ace-icon fa fa-align-left"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Wishlist"><i class="ace-icon fa fa-heart"></i></a>
                </div>
            </div>
            <h6><a href="detail.html">Tommy HilfigerNavy Blue Printed Polo T-Shirt</a></h6>
            <div class="price">
                <div>$45.27<span class="price-down">-10%</span></div>
                <span class="price-old">$15.00</span>
            </div>
           
        </div>
    </div>
    <div class="col-sm-4 col-md-3 hidden-xs box-product-outer">
        <div class="box-product">
            <div class="img-wrapper">
                <a href="detail.html">
                    <img alt="Product" src="https://bootdey.com/img/Content/avatar/avatar3.png">
                </a>
                <div class="tags">
                    <span class="label-tags"><span class="label label-danger">Sale</span></span>
                    <span class="label-tags"><span class="label label-info">Featured</span></span>
                    <span class="label-tags"><span class="label label-warning">Polo</span></span>
                </div>
                <div class="option">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Add to Cart"><i class="ace-icon fa fa-shopping-cart"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Compare"><i class="ace-icon fa fa-align-left"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Wishlist"><i class="ace-icon fa fa-heart"></i></a>
                </div>
            </div>
            <h6><a href="detail.html">WranglerNavy Blue Solid Polo T-Shirt</a></h6>
            <div class="price">
                <div>$25.59<span class="price-down">-10%</span></div>
                <span class="price-old">$15.00</span>
            </div>
            <div class="rating">
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star-half-o"></i>
                <a href="#">(4 reviews)</a>
            </div>
        </div>
    </div>
    <div class="col-sm-4 col-md-3 hidden-sm hidden-xs box-product-outer">
        <div class="box-product">
            <div class="img-wrapper">
                <a href="detail.html">
                    <img alt="Product" src="https://bootdey.com/img/Content/avatar/avatar5.png">
                </a>
                <div class="tags">
                    <span class="label-tags"><span class="label label-danger">Sale</span></span>
                    <span class="label-tags"><span class="label label-info">Featured</span></span>
                    <span class="label-tags"><span class="label label-warning">Polo</span></span>
                </div>
                <div class="option">
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Add to Cart"><i class="ace-icon fa fa-shopping-cart"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Compare"><i class="ace-icon fa fa-align-left"></i></a>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Wishlist"><i class="ace-icon fa fa-heart"></i></a>
                </div>
            </div>
            <h6><a href="detail.html">NikeAs Matchup -Pq Grey Polo T-Shirt</a></h6>
            <div class="price">
                <div>$15.79<span class="price-down">-10%</span></div>
                <span class="price-old">$15.00</span>
            </div>
            <div class="rating">
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star"></i>
                <i class="ace-icon fa fa-star-half-o"></i>
                <a href="#">(5 reviews)</a>
            </div>
        </div>
    </div>
    

   
    
   
</div>
  </div>
  </div>
</body>
</html>