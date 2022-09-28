<template>
<div>
    <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container" data-aos="fade-up">

      <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
        <div class="col-xl-6 col-lg-8">
          <h1>Powerful Digital Hardware With OverClock<span>.</span></h1>
          <h2>우리는 최고의 상품을 최적의 가격에 판매합니다</h2>
        </div>
      </div>

      <div class="row gy-4 mt-5 justify-content-center" data-aos="zoom-in" data-aos-delay="250">
        <div class="col-xl-2 col-md-4">
          <a href="#services2" v-on:click="change('mouse')">
          <div class="icon-box">
            <i class="bi bi-motherboard"></i>
            <h3><a href="#services2">MOUSE</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services2" v-on:click="change('keyboard')">
          <div class="icon-box">
            <i class="bi bi-cpu"></i>
            <h3 class="asd"><a href="#services2">KEYBOARD</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services2" v-on:click="change('headset')">
          <div class="icon-box">
            <i class="bi bi-gpu-card"></i>
            <h3><a href="#services2">HEADSET</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services2" v-on:click="change('display')">
          <div class="icon-box">
            <i class="bi bi-device-hdd"></i>
            <h3><a href="#services2">DISPLAY</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services2" v-on:click="change('etc')">
          <div class="icon-box">
            <i class="bi bi-pc-display"></i>
            <h3><a href="#services2">etc</a></h3>
          </div>
          </a>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->
  
  
  <div v-if="(state.form == 'mouse')">
    <PeriMouse/>
  </div>  
  <div v-if="(state.form == 'keyboard')">
    <PeriKeyboard/>
  </div>
  <div v-if="(state.form == 'headset')">
    <PeriHeadset/>
  </div> 
  <div v-if="(state.form == 'display')">
    <Peridisplay/>
  </div> 
  <div v-if="(state.form == 'etc')">
    <PeriEtc/>
  </div> 
</div>
<Contact/>
</template>

<script>
import { reactive } from '@vue/reactivity';
import Contact from '@/components/Contact.vue';
import PeriMouse from './PeriMouse.vue';
import PeriKeyboard from './PeriKeyboard.vue';
import PeriHeadset from './PeriHeadset.vue';
import Peridisplay from './Peridisplay.vue';
import PeriEtc from './PeriEtc.vue';
export default {
  name:'ToParts',
  components: {
    Contact,
    PeriMouse,
    PeriKeyboard,
    PeriHeadset,
    Peridisplay,
    PeriEtc
},
  setup(){
    const state = reactive({
      form: "mouse",
    });
    function change(which){
      state.form = which;
      console.log(state.form);
    }
    return {state,change}
  }
}
</script>

<style scoped>
  
</style>