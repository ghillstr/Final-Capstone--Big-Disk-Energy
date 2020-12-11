<template>
  <div id="app">
    <nav class="navbar sticky-top navbar-expand-sm bg-dark justify-content-center">
      
      <router-link v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'courseinfo' }">COURSE INFO</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'league' }">LEAGUE INFO</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
    
    </nav>
    <router-view />
    <Footer/>
  </div>
  
</template>
<script>
import Footer from './components/Footer.vue'
export default {
  components: {
    Footer,
  }
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#app {
  
  color: white ;
  background: rgb(106,153,78);
  background: linear-gradient(180deg, rgba(106,153,78,1) 0%, rgba(167,201,87,1) 35%, rgba(242,232,207,1) 100%);
  text-align: center;
}

 nav a {
   color: white;
   text-decoration: underline;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  
 }
nav a.router-link-exact-active {
  text-decoration-line: overline;
  text-decoration-color: #A7C957;
  color: #A7C957;
  font-weight: bolder;
}
nav a:hover {
  color: #Bc4749
}
h1 {
font-family: 'Permanent Marker', cursive;  
color: #386641;
text-shadow: -1px -1px 0 #A7C957
, 1px -1px 0 #A7C957, -1px 1px 0 black, 1px 1px 0 black;
}
.account {
  font-size: larger;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-weight: bolder;
  color: #BC4749;
}
.account:hover {
  color: white;
}


</style>