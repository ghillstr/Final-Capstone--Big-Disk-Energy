<template>
  <div class="container-fluid">
    <h1>Big Disc Energy</h1>
    <img src="@/assets/EP-801257102.jpg" id="home-basket-image" alt="red disc golf basket with grass, palms, and blue sky in background">
      <!-- <div class='buttons'>
        <button class="button" @click="$router.push('courseinfo')">COURSE INFO</button>
        <button class="button" @click="$router.push('league')">LEAGUE INFO</button>
        <button class="button" @click="$router.push('leaderboards')">Leaderboards</button> 
      </div>  -->
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style>
.button {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  margin: 10px;
  padding-left: 60px;
  padding-right: 60px;
  
}
.button:hover {
  background-color: #A7C957;
  color: #BC4749
}
#home-basket-image {
  height: 100%;
  width: 100%;
  object-fit: cover;
}
</style>
