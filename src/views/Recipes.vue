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
      recipes: []
    }
  },
  mounted () {
    const endpoint = process.env.VUE_APP_BACKEND_BASE_URL + '/api/v1/recipes'
    const requestOptions = {
      method: 'GET',
      redirect: 'follow'
    }

    fetch(endpoint, requestOptions)
      .then(response => response.json())
      .then(result => result.forEach(recipe => {
        this.recipes.push(recipe)
      }))
      .catch(error => console.log('error', error))
  }
}
</script>

<style scoped>

</style>
