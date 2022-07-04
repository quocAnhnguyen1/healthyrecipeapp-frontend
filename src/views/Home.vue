<template>
  <div class="home">
    <div class="text-center">
      <img alt="Recipe logo" src="../assets/healthyFoodHeart.png" class="rounded">
    </div>
    <HelloWorld msg="Hello and welcome to healthy recipes!"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
