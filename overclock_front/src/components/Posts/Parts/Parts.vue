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
          <div class="icon-box">
            <i class="bi bi-motherboard"></i>
            <h3><a href="">MB</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <!-- <img src="http://cdn.onlinewebfonts.com/svg/img_223797.png"> -->
            <i class="bi bi-cpu"></i>
            <h3><a href="">CPU</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="bi bi-gpu-card"></i>
            <h3><a href="">GPU</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="bi bi-device-hdd"></i>
            <h3><a href="">HDD</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="bi bi-pc-display"></i>
            <h3><a href="">etc</a></h3>
          </div>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->

  <main id="main">



    <router-link to="/partsRegister" class="btn btn-primary"> 글쓰기</router-link>

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
           <router-link to="/partsregister" class="btn btn-primary">글쓰기</router-link>
          <p>GPU</p>
        </div>
        <div class="row">

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
          v-for="(list,i) in state.dtoList" :key="(list,i)"
          >
            <div class="icon-box">
              <div class="icon"><img v-bind:src="state.img[i]" /></div>
              <br><br><br><br><br>
              <h3><a href="" style="width:292px;" >{{list.title}}</a></h3>
              <span><h4>{{list.id}}</h4></span>
              <span><h5>판매가 4,800,000원</h5></span>
              <span><h5>할인가 4,300,000원</h5></span>
            </div>
          </div>



        </div>
      </div>
    </section><!-- End Services Section -->
  </main><!-- End #main -->


</div>
</template>

<script>
import { reactive } from '@vue/reactivity'
import axios from "axios";
export default {
    name:'ToParts',
  setup(){
    const state = reactive({
      upResult: "",
      img: [],
	    dtoList: [],
      end: null,
      next: null,
      page: null,
      pageList: null,
      prev: null,
      size: null,
      start: null,
      totalPage: null,
      partsType: null,
    });
    const url = "/api/partsList";
	  const headers = {
	    "Content-Type": "application/json"
	  };
    axios.post(url, { page:1, type:"", category:"cpu" }, { headers })
    .then(function(res){
		  // console.log(res.data.dtoList[1].partsType == "used");
      console.log(res.data)
      state.dtoList = res.data.dtoList
      state.end =  res.data.end,
      state.next =  res.data.next,
      state.page =  res.data.page,
      state.pageList =  res.data.pageList,
      state.prev =  res.data.prev,
      state.size =  res.data.size,
      state.start =  res.data.start,
      state.totalPage = res.data.totalPage
      showResult(res.data)
    })
    const showResult = async (arr) => {
      const displayUrl = "/display";
      const url = `http://localhost:9090${displayUrl}`;
      let str2 = "";
      for (let i = 0; i < arr.dtoList.length; i++) {
        str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`;
        state.img[i] = str2;
      }
    };
    return {state}
  }


}
</script>

<style>
</style>