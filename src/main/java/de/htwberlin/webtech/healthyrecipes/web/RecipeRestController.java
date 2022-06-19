package de.htwberlin.webtech.healthyrecipes.web;

import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import de.htwberlin.webtech.healthyrecipes.web.api.RecipeManipulationRequest;
import de.htwberlin.webtech.healthyrecipes.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/api/v1/recipes")
    public ResponseEntity<List<Recipe>> fetchRecipes(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping(path ="/api/v1/recipes/{recipeID}")
    public ResponseEntity<Recipe> fetchRecipeByID(@PathVariable Long recipeID){
        var recipe = recipeService.findById(recipeID);
        return recipe != null? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/recipes")
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeManipulationRequest request) throws URISyntaxException {
        var recipe = recipeService.create(request);
        URI uri = new URI("/api/v1/recipes/" + recipe.getRecipeID());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path="/api/v1/recipes/{recipeID}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long recipeID, @RequestBody RecipeManipulationRequest request){
        var recipe = recipeService.update(recipeID, request);
        return recipe != null? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path="/api/v1/recipes/{recipeID}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long recipeID){
        boolean successful = recipeService.deleteById(recipeID);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
