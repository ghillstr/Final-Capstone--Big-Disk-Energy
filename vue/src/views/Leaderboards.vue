<template>
  <div class="leaderboards">
      <h1>Leaderboards</h1>
    <p>You must be authenticated to see this</p>
      <div class='buttons'>
        <button class="home" @click="$router.push('/')">Home</button>
        <button class='league' @click="$router.push('league')">League Info</button>
        <button class='course-info' @click="$router.push('courseinfo')">Course Info</button>
      </div> 
  </div>
</template>

<script>
export default {
  name: "leaderboards"
};
</script>

<style>

</style>