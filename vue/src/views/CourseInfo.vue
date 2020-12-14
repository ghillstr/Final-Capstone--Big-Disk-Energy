<template>
  <div class="course-info">
    <h1>Courses</h1>
    <div class="buttons">
      <!-- <button class="button" @click="$router.push('/')">HOME</button>
        <button class="button" @click="$router.push('league')">LEAGUE INFO</button>
        <button class="button" @click="$router.push('leaderboards')">LEADERBOARDS</button> -->
    </div>

    <google-map />
  </div>
</template>

<script>
import GoogleMap from "@/components/GoogleMap.vue";

export default {
  name: "courseinfo",
  components: {
    GoogleMap,
  },
};
</script>

<style>
</style>