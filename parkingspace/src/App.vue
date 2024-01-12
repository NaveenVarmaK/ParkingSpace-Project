<template>
  <div id="app">
    <header>
      <div class="title" style="font-family: 'Courier New', Courier, monospace; color: white;">
        <h1>Parking Space</h1>
      </div>
    </header>
    <section class="main-content w-50 mx-auto">
      <MainNavigation />  
    </section>
  </div>
  <!-- <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/> -->
</template>

<script>
// import ParkingLocations from './components/ParkingLocations.vue'
import MainNavigation from './components/MainNavigation.vue'
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    // ParkingLocations,
    MainNavigation,
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color:  #5c6ac4;
  padding-top: 40px;
}
.main-content{
  text-align: center;
  margin-top: 40px;
}
</style>
