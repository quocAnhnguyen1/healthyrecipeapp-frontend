package de.htwberlin.webtech.healthyrecipes.web.api;

public class RecipeManipulationRequest {
    private String recipeName;
    private String recipeDescription;
    private long time;
    private String difficulty;
    private int likes;

    public RecipeManipulationRequest(String recipeName, String recipeDescription, long time, String difficulty, int likes) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.time = time;
        this.difficulty = difficulty;
        this.likes = likes;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
