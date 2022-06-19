<template>
  <h1>Welcome to recipes</h1>
  <div class="d-grid gap-2 col-6 mx-auto">
    <div class="col" v-for="recipe in recipes" :key="recipe.recipeID">
      <button class="btn btn-primary" type="button">{{ recipe.recipeName }}</button>
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Recipes',
  data () {
    return {
      recipes: [
        {
          recipeID: 1,
          recipeName: 'Chickenburger with avocado sauce',
          recipeDescription: 'Simple and healthy Chickenburger',
          time: 30,
          difficulty: 'easy',
          likes: 2
        },
        {
          recipeID: 2,
          recipeName: 'Porridge with fruits',
          recipeDescription: 'Simple and healthy porridge',
          time: 15,
          difficulty: 'easy',
          likes: 1
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
