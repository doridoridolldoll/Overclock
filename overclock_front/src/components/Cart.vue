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
              <th>작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
            </tr>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
            </tr>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
            </tr>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
            </tr>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
            </tr>
            <tr>
              <td><input type="checkbox" class="ch" /> aa</td>
              <td>aa</td>
              <td><h3>aa</h3></td>
              <td>aa</td>
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
// import { reactive } from '@vue/reactivity';
// import axios from 'axios';
export default {
  name: "ToCart",
  setup() {
    //     const state = reactive({
    //     end: null,
    //     next: null,
    //     page: null,
    //     pageList: null,
    //     prev: null,
    //     size: null,
    //     start: null,
    //     totalPage: null,
    //     partsType: "cart",
    //   });
    //   const url = "/api/getlist";
    //    const headers = {
    //     "Content-Type": "application/json"
    //    };
    // function getUserList(page){
    //   axios.post(url, { page:page, type:"", category:"cart" }, { headers })
    //   .then(function(res){
    //     state.id = res.data.dtoList.id,
    //     state.dtoList = res.data.dtoList,
    //     state.end =  res.data.end,
    //     state.next =  res.data.next,
    //     state.page =  res.data.page,
    //     state.pageList =  res.data.pageList,
    //     state.prev =  res.data.prev,
    //     state.size =  res.data.size,
    //     state.start =  res.data.start,
    //     state.totalPage = res.data.totalPage
    //     showResult(res.data)
    //   })
    // }
    // axios.post(url, { page: 1, category: "cart" }, { headers })
    //           .then(function (res) {
    //           console.log(res);
    //           state.dtoList = res.data.dtoList,
    //               state.end = res.data.end,
    //               state.next = res.data.next,
    //               state.page = res.data.page,
    //               state.pageList = res.data.pageList,
    //               state.prev = res.data.prev,
    //               state.size = res.data.size,
    //               state.start = res.data.start,
    //               state.totalPage = res.data.totalPage;
    //           showResult(res.data);
    //       });
    //   const showResult = async (arr) => {
    //     const displayUrl = "/display";
    //     const url = `http://localhost:9090${displayUrl}`;
    //     let str2 = "";
    //     for (let i = 0; i < arr.dtoList.length; i++) {
    //       str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[i].thumbnailURL}`;
    //       state.img[i] = str2;
    //     }
    //   };
    //   return{getUserList}
  },
};
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
