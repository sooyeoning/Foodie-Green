var recipe = "";

document.querySelector("#diary-form").addEventListener("submit", function(event) {
	event.preventDefault(); // 기본 submit 동작 차단

var title = document.getElementsByName("title")[0]?.value;
/* var writer = document.getElementsByName("writer")[0].value;
var writing = document.getElementsByName("writing")[0].value; */
var contents = document.getElementsByName("contents")[0]?.value;
var photo = document.getElementsByName("photo")[0]?.value;


	// AJAX 요청 생성
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "diarywrite", true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				alert("식단일기가 저장되었습니다.");
			} else {
				alert("식단일기 저장에 실패하였습니다.");
			}
		}
	};

	// 요청 본문에 데이터 전송
	var data = {
		title: title,
		contents: contents,
	//	writer:writer,
		photo:photo,
		recipes: recipe
	};
	console.log("Sending data to server:", data);
	xhr.send(JSON.stringify(data));
});

document.querySelector(".recipes-ch").addEventListener("click", function() {
	var recipePopup = document.getElementById("recipe-popup");
	var recipeList = document.getElementById("recipe-list");
	var availableRecipes = ["레시피테스트"];

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
