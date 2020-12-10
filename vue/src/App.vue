<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'courseinfo' }">Course Info</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'league' }">League Info</router-link>&nbsp;|&nbsp;
    </div>
    <router-view />
  </div>
</template>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Prata&display=swap');
#app {
  font-family: 'Prata', serif;
  color: #386641 ;
  background: rgb(106,153,78);
  background: linear-gradient(180deg, rgba(106,153,78,1) 0%, rgba(167,201,87,1) 35%, rgba(242,232,207,1) 100%);
}
</style>