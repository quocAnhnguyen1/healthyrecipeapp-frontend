package de.htwberlin.webtech.healthyrecipes;

import de.htwberlin.webtech.healthyrecipes.service.RecipeService;
import de.htwberlin.webtech.healthyrecipes.web.RecipeRestController;
import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(RecipeRestController.class)
public class RecipeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @DisplayName("should return found recipes from recipe service")
    void should_return_found_recipe_from_recipe_service() throws Exception{

        var recipes = List.of(
                new Recipe(1,"French Toast", "French Toast with fruit smoothie", 30, "easy"),
                new Recipe(2,"Porridge", "Porridge with fruits and some honey", 30, "easy")
        );
        doReturn(recipes).when(recipeService).findAll();

        mockMvc.perform(get("/api/v1/recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].recipeName").value("French Toast"))
                .andExpect(jsonPath("$[0].recipeDescription").value("French Toast with fruit smoothie"))
                .andExpect(jsonPath("$[0].time").value(30))
                .andExpect(jsonPath("$[0].difficulty").value("easy"))
                .andExpect(jsonPath("$[1].recipeName").value("Porridge"))
                .andExpect(jsonPath("$[1].recipeDescription").value("Porridge with fruits and some honey"))
                .andExpect(jsonPath("$[1].time").value(30))
                .andExpect(jsonPath("$[1].difficulty").value("easy"));
    }

    @Test
    @DisplayName("should return 404 if recipe is not found")
    void should_return_404_if_recipe_is_not_found() throws Exception{
        doReturn(null).when(recipeService).findById(anyLong());

        mockMvc.perform(get("/api/v1/recipes/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_location_header_when_creating_a_person() throws Exception {
        String recipeToCreateAsJson = "{\"recipeName\": \"French Toast\", \"recipeDescription\":\"French Toast with fruit smoothie\", \"time\":\"30\", \"difficulty\":\"easy\"}";
        var recipe = new Recipe(123, null, null, 30, null);
        doReturn(recipe).when(recipeService).create(any());

        mockMvc.perform(
                        post("/api/v1/recipes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeToCreateAsJson)
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/recipes/" + recipe.getRecipeID()))));
    }

//    @Test
//    @DisplayName("should validate create recipe request")
//    void should_validate_create_recipe_request() throws Exception{
//        String recipeToCreateAsJson = "{"recipeName": "Toast", "recipeDescription":"Bread", "time":"30", "difficulty":"easy"}";
//
//        mockMvc.perform(
//                post("/api/v1/recipes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(recipeToCreateAsJson)
//        )
//                .andExpect(status().isBadRequest());
//    }
}
