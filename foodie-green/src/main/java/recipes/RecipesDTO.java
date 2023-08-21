package recipes;

import java.util.List;

public class RecipesDTO {
	int id;
	String recipe_name;
	String recipe_info;
	String estimated_time;
	String category;
	String sub_category;
	String hashtag;
	int quantity;
	int likecnt;
	String photo;
	String created_at;
	List<IngredientDTO> ingredients;

	public RecipesDTO() {

	}

	public RecipesDTO(int id, String recipe_name, String recipe_info, String estimated_time, String category,
			String sub_category, String hashtag, int quantity, int likecnt, String photo, String created_at) {
		this.id = id;
		this.recipe_name = recipe_name;
		this.recipe_info = recipe_info;
		this.estimated_time = estimated_time;
		this.category = category;
		this.sub_category = sub_category;
		this.hashtag = hashtag;
		this.quantity = quantity;
		this.likecnt = likecnt;
		this.photo = photo;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_info() {
		return recipe_info;
	}

	public void setRecipe_info(String recipe_info) {
		this.recipe_info = recipe_info;
	}

	public String getEstimated_time() {
		return estimated_time;
	}

	public void setEstimated_time(String estimated_time) {
		this.estimated_time = estimated_time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {

		this.created_at = created_at;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}
}