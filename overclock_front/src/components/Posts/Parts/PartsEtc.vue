<template>
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
        <router-link to="/partsregister" class="btn btn-primary">글쓰기</router-link>
        <div class="section-title">
          <p>ETC</p>
        </div>
        <div class="row">
          <div class="col-lg-4 col-md-6  align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
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
          <div class="page">
            <ul class="pagination">
              <li class="page-item"><a class="page-link" @click="getUserList(state.page-1)" v-if="state.page!=1">Prev</a></li>
              <li :class="state.page == page?'page-item active':'page-item'" v-for="page in state.pageList" :key="page"><a class="page-link" @click="getUserList(page)">{{page}}</a></li>
              <li class="page-item" ><a class="page-link" @click="getUserList(state.page+1)" v-if="state.page!=state.totalPage">Next</a></li>
            </ul>
          </div>

        </div>
      </div>
    </section><!-- End Services Section -->
</template>

<script>
import { reactive } from '@vue/reactivity';
import axios from "axios";
export default {
  name: 'PartsEtc',
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
      partsType: "etc",
    });
    const url = "/api/partsList";
	  const headers = {
	    "Content-Type": "application/json"
	  };
    function getUserList(page){
    axios.post(url, { page:page, type:"", category:"etc" }, { headers })
    .then(function(res){
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
  }
  axios.post(url, { page: 1, category: "etc" }, { headers })
            .then(function (res) {
            console.log(res);
            state.dtoList = res.data.dtoList,
                state.end = res.data.end,
                state.next = res.data.next,
                state.page = res.data.page,
                state.pageList = res.data.pageList,
                state.prev = res.data.prev,
                state.size = res.data.size,
                state.start = res.data.start,
                state.totalPage = res.data.totalPage;
            showResult(res.data);
        });
    const showResult = async (arr) => {
      const displayUrl = "/display";
      const url = `http://localhost:9090${displayUrl}`;
      let str2 = "";
      for (let i = 0; i < arr.dtoList.length; i++) {
        str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`;
        state.img[i] = str2;
      }
    };
    return {state,getUserList}
  
  }
}
</script>

<style scoped>
	.pagination{
		width: 100px;
		margin: auto;
	}
  .page{
    margin-top: 30px;
  }
</style>