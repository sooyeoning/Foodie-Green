package recipes;

public class SeasoningsDTO {
	int id;
	int recipe_id;
	String seasoning_name;
	String quantity;

	public SeasoningsDTO() {

	}

	public SeasoningsDTO(int id, int recipe_id, String seasoning_name, String quantity) {
		this.id = id;
		this.recipe_id = recipe_id;
		this.seasoning_name = seasoning_name;
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

	public String getSeasoning_name() {
		return seasoning_name;
	}

	public void setSeasoning_name(String seasoning_name) {
		this.seasoning_name = seasoning_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
