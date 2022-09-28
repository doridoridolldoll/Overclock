<template>
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
        <router-link to="/partsregister" class="btn btn-primary">글쓰기</router-link>
        <div class="section-title">
          <p>Mb</p>
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
</template>

<script>
import { reactive } from '@vue/reactivity';
import axios from "axios";
import store from "@/store";
export default {
  name: 'PartsMb',
  props: [  ],
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
	    "Content-Type": "application/json; charset=utf-8",
      "Authorization": store.state.token,
      "id": store.state.id
	  };
    axios.post(url, { page:1, type:"", category:"mb" }, { headers })
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
    console.log(store.state.token)
    return {state, store}
  
  }
}
</script>

<style>

</style>