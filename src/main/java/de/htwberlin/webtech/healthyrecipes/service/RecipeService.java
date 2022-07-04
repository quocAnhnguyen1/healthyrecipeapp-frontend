package de.htwberlin.webtech.healthyrecipes.service;

import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import de.htwberlin.webtech.healthyrecipes.web.api.RecipeManipulationRequest;
import de.htwberlin.webtech.healthyrecipes.persistence.RecipeEntity;
import de.htwberlin.webtech.healthyrecipes.persistence.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;


    public RecipeService(RecipeRepository recipeRepository, RecipeTransformer recipeTransformer){
        this.recipeRepository = recipeRepository;

        this.recipeTransformer = recipeTransformer;
    }

    public List<Recipe> findAll(){
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipeTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long recipeID){
        var recipeEntity = recipeRepository.findById(recipeID);
        return recipeEntity.map(recipeTransformer::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request){
        var recipeEntity = new RecipeEntity(request.getRecipeName(), request.getRecipeDescription(), request.getTime(), request.getDifficulty());
        recipeEntity = recipeRepository.save(recipeEntity);
        return recipeTransformer.transformEntity(recipeEntity);
    }

    public Recipe update(Long recipeID, RecipeManipulationRequest request){
        var recipeEntityOptional = recipeRepository.findById(recipeID);
        if(recipeEntityOptional.isEmpty()){
            return null;
        }
        var recipeEntity = recipeEntityOptional.get();
        recipeEntity.setRecipeName(request.getRecipeName());
        recipeEntity.setRecipeDescription(request.getRecipeDescription());
        recipeEntity.setTime(request.getTime());
        recipeEntity.setDifficulty(request.getDifficulty());
        recipeEntity = recipeRepository.save(recipeEntity);
        return recipeTransformer.transformEntity(recipeEntity);
    }

    public boolean deleteById(Long recipeID){
        if(!recipeRepository.existsById(recipeID)){
            return false;
        }
        recipeRepository.deleteById(recipeID);
        return true;
    }
}
