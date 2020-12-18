<template>
  <div class="container">
    <div>
      <h1>Welcome</h1>
    </div>
    <div class="polaroid">
      <img
        src="@/assets/EP-801257102.jpg"
        id="home-basket-image"
        alt="red disc golf basket with grass, palms, and blue sky in background"
      />
    </div>
    <!-- <div class='buttons'>
        <button class="button" @click="$router.push('courseinfo')">COURSE INFO</button>
        <button class="button" @click="$router.push('league')">LEAGUE INFO</button>
        <button class="button" @click="$router.push('leaderboards')">Leaderboards</button> 
      </div>  -->
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style>
.polaroid {
  position: relative;
  text-align: center;
}

.polaroid img {
  border: 10px solid #fff;
  border-bottom: 45px solid #fff;
  -webkit-box-shadow: 0px 0px 10px #777;
  -moz-box-shadow: 0px 0px 10px #777;
  box-shadow: 0px 0px 10px #777;
  -webkit-transform: rotate (3deg);
  -moz-transform: rotate (3deg);
  transform: rotate (3deg);
}

.polaroid p {
  position: absolute;
  text-align: center;
  width: 100%;
  bottom: 0px;
  font: 400 18px/1 "Kaushan Script", cursive;
  color: #888;
  z-index: 99;
}
.button {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  margin: 10px;
  padding-left: 60px;
  padding-right: 60px;
}
.button:hover {
  background-color: #a7c957;
  color: #bc4749;
}
#home-basket-image {
  height: 100%;
  width: 80%;
}
</style>
