<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
      <div class='buttons'>
        <button class="course-info" @click="$router.push('courseinfo')">Course Info</button>
        <button class='league' @click="$router.push('league')">League Info</button>
        <!-- <button class='leaderboard' @click="$router.push('leaderboards')">Leaderboards</button>  -->
      </div> 
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style>
.home {
  text-align: center;
}
.buttons {
  justify-content: space-around;
  padding: 10px;
  

}
</style>
