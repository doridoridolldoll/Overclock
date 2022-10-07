<template>
  <section id="hero" class="d-flex justify-content-center">
<div style="background: red">
    <Countdown deadline="October 06, 2022"></Countdown>
</div>
  </section>
</template>

<script>
import Countdown from 'vuejs-countdown'

export default {
    name:'ToAuction',
    components: { Countdown }
}
</script>

<style scoped>

</style>
