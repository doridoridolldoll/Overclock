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
          <a href="#services" v-on:click="change('mb')">
          <div class="icon-box">
            <i class="bi bi-motherboard"></i>
            <h3><a href="#services">MB</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services" v-on:click="change('cpu')">
          <div class="icon-box">
            <i class="bi bi-cpu"></i>
            <h3 class="asd"><a href="#services">CPU</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services" v-on:click="change('gpu')">
          <div class="icon-box">
            <i class="bi bi-gpu-card"></i>
            <h3><a href="#services">GPU</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services" v-on:click="change('hdd')">
          <div class="icon-box">
            <i class="bi bi-device-hdd"></i>
            <h3><a href="#services">HDD</a></h3>
          </div>
          </a>
        </div>
        <div class="col-xl-2 col-md-4">
          <a href="#services" v-on:click="change('etc')">
          <div class="icon-box">
            <i class="bi bi-pc-display"></i>
            <h3><a href="#services">etc</a></h3>
          </div>
          </a>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->
  
  
  <div v-if="(state.form == 'mb')">
    <PartsMb/>
  </div>  
  <div v-if="(state.form == 'cpu')">
    <PartsCpu/>
  </div>
  <div v-if="(state.form == 'gpu')">
    <PartsGpu/>
  </div> 
  <div v-if="(state.form == 'hdd')">
    <PartsHdd/>
  </div> 
  <div v-if="(state.form == 'etc')">
    <PartsEtc/>
  </div>
  
</div>
<Contact/>
</template>

<script>
import { reactive } from '@vue/reactivity';
import PartsMb from '@/components/Posts/Parts/PartsMb.vue'
import PartsCpu from '@/components/Posts/Parts/PartsCpu.vue'
import PartsGpu from '@/components/Posts/Parts/PartsGpu.vue'
import PartsHdd from '@/components/Posts/Parts/PartsHdd.vue'
import PartsEtc from '@/components/Posts/Parts/PartsEtc.vue'
import Contact from '@/components/Contact.vue';
export default {
  name:'ToParts',
  components: {
    PartsMb,
    PartsCpu,
    PartsGpu,
    PartsHdd,
    PartsEtc,
    Contact
},
  setup(){
    const state = reactive({
      form: "mb",
    });
    function change(which){
      state.form = which;
    }
    return {state,change}
  }
}
</script>

<style scoped>
  .asd{
    color: white;
  }
  a{
    text-decoration-line: none;
  }
</style>