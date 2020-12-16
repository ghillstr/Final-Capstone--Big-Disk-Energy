<template>
  <div class="media m-3">
    <img
      class="align-self-center mr-3"
      src="@/assets/Jacob+Frey_Circle.png"
      id="jacob"
      alt="Jacob Frey in a circle with a brick background"
    />
    <div id="jacob-div" class="media-body align-self-center mr-3">
      <p>
        Jacob is the product owner of ©BigDiscEnergy! He was involuntarily
        chosen as our product owner and we strong-armed him into letting us
        choose disc golf.
      </p>
    </div>
  </div>
</template>
<script>
export default {
  name: "Jacob",
};
</script>
<style scoped>
#jacob {
  height: 150px;
  width: 150px;
}
#jacob-div {
  background: white;
  outline: 2px;
  outline-style: ridge;
  outline-color: #386641;
  padding: 5px 0px 5px 0px;
}
</style>