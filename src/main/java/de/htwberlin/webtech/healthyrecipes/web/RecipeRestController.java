package de.htwberlin.webtech.healthyrecipes.web;

import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import de.htwberlin.webtech.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RecipeRestController {

    private List<Recipe> recipes;

    public RecipeRestController(){
        recipes = new ArrayList<>();
        recipes.add(new Recipe(2, "test1", "testD", 60, "easy", 5));
        recipes.add(new Recipe(3, "test2", "testD", 60, "easy", 5));
    }
    @GetMapping(path = "/api/v1/recipes")
    public ResponseEntity<List<Recipe>> fetchRecipes(){
        return ResponseEntity.ok(recipes);
    }

}
