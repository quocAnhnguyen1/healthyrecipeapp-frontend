package de.htwberlin.webtech.service;

import de.htwberlin.webtech.healthyrecipes.persistence.RecipeEntity;
import de.htwberlin.webtech.healthyrecipes.service.RecipeTransformer;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class RecipeTransformerTest implements WithAssertions {
    private final RecipeTransformer underTest = new RecipeTransformer();

    @Test
    @DisplayName("should transform RecipeEntity to Recipe")
    void should_transform_recipe_entity_to_person(){
        var recipeEntity = Mockito.mock(RecipeEntity.class);
        doReturn(100L).when(recipeEntity).getRecipeID();
        doReturn("Pho").when(recipeEntity).getRecipeName();
        doReturn("Vietnamese beef bone broth with thinly sliced beef meat").when(recipeEntity).getRecipeDescription();
        doReturn(90L).when(recipeEntity).getTime();
        doReturn("easy").when(recipeEntity).getDifficulty();

        var result = underTest.transformEntity(recipeEntity);

        assertThat(result.getRecipeID()).isEqualTo(100);
        assertThat(result.getRecipeName()).isEqualTo("Pho");
        assertThat(result.getRecipeDescription()).isEqualTo("Vietnamese beef bone broth with thinly sliced beef meat");
        assertThat(result.getTime()).isEqualTo(90);
        assertThat(result.getDifficulty()).isEqualTo("easy");
    }
}
