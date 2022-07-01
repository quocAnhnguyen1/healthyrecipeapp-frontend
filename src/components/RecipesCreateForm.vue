<template>
  <button class="btn btn-success sticky-button" data-bs-toggle="offcanvas" data-bs-target="#recipe-create-offcanvas" aria-controls="#recipe-create-offcanvas">
    <i class="bi bi-recipe-plus-fill"></i>
  </button>
  <div class="offcanvas offcanvas-end" tabindex="-1" id="recipe-create-offcanvas" aria-labelledby="offcanvas-label">
    <div class="offcanvas-header">
      <h5 class="offcanvas-label" New recipe></h5>
      <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
      <form class="text-start">
        <div class="mb-3">
          <label for="recipe-name" class="form-label">Recipe name</label>
          <input type="text" class="form-control" id="recipe-name" v-model="recipeName">
        </div>
        <div class="mb-3">
          <label for="recipe-description" class="form-label">Description</label>
          <input type="text" class="form-control" id="recipe-description" v-model="recipeDescription">
        </div>
        <div class="mb-3">
          <label for="recipe-difficulty" class="form-label">Difficulty</label>
          <input type="text" class="form-control" id="recipe-difficulty" v-model="difficulty">
        </div>
        <div class="mb-3">
          <label for="recipe-time" class="form-label">Time</label>
          <input type="text" class="form-control" id="recipe-time" v-model="time">
        </div>
        <div class="mt-5">
          <button class="btn btn-primary me-3" type="submit" @click="createRecipe">Create</button>
          <button class="btn btn-danger" type="reset">Reset</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RecipesCreateForm',
  data () {
    return {
      recipeName: '',
      recipeDescription: '',
      difficulty: '',
      time: ''
    }
  },
  methods: {
    createRecipe () {
      const endpoint = process.env.VUE_APP_BACKEND_BASE_URL + '/api/v1/recipes'

      const headers = new Headers()
      headers.append('Content-Type', 'application/json')

      const payload = JSON.stringify({
        recipeName: this.recipeName,
        recipeDescription: this.recipeDescription,
        time: this.time,
        difficulty: this.difficulty,
        likes: 0
      })

      const requestOptions = {
        method: 'POST',
        headers: headers,
        body: payload,
        redirect: 'follow'
      }

      fetch(endpoint, requestOptions)
        .catch(error => console.log('error', error))
    }
  }
}
</script>

<style scoped>
.sticky-button {
  position: fixed;
  bottom: 20px;
  right: 20px;
  padding: 10px 15px;
  border-radius: 30px;
}

</style>
