<template>
  <div class="media m-3">
    <img
      class="align-self-center mr-3 rounded-circle"
      src="@/assets/tom-a.png"
      id="tom"
      alt="Tom A with flowing locks"
    />
    <div id="tom-div" class="media-body align-self-center mr-3">
      <p>
        Tom is the scrum master of ©Big Disc Energy! He yells at us all the time
        and tells us we are doing a terrible job, so that we work harder!
      </p>
    </div>
  </div>
</template>
<script>
export default {
  name: "Tom",
};
</script>
<style scoped>
#tom {
  height: 150px;
  width: 150px;
}
#tom-div {
  background: white;
  outline: 2px;
  outline-style: ridge;
  outline-color: #386641;
  padding: 3px;
}
</style>