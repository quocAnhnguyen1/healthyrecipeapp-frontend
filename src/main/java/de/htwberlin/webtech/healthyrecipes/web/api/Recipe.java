package de.htwberlin.webtech.healthyrecipes.web.api;

public class Recipe {
    private Long recipeID;
    private String recipeName;
    private String recipeDescription;
    private Long time;
    private String difficulty;
    private int likes;

    public Recipe(Long recipeID, String recipeName, String recipeDescription, Long time, String difficulty, int likes){
        this.recipeID = recipeID;
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.time = time;
        this.difficulty = difficulty;
        this.likes = likes;
    }

    public Long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Long recipeID) {
        this.recipeID = recipeID;
    }

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
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
