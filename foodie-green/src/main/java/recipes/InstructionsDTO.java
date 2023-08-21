package recipes;

public class InstructionsDTO {
	int id;
	int recipe_id;
	int step_number;
	String instruction_text;
	String photo;

	public InstructionsDTO() {

	}

	public InstructionsDTO(int id, int recipe_id, int step_number, String instruction_text, String photo) {
		this.id = id;
		this.recipe_id = recipe_id;
		this.step_number = step_number;
		this.instruction_text = instruction_text;
		this.photo = photo;
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

	public int getStep_number() {
		return step_number;
	}

	public void setStep_number(int step_number) {
		this.step_number = step_number;
	}

	public String getInstruction_text() {
		return instruction_text;
	}

	public void setInstruction_text(String instruction_text) {
		this.instruction_text = instruction_text;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
