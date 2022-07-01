package de.htwberlin.webtech.healthyrecipes.persistence;

import javax.persistence.*;

@Entity(name = "recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeID", nullable = false)
    private long recipeID;

    @Column(name = "recipeName", nullable = false)
    private String recipeName;

    @Column(name = "recipeDescription", nullable = false)
    private String recipeDescription;

    @Column(name = "time", nullable = false)
    private long time;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    public RecipeEntity(String recipeName, String recipeDescription, long time, String difficulty) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.time = time;
        this.difficulty = difficulty;
    }

    protected RecipeEntity() {
    }

    public long getRecipeID() {
        return recipeID;
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
