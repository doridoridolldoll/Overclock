<template>
    <section id="services2" class="services">
<<<<<<< Updated upstream
      <div class="container" data-aos="fade-up">
        <router-link to="/periregister" class="btn btn-primary">글쓰기</router-link>
        <div class="section-title">
          <p>DISPLAY</p>
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

=======
        <div class="container" data-aos="fade-up">
            <router-link to="/periregister" class="btn btn-primary" style="float:right;"
                         v-if="(store.state.role == '1')">글쓰기
            </router-link>
            <div>
                <form class="searching-area d-flex align-items-center gap-1 w-50 mt-3"
                      @submit.prevent="searchingAxios()">
                    <label for="searching"><i class="bi bi-search btn btn-primary"></i></label>
                    <input id="searching" v-model="search.context" type="text" class="form-control bg-white"
                           @submit="searchingAxios()">
                </form>
            </div>
            <div class="section-title">
                <p>DISPLAY</p>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6  align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
                     v-for="(list,i) in state.dtoList" :key="(list,i)"
                >

                    <div class="icon-box" @click="Join(list,i)">
                        <div class="icon"><img v-bind:src="state.img[i]"/></div>

                        <br><br>
                        <h3>{{ list.title }}</h3>
                        <span>{{ list.content }}</span>

                        <span><h5>판매가: {{ state.price[i] }}</h5></span>
                    </div>
                </div>

                <div class="page">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" @click="getUserList(state.page-1)"
                                                 v-if="state.page!=1">Prev</a></li>
                        <li :class="state.page == page?'page-item active':'page-item'" v-for="page in state.pageList"
                            :key="page"><a class="page-link" @click="getUserList(page)">{{ page }}</a></li>
                        <li class="page-item"><a class="page-link" @click="getUserList(state.page+1)"
                                                 v-if="state.page!=state.totalPage">Next</a></li>
                    </ul>
                </div>

            </div>
>>>>>>> Stashed changes
        </div>
    </section><!-- End Services Section -->
</template>

<script>
<<<<<<< Updated upstream
import { reactive } from '@vue/reactivity';
=======
import {reactive} from '@vue/reactivity';
import {useStore} from 'vuex';
import {useRouter} from "vue-router";
import {useMeta} from "vue-meta";
>>>>>>> Stashed changes
import axios from "axios";
export default {
<<<<<<< Updated upstream
  name: 'PeriDisplay',
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
	    "Content-Type": "application/json"
	  };
    function getUserList(page){
    axios.post(url, { page:page, type:"", category:"display" }, { headers })
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
  }
  axios.post(url, { page: 1, category: "cpu" }, { headers })
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
=======
    name: 'PeriDisplay',
    setup() {
        const store = useStore();
        const router = useRouter()

        let search = reactive({
            context: "",
        })
        const {meta} = useMeta({
            title: ':: OverClock',
        })

        function searchingAxios() {
            if (search.context.trim().length == 0) {
                return
            }

            async function routing() {
                await router.push(`/search?cards=${search.context}&postsType=${state.partsType}`);
            }

            routing();
        }

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
            partsType: "display",
            price: [],
            itemDetail: "",

        });
        const url = "/api/periList";
        const headers = {

            "Content-Type": "application/json; charset=utf-8"

        };

        function getUserList(page) {
            axios.post(url, {page: page, type: "", category: "display"}, {headers})
                .then(function (res) {
                    // console.log(res.data.dtoList[1].partsType == "used");
                    console.log(res.data)
                    state.dtoList = res.data.dtoList
                    state.end = res.data.end,
                        state.next = res.data.next,
                        state.page = res.data.page,
                        state.pageList = res.data.pageList,
                        state.prev = res.data.prev,
                        state.size = res.data.size,
                        state.start = res.data.start,
                        state.totalPage = res.data.totalPage
                    showResult(res.data)
                })
        }

        axios.post(url, {page: 1, category: "display"}, {headers})
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
                for (let i = 0; i < state.dtoList.length; i++) {
                    console.log(search.context);
                    if (search.context == state.dtoList[i].title) {
                        store.state.img[i] = state.dtoList[i].imageDTOList[0]
                        console.log(i + "번쨰");
                        console.log(store.state.img[i]);
                    }
                }
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
            category: "display"
        }

        axios.post("/api/partsItemList", body, {headers}).then(function (res) {

            for (let i = 0; i < res.data.length; i++) {
                state.price[i] = res.data[i].price;
                state.itemDetail = res.data[i].itemDetail;
            }

        })

        async function Join(list, i) {
            store.commit('setdtoList', ...[list]);
            store.commit("setPrice", ...[state.price[i]]);

            //조회수 처리
            const url2 = `/api/read/${list.id}`;
            const headers2 = {
                "Content-Type": "application/json; charset=utf-8"
            };

            axios.get(url2, {page: 1, category: "display"}, {headers2}).then(function () {

            })
            await router.push(`/peridetail?id=${list.id}`)
        }

        return {state, store, getUserList, Join, searchingAxios, meta, search}
    }
>>>>>>> Stashed changes
}
</script>

<style scoped>
<<<<<<< Updated upstream
	.pagination{
		width: 100px;
		margin: auto;
	}
  .page{
    margin-top: 30px;
  }
=======
.pagination {
    width: 100px;
    margin: auto;
}

.page {
    margin-top: 30px;
}

a {
    text-decoration-line: none;
}

.services .icon-box {
    border: 1px solid rgb(102, 102, 102);
    border-radius: 10px;
}

#searching {
    border: 1px solid black;
}
>>>>>>> Stashed changes
</style>