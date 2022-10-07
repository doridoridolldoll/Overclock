<template>
  <section id="hero" class="d-flex justify-content-center">
    <div class="container portfolio-details input-form ">
      <div class="row gy-4">
        <table class="table">
          <thead class="thead-primary">
            <tr class="text-center">
              <th>번호</th>
              <th>상품사진</th>
              <th>상품명</th>
              <th>가격</th>
              <th>작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(list,i) in state.dtoList" :key="(list,i)">
              <td><input type="checkbox" class="ch" />{{list.id}}</td>
              <td>
                <img v-bind:src="state.imgUrl[i]"/>
              </td>
              <td><h3>{{list.cartName}}</h3></td>
              <td>{{list.price}}</td>
              <td>작성일</td>
            </tr>
          
          </tbody>
        </table>
      </div>
    </div>
    <div style="text-align: center;">
    <div class="fixed-bottom " style="margin: 0 auto; background-color:white; width:1000px; position : absolute; vertical-align: middle;">
      <h2 class="mt-3" style=" float: left; width: 33%;  font-size: 30px;  font-weight: 600;">총 금액:</h2>
      <button class="btn btn-danger mt-3 me-3" style=" float: right;">삭제</button>
      <button class="btn btn-primary mt-3 me-2 mb-3" style=" float: right; ">구매</button>
    </div>
</div>
  </section>
</template>

<script>
import { reactive } from '@vue/reactivity';
import store from '@/store';
import axios from 'axios';
// import axios from 'axios';
export default {
  name: "ToCart",
  setup() {
  const id = new URLSearchParams(window.location.search).get("id")
   const state = reactive({
      id: "",
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
      price: [],
      memberId: id,
      imgUrl:[],
   })


  const url = "/api/cartList";
  const headers = {
    "Content-Type": "application/json; charset=utf-8",
    "Authorization": store.state.token,
    "id": store.state.id
  };
  const body = {
    memberId: state.memberId
  }
  axios.post(url, body, { headers }).then(function (res) {
    console.log("===========");
    console.log(res);
    state.dtoList = res.data.dtoList,
    state.end = res.data  .end,
    state.next = res.data.next,
    state.page = res.data.page,
    state.pageList = res.data.pageList,
    state.prev = res.data.prev,
    state.size = res.data.size,
    state.start = res.data.start,
    state.totalPage = res.data.totalPage;

    const displayUrl = "/display";
    const url2 = `http://localhost:9090${displayUrl}`;
    for (let i = 0; i < res.data.dtoList.length; i++) {
      state.imgUrl[i] =`${url2}?fileName=${res.data.dtoList[i].imgUrl}`;
    }
    console.log(state.imgUrl);


  });
   return {state}
  }
  }

</script>

<style scoped>

.input-form {
  margin-top: 50px;

  text-align: center;

  max-width: 1000px;

  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

  overflow: scroll;

  word-break: break-all;
}

/* .input-form {
background: #fff;
overflow: scroll;
} */

#hero:before{
  height: 2000px;
}
#hero{
  /* overflow: scroll; */
}
#hero h2 {
  color: black;
}
.ch {
  float: left;
}
.btn-danger {
  margin-right: 10px;
}

</style>
