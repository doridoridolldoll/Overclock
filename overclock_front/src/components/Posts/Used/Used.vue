<template>
  <div>
    <section id="hero" class="d-flex align-items-center justify-content-center">
      <div class="container" data-aos="fade-up">
        <div
          class="row justify-content-center"
          data-aos="fade-up"
          data-aos-delay="150"
        >
          <div class="col-xl-6 col-lg-8">
            <h1>Powerful Digital Hardware With OverClock<span>.</span></h1>
            <h2>우리는 최고의 상품을 최적의 가격에 판매합니다</h2>
          </div>
        </div>
      </div>
    </section>
    <!-- End Hero -->

    <router-link to="/UsedRegister" class="btn btn-primary"> 글쓰기</router-link>

    <main id="main">
      <section class="ftco-section ftco-cart">
        <div class="container">
          <div class="row">
            <div class="col-md-12 ftco-animate">
              <div class="cart-list">
                <table class="table">
                  <thead class="thead-primary">
                    <tr class="text-center">
                      <th>글 번호</th>
                      <th>사진</th>
                      <th>제목</th>
                      <th>작성일</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr
                      class="text-center"
                      v-for="(list, i) in state.dtoList"
                      :key="(list, i)"
                    >
                      <td class="price">{{ list.id }}</td>
                      <td>
                        <img v-bind:src="state.img[i]" />
                      </td>

                      <td class="product-name">
                        <h3>
                          <a href="/useddetail">{{ list.title }}</a>
                        </h3>
                      </td>
                      <td class="price">{{ list.regDate }}</td>
                      <td class="price">{{ list.viewCount }}</td>
                    </tr>
                    <!-- END TR-->
                  </tbody>
                </table>
	         </div>
            </div>
          </div>
        </div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" @click="getUserList(state.page-1)" v-if="state.page!=1">Prev</a></li>
				<li :class="state.page == page?'page-item active':'page-item'" v-for="page in state.pageList" :key="page"><a class="page-link" @click="getUserList(page)">{{page}}</a></li>
				<li class="page-item" ><a class="page-link" @click="getUserList(state.page+1)" v-if="state.page!=state.totalPage">Next</a></li>
			</ul>
		</nav>
	</section>
</main>
  </div>
</template>

<script>
// import { onMounted } from "vue";
import { reactive } from "@vue/reactivity";
import axios from "axios";

export default {
  name: "ToUsed",
  setup() {


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
    });
	const url = "/api/getlist";
	const headers = {
	  "Content-Type": "application/json"
	};
	function getUserList(page){
		axios.post(url, { page:page, category:"used" }, { headers })
		.then(function(res){
		console.log(page + "asdasdasd");
		console.log(res);
        state.dtoList =  res.data.dtoList,
        state.end =  res.data.end,
        state.next =  res.data.next,
		    state.page = res.data.page,
        state.pageList =  res.data.pageList,
        state.prev =  res.data.prev,
        state.size =  res.data.size,
        state.start =  res.data.start,
        state.totalPage = res.data.totalPage
    })  
    }
	// var count = 0;
    axios.post(url, { page:1, category:"used" }, { headers })
    .then(function(res){
      console.log(res)
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
    const showResult = async (arr) => {
      const displayUrl = "/display";
      const url = `http://localhost:9090${displayUrl}`;
      let str2 = "";
      for (let i = 0; i < arr.dtoList.length; i++) {
        str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`;
        state.img[i] = str2;
      }
    };

    return { state, getUserList};
  },
};
</script>

<style>
	.pagination{
		object-position: center;
	}
</style>
