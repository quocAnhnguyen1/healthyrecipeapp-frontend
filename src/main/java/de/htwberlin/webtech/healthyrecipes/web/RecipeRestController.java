package de.htwberlin.webtech.healthyrecipes.web;

import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RecipeRestController {

    private List<Recipe> recipes;
    public RecipeRestController(){
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Salmon Pasta", "Easy pasta recipe with salmon and asparagus", 30, "easy", 0));
        recipes.add(new Recipe("Pho", "Traditional pho recipe", 60 , "easy", 0));
    }

    @GetMapping(path = "/api/v1/recipes")
    public ResponseEntity<List<Recipe>> fetchRecipes(){
        return ResponseEntity.ok(recipes);
    }

}
