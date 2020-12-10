<template>
  <div class="course-info">
      <h1>Course Info</h1>
    <p>You must be authenticated to see this</p>
      <div class='buttons'>
        <button class="home" @click="$router.push('/')">Home</button>
        <button class='league' @click="$router.push('league')">League Info</button>
        <button class='leaderboards' @click="$router.push('leaderboards')">Leaderboards</button>
      </div> 
  </div>
</template>

<script>
export default {
  name: "courseinfo"
};
</script>

<style>

</style>