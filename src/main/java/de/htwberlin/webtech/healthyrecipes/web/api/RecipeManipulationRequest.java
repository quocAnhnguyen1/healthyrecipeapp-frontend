package de.htwberlin.webtech.healthyrecipes.web.api;



public class RecipeManipulationRequest {

    private String recipeName;

    private String recipeDescription;

    private long time;

    private String difficulty;

    public RecipeManipulationRequest(String recipeName, String recipeDescription, long time, String difficulty) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.time = time;
        this.difficulty = difficulty;
    }

    public RecipeManipulationRequest(){}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
