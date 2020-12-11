<template>
  <div class="course-info">
      <h1>Course Info</h1>
      <div class='buttons'>
        <!-- <button class="button" @click="$router.push('/')">HOME</button>
        <button class="button" @click="$router.push('league')">LEAGUE INFO</button>
        <button class="button" @click="$router.push('leaderboards')">LEADERBOARDS</button> -->
      </div> 
      <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d24284.822771877924!2d-80.01945599999999!3d40.4619264!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1607654062474!5m2!1sen!2sus" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe> -->
      
      <google-map/>
  </div>
  
</template>

<script>
import GoogleMap from '@/components/GoogleMap.vue'

export default {
  name: "courseinfo",
  components: {
    GoogleMap,
  },
  
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