<template>
  <h1>Welcome to recipes</h1>
  <div class="container-fluid">
    <recipes-list :recipes="this.recipes"></recipes-list>
  </div>
  <recipes-create-form></recipes-create-form>
</template>

<script>
import RecipesList from '@/components/RecipesList'
import RecipesCreateForm from '@/components/RecipesCreateForm'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Recipes',
  components: {
    RecipesCreateForm,
    RecipesList
  },
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
