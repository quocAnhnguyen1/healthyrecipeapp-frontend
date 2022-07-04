<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p class="text-center mt-5">Let's eat healthier together!</p>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
