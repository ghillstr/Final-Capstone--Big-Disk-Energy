<template>
  <div class="about">
    <h1>About Us</h1>
    <p>Meet the brains behind ©Big Disc Energy!</p>

    <jacob />
    <tom />
  </div>
</template>

<script>
import Jacob from "@/components/Jacob.vue";
import Tom from "@/components/Tom.vue";
export default {
  name: "about-us",
  components: {
    Jacob,
    Tom,
  },
};
</script>

<style>
</style>