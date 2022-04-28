<template>
  <div id="app">
      <router-view/>
  </div>
</template>

<script>
import home from "./components/home";

export default {
  name: 'App',
  components: {
    home
  }
}
</script>

<style>
html,body{
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
}

#app {
  height: 100%;
  width: 100%;

  overflow: auto;
  background: antiquewhite;
}
</style>
