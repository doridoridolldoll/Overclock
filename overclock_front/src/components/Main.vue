<template>
    <header id="header" class="fixed-top ">
      <div class="container d-flex align-items-center justify-content-lg-between">   
      </div>
    </header>
  <section id="hero" class="d-flex align-items-center justify-content-center">
      <div class="container" data-aos="fade-up">
  
        <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
          <div class="col-xl-6 col-lg-8">
            <h1>Powerful Digital Hardware With OverClock<span>.</span></h1>
            <h2>우리는 최고의 상품을 최적의 가격에 판매합니다</h2>
          </div>
        </div>
      </div>
    </section>
    <router-view/>

  </template>
  
  <script>
import { ref } from '@vue/reactivity'
export default {
    name:'ToMain',
  setup(){
    const title = ref('Main')

    return {title}
  }


}
  
  </script>
  
  <style>
  @import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css");
  </style>
  