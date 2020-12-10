<template>
  <div class="league">
      <h1>League Info</h1>
      <!-- <div class='buttons'>
        <button class="button" @click="$router.push('/')">HOME</button>
        <button class="button" @click="$router.push('courseinfo')">COURSE INFO</button>
        <button class="button" @click="$router.push('leaderboards')">LEADERBOARD</button>
      </div>  -->
  </div>
</template>

<script>
export default {
  name: "league"
};
</script>

<style>
.button {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  margin: 10px;
  
}
.button:hover {
  background-color: #A7C957;
  color: #BC4749
}
</style>