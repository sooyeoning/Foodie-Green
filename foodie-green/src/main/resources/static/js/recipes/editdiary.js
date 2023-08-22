var recipe = "";

document.querySelector("#diary-form").addEventListener("submit", function(event) {
	event.preventDefault(); // 기본 submit 동작 차단

	var title = document.getElementsByName("title")[0]?.value;
	var contents = document.getElementsByName("contents")[0]?.value;
	var recipes = document.getElementsByName("recipes")[0]?.value;
	var photo = document.getElementsByName("photo")[0]?.files[0]; // 파일을 받는 경우
var formAction = document.getElementById("diary-form").action;
console.log("Form Action URL:", formAction);
if (!title) {
		alert('날짜를 먼저 입력해주세요.');
		return;
	} else if (!contents) {
		alert('내용을 먼저 입력해주세요.');
		return;
	} else if (!photo) {
		alert('사진을 먼저 입력해주세요.');
		return;
	}

	var formData = new FormData(); // FormData 객체 생성
	formData.append("title", title);
	formData.append("contents", contents);
	formData.append("photo", photo);
	formData.append("recipes", recipes);

	// AJAX 요청 생성
	var xhr = new XMLHttpRequest();
	xhr.open("POST", document.getElementById("diary-form").action, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				var isSaved = confirm("식단일기가 저장되었습니다.");
				if (isSaved) {
					window.location.href = "/diary"; // URL을 diarydetail.jsp로 변경
				}
			} else {
				alert("식단일기 저장에 실패하였습니다.");
			}
		}
	};

	xhr.send(formData); // FormData 객체를 전송
	console.log("Sending data to server:", formData);
});

document.querySelector(".recipes-ch").addEventListener("click", function() {
	var recipePopup = document.getElementById("recipe-popup");
	var recipeList = document.getElementById("recipe-list");
	var availableRecipes = ["풋마늘 겉절이", "못난이 뱅쇼", "토마토매실절임", "야끼파스타"];

	recipeList.innerHTML = ''; // 이전에 추가된 레시피 목록 초기화
	for (var i = 0; i < availableRecipes.length; i++) {
		var recipeItem = document.createElement("li");
		recipeItem.textContent = availableRecipes[i];
		recipeItem.addEventListener("click", function() {
			var selectedRecipes = document.querySelector(".selected-recipes");
			selectedRecipes.textContent = '';

			var selectedRecipe = document.createElement("span");
			selectedRecipe.className = "selected-recipe";
			selectedRecipe.textContent = this.textContent;
			selectedRecipes.appendChild(selectedRecipe);

			recipe = this.textContent; // 선택한 레시피 저장

			// 숨겨진 input 필드에 값을 저장하는 코드
			document.querySelector('input[name="recipes"]').value = recipe;

			console.log("Selected recipe:" + recipe);
			recipePopup.style.display = "none";
		});
		recipeList.appendChild(recipeItem);
	}

	recipePopup.style.display = "block";
});

document.getElementById("close-popup").addEventListener("click", function() {
	var recipePopup = document.getElementById("recipe-popup");
	recipePopup.style.display = "none";
});
