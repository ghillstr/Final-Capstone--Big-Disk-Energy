<template>
  <div class="league">
      <h1>League Info</h1>
    <p>You must be authenticated to see this</p>
      <div class='buttons'>
        <button class="home" @click="$router.push('/')">Home</button>
        <button class="course-info" @click="$router.push('courseinfo')">Course Info</button>
        <button class="leaderboard" @click="$router.push('leaderboards')">Leaderboard</button>
      </div> 
  </div>
</template>

<script>
export default {
  name: "league"
};
</script>

<style>

</style>