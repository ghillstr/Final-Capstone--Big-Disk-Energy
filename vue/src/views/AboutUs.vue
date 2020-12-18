<template>
  <div class="about">
    <h1>About Us</h1>
    <p>Meet the brains behind ©BigDiscEnergy!</p>

    <jacob />
    <tom />
    <the-bus />
  </div>
</template>

<script>
import TheBus from "@/components/TheBus.vue";
import Jacob from "@/components/Jacob.vue";
import Tom from "@/components/Tom.vue";
export default {
  name: "about-us",
  components: {
    TheBus,
    Jacob,
    Tom,
  },
};
</script>

<style scoped>
.about {
  color: #386641;
}
</style>