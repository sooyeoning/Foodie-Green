<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet" href="/css/recipes/imsiheaderfooter.css">
<link rel="stylesheet" href="/css/recipes/write.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<nav class="navbar">
			<ul class="nav-list">
				<li><a href="/">Home</a></li>
				<li><a href="/recipes">Recipes</a></li>

			</ul>
		</nav>
	</header>
	<div class="title-container">
	<input class="backbutton" type="button" value="<">
	<span class="title">레시피 작성</span>	
	<input class="writebutton" type="button" value="완료">
	
	<div class="tip-container">
    <span class="tip">업로드 완료 시 적립금 NP</span><br>
    <span class="tip2">*반복적이거나 성의 없는 콘텐츠는 관리자에 의해 <br> 콘텐츠 삭제 후 적립금이 반환 될 수 있습니다.</span>
	</div>
	
	<div class="upload-container">
	<button id="uploadbutton">+<br>대표 이미지 업로드</button>
	</div>
	
	<div class="recipes-info">
	
	<div class="recipes-name">
	<input class="recipesname" type="text" placeholder="레시피의 이름이 무엇인가요?" maxlength="20"><br>
	<p class="sectionline"></p>
	<textarea class="recipesinfo" rows="7" cols="50" placeholder="레시피에 대한 간단한 설명을 덧붙여주세요."></textarea>
	</div>
	<div class="recipes-detail">
	
    <p class="title-group">예상 소요시간*</p>
    <input class="timecut" type="button" value="15분 컷">
    <input class="timecut" type="button" value="30분 컷">
    <input class="timecut" type="button" value="45분 컷">
    <input class="timecut" type="button" value="45분 이상">
    
    <p class="sectionline"></p>
    
    <p class="title-group">카테고리*</p>
    <select class="selectcategory">
    <option>요리 분류</option>
    </select>
    <select class="selectcategory">
    <option>요리 종류</option>
    </select>
    
    <p class="sectionline"></p>
    
    <p class="title-group">해시태그*</p>
    <input class="recipes-kind" type="button" value="비건">
    <input class="recipes-kind" type="button" value="간단요리">
    <input class="recipes-kind" type="button" value="가벼운요리">
    <input class="recipes-kind" type="button" value="이색요리"> <br>
    <input class="recipes-kind" type="button" value="다이어트">
    <input class="recipes-kind" type="button" value="건강식">
    <input class="recipes-kind" type="button" value="집밥">
	</div>
	<p class="sectionline2"></p>
	
	<p class="title-group">기준량*</p>
	<button class="count1">-</button>
	<span>N</span>
	<button class="count1">+</button>
	<span style="margin-right: 28%">인분</span>
	
	<p class="title-group">필수재료*</p>
	<input class="ingname" type="text" placeholder="예) 당근">
	<input class="ingcount" type="text" placeholder="예) 1개">
	<input class="canclebutton" type="button" value="취소"><br>
	<input class="addbutton" type="button" value="추가">
	
	
	
	<p class="title-group" style="margin-bottom: 0">부재료</p>
	<input class="addbutton" type="button" value="추가">
	
	<p class="title-group" style="margin-bottom: 0">양념</p>
	<input class="addbutton" type="button" value="추가">
	
	<p style="margin-top: 50px" class="sectionline2"></p>
	
	<p class="title-group" style="margin-bottom: 0">만드는 방법*</p>
	<input class="howmake" type="text" placeholder="만드는 방법을 입력하세요." maxlength="150" ><br>
	<input class="imagebutton" type="button" value="이미지 업로드(선택) +"><br>
	<input class="upbutton" type="button" value="위로">
	<input class="downbutton" type="button" value="아래로">
	<input class="canclebutton2" type="button" value="취소"> <br>
	
	<input class="addbutton2" type="button" value="단계 추가"><br>
	<input class="addbutton3" type="button" value="TIP 추가"> 
	
	</div>
	
	</div>
	
	<footer class="footer">
		<p>&copy; 2023 Your Company. All rights reserved.</p>
	</footer>
</body>
</html>