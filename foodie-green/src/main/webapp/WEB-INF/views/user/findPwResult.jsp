<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/js/user/findPwResult.js"></script>
<link href="/css/user/content.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="../home/header.jsp"%>
	<div style="height: 400px;">
		<p>비밀번호: <%=request.getAttribute("pw") %></p>
	</div>	
	<%@ include file="../home/footer.jsp"%>

</body>

<style>
.mb-10 {
	margin-bottom: 10px !important;
}
.col-red{
	color: red;
}
</style>
</html>
