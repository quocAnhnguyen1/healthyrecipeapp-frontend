package de.htwberlin.webtech.service;

import de.htwberlin.webtech.healthyrecipes.web.api.Recipe;
import de.htwberlin.webtech.healthyrecipes.web.api.RecipeManipulationRequest;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.persistence.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll(){
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long recipeID){
        var recipeEntity = recipeRepository.findById(recipeID);
        return recipeEntity.map(this::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request){
        var recipeEntity = new RecipeEntity(request.getRecipeName(), request.getRecipeDescription(), request.getTime(), request.getDifficulty(), request.getLikes());
        recipeEntity = recipeRepository.save(recipeEntity);
        return transformEntity(recipeEntity);
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
        recipeEntity.setLikes(request.getLikes());
        recipeEntity = recipeRepository.save(recipeEntity);
        return transformEntity(recipeEntity);
    }

    public boolean deleteById(Long recipeID){
        if(!recipeRepository.existsById(recipeID)){
            return false;
        }
        recipeRepository.deleteById(recipeID);
        return true;
    }

    private Recipe transformEntity(RecipeEntity recipeEntity){
        return new Recipe(
                recipeEntity.getRecipeID(),
                recipeEntity.getRecipeName(),
                recipeEntity.getRecipeDescription(),
                recipeEntity.getTime(),
                recipeEntity.getDifficulty(),
                recipeEntity.getLikes()
        );
    }
}
