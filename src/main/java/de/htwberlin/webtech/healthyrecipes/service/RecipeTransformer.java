package de.htwberlin.webtech.healthyrecipes.service;

import de.htwberlin.webtech.healthyrecipes.persistence.RecipeEntity;
import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;

public class RecipeTransformer {
    public Recipe transformEntity(RecipeEntity recipeEntity){
        return new Recipe(
                recipeEntity.getRecipeID(),
                recipeEntity.getRecipeName(),
                recipeEntity.getRecipeDescription(),
                recipeEntity.getTime(),
                recipeEntity.getDifficulty()
        );
    }
}
