<template>
  <div class="leaderboards">
      <h1>Leaderboards</h1>
      <!-- <div class='buttons'>
        <button class="button" @click="$router.push('/')">Home</button>
        <button class="button" @click="$router.push('league')">League Info</button>
        <button class="button" @click="$router.push('courseinfo')">Course Info</button>
      </div>  -->
  </div>
</template>

<script>
export default {
  name: "leaderboards"
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