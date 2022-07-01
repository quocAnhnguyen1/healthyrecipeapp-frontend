<template>
  <div class="btn-group" role="group">
    <div class="col" v-for="recipe in recipes" :key="recipe.recipID">
      <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
        {{recipe.recipeName}}
      </button>
      <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
        <li><a class="dropdown-item" href="#"></a></li>
          <p class="text-center">Difficulty:{{recipe.difficulty}}</p>
          <p class="text-center">Time:{{recipe.time}} min.</p>
          <p class="text-center">{{recipe.recipeDescription}}</p>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RecipesList',
  props: {
    recipes: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>

</style>
