<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
      <div class='buttons'>
        <button class="course-info">Course Info</button>
        <button class='league-info'>League Info</button>
        <button class='leaderboard'>Leaderboard</button>
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
