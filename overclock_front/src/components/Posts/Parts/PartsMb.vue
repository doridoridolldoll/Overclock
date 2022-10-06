<template>
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
        <router-link to="/partsregister" class="btn btn-primary" v-if="(store.state.role == '2')">글쓰기</router-link>
        <!-- <div v-if="(state.form == 'gpu')"> -->
        <div class="section-title">
          <p>MB</p>
        </div>

        <div class="row">
          <div class="col-lg-4 col-md-6 align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
          v-for="(list,i) in state.dtoList" :key="(list,i)"
          >
            <!-- <router-link :to="{name: 'PartsDetail', query: {name: [...JSON.stringify(list)]}}" @click="Join(list.id)"> -->
            <!-- <a  @click="Join(list,i)"> -->
            <a :href="'./PartsDetail?id=' + list.id" @click="Join(list,i)">
            <div class="icon-box">
              <div class="icon"><img v-bind:src="state.img[i]" /></div>
              <br><br><br><br><br>
              <h3><a href="" style="width:292px;" >{{list.title}}</a></h3>
              <span><h4>{{list.content}}</h4></span>
              <span><h5>{{state.price[i]}}</h5></span>
              <span><h5>할인가 4,300,000원</h5></span>
              <div></div>
            </div>
            </a>
          <!-- </router-link> -->
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
import { useStore } from 'vuex';
export default {
  name: 'PartsMb',
  props: [  ],
  setup(){
    const store = useStore();
  
    const state = reactive({
      id: "",
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
      partsType: "mb",
      price: [],
    });
    const url = "/api/partsList";
	  const headers = {
	    "Content-Type": "application/json; charset=utf-8",
      "Authorization": store.state.token,
      "id": store.state.id
	  };
  function getUserList(page){
    axios.post(url, { page:page, type:"", category:"mb" }, { headers })
    .then(function(res){
		  // console.log(res.data.dtoList[1].partsType == "used");
      console.log(res.data)
      state.id = res.data.dtoList.id,
      state.dtoList = res.data.dtoList,
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
  axios.post(url, { page: 1, category: "mb" }, { headers })
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
    const body = {
      category:"mb"
    }
    axios.post("/api/partsItemList", body, {headers}).then(function(res){
      for (let i = 0; i < res.data.length; i++) {
        state.price[i] = res.data[i].price;
        
      }
        // state.price[i] = res.data;
        console.log(state.price);

    })

    function Join(list,i){
      // console.log(list);
      const body = {
        category:"mb"
      }
      axios.post("/api/partsItemList", body, {headers}).then(function(res){
        // store.state.dtoList = res.data;
        console.log("===========");
        console.log(res.data);
        store.commit("setPrice", ...[res.data[i].price]);
        store.state.price = res.data[i].price;
          // console.log(store.item.price);
      })

      //조회수 처리
      const url2 = `/api/read/${list.id}`;
	    const headers2 = {
	      "Content-Type": "application/json; charset=utf-8"
	    };
      
      axios.get(url2, {page: 1, category: "mb" }, { headers2 }).then(function(res){
        store.state.dtoList = res.data;
        // store.b.dto = res.data;
        // store.state.posts.d.dto = res.data;
        store.commit('setdtoList',...[res.data]);
        console.log("asdasd");
        console.log(store.state.dtoList);
        // console.log(store.b.dto);
      })
    }
    return {state, store, getUserList,Join}
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