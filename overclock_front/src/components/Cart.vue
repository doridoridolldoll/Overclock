<template>
  <section id="hero" class="d-flex justify-content-center">
    <div class="container portfolio-details input-form">
      <div class="row gy-4">
        <table class="table">
          <thead class="thead-primary">
            <tr class="text-center">
              <th>번호</th>
              <th>상품사진</th>
              <th>상품명</th>
              <th>수량</th>
              <th>가격</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(list, i) in state.dtoList" :key="(list, i)">
              <td>
                <input type="checkbox" class="ch" id="ch" @click="checked(list,i)" />{{list.id}}
              </td>
              <td>
                <img v-bind:src="state.imgUrl[i]" />
              </td>
              <td>
                <h3>{{ list.cartName }}</h3>
              </td>
              <td>{{ list.count }}</td>
              <td>{{ list.price }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div style="text-align: center">
      <div
        class="fixed-bottom"
        style="
          margin: 0 auto;
          background-color: white;
          width: 1000px;
          position: absolute;
          vertical-align: middle;
        "
      >
        <h2 class="mt-3" style="float: left; width: 33%; font-size: 30px; font-weight: 600">
          총 금액: {{ state.totalPrice }} 원
        </h2>
        <h2 class="mt-3" style="float: left; width: 33%; font-size: 30px; font-weight: 600">
          선택한 금액: {{ state.checkPrice }} 원
        </h2>
        <button
          class="btn btn-danger mt-3 me-3"
          style="float: right"
          @click="cartDelete"
        >
          삭제
        </button>
        <div class="portfolio-info">
          <!-- 강제 딜레이 설정 -->
          <PcPay
            :price="state.checkPrice"
            :cartId="state.cartId"
            :checkList="state.checkList">
          </PcPay>
        </div>
        <!-- <button class="btn btn-primary mt-3 me-2 mb-3" style=" float: right; ">구매</button> -->
      </div>
    </div>
  </section>
</template>

<script>
import { reactive } from '@vue/reactivity';
import store from '@/store';
import axios from 'axios';
import PcPay from '@/components/Pay/PcPay.vue';
// import axios from 'axios';
export default {
  name: "ToCart",
  components: { PcPay},
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
      totalPrice : 0,
      cartId : [],
      checkPrice: 0,
      checkList : [],
   })


console.log(state.cartId);
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
    console.log(res.data);
    for (let i = 0; i < res.data.dtoList.length; i++) {
      state.totalPrice += res.data.dtoList[i].price;
    }
    state.dtoList = res.data.dtoList,
    console.log(state.dtoList);
    state.end = res.data.end,
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

    for (let i = 0; i < state.dtoList.length; i++) {
      state.cartId[i] = 0;
      // state.checkList[i] = "";
    }
    // console.log(state.imgUrl);

  });

  function checked(list,i) {
      
    if(state.cartId[i] != list.id){
      state.cartId[i] = list.id
      state.checkPrice += list.price
      state.checkList[i] = list;
      console.log(state.checkList);
    }
    else{
      state.cartId[i] = 0 
      state.checkPrice -= list.price
      state.checkList[i] = ""
      console.log(state.checkList);
    }
  }

  function cartDelete(){
    const url = "/api/cart/delete"
    // const body = {
    //   cartId: state.cartId
    // }
    console.log(body);
    axios.post(url, state.cartId, { headers }).then(function (res) {
      alert("해당 제품이 장바구니에서 삭제 되었습니다.")
      console.log(res);
    })
  }
   return {state, checked,cartDelete}
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

#hero:before {
  height: 2000px;
}
#hero {
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
