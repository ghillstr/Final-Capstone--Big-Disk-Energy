<template>
  <div class="course-info">
    <h1>Courses</h1>
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