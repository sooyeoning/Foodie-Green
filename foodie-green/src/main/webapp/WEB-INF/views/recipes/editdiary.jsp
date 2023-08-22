<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>

<link rel="stylesheet" href="/css/recipes/diarywrite.css">
<script defer="defer" src="/js/recipes/editdiary.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<header style="margin-top: -22px;">
		<%@ include file="../home/header.jsp"%>
	</header>
	<div class="title-container">
		<form id="diary-form" method="post" action="/updateDiary/${diary.id}" enctype="multipart/form-data">
		<input type="hidden" name="diary_id" value="${diary.id}">
			<input class="backbutton" type="button" value="<"> <span class="title">식단일기 작성</span> <input class="writebutton" type="submit" value="완료">
			<div class="tip-container">
				<span class="tip">업로드 완료 시 적립금 NP</span><br> <span class="tip2">*반복적이거나 성의 없는 콘텐츠는 관리자에 의해<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				콘텐츠 삭제 후 적립금이 반환 될 수 있습니다.</span>
			</div>
			
    <div class="upload-container">
        <div id="upload-box" class="upload-box" onclick="openImagePicker()">+ 이미지 업로드</div>
        <input id="photo-upload" name="photo" id="photo" type="file" onchange="previewImage()" value="${diary.photo}">
    </div>
    
			<div class="recipes-info">
				<div class="diary-name">
					<input name="title" class="diary-date" type="date" value="${diary.title}">
					<p class="sectionline"></p>
					<textarea name="contents" class="diary-info" rows="7" cols="50" placeholder="자신의 식단을 간단히 소개해주세요.">${diary.contents}</textarea>
				</div>
				<div class="recipes-detail">
					<p class="sectionline"></p>
				</div>
				<!-- 해시태그 부분은 일단 주석 처리합니다.
 				<p class="hashtag-container">재료 해시태그</p>
				<input class="hashtagname" type="text" placeholder="예) 당근">
				<input class="hashtagadd" type="button" value="추가">
				<div class="hashtag-tags">
				</div>
				<input type="hidden" name="hashtags">
				-->
			</div>
 			<div class="recipesch-container">참고한 레시피</div>
			<input class="recipes-ch" type="button" value="선택"  id="select-recipe-btn">
			<div id="recipe-popup" class="popup">
				<div class="popup-content">
					<h2>참고한 레시피 선택</h2>
					<ul id="recipe-list">
						<!-- 레시피 목록이 여기에 동적으로 추가될 것입니다. -->
					</ul>
					<button id="close-popup" type="button">닫기</button>
				</div>
			</div>
			<div class="selected-recipes">
				<!-- 선택한 레시피가 여기에 표시될 것입니다. -->
			</div>
			<input type="hidden" name="recipes">
		</form>
	</div>
	<!-- footer -->
	<%@ include file="../home/footer.jsp"%>
	
<script>
function previewImage() {
    const photoUpload = document.getElementById('photo-upload');
    const uploadBox = document.getElementById('upload-box');
    const file = photoUpload.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function(e) {
            uploadBox.style.backgroundImage = 'url(' + e.target.result + ')';
            uploadBox.innerHTML = ""; // "+ 이미지 업로드" 텍스트 삭제
        }

        reader.readAsDataURL(file);
    }
}

function openImagePicker() {
    const photoUpload = document.getElementById('photo-upload');
    photoUpload.click();
}
</script>
</body>
</html>
