package recipes;

public class IngredientDTO {
	int id;
	int recipe_id;
	String ingredient_name;
	String quantity;

	public IngredientDTO() {

	}

	public IngredientDTO(int id, int recipe_id, String ingredient_name, String quantity) {
		this.id = id;
		this.recipe_id = recipe_id;
		this.ingredient_name = ingredient_name;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getIngredient_name() {
		return ingredient_name;
	}

	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
