<template>
  <section class="ftco-section ftco-cart">
    <div class="container">
      <div class="row">
        <div class="col-md-12 ftco-animate">
          <div class="cart-list">
            <table class="table">
              <thead class="thead-primary">
                <tr class="text-center iii">
                  <th>Id Number</th>
                  <th>Email</th>
                  <th>Name</th>
                  <th>Nickname</th>
                </tr>
              </thead>
              <tbody>
                <tr
                  class="text-center"
                  v-for="(list, i) in state.dtoList"
                  :key="(list, i)"
                >
                  <td class="price">{{ list.id }}</td>
                  <td class="price">{{ list.email }}</td>
                  <td class="price">{{ list.name }}</td>
                  <td class="price">{{ list.nickname }}</td>
                </tr>
                <!-- END TR-->
              </tbody>
            </table>
          </div>
        </div>
        <div class="page">
          <ul class="pagination">
            <li class="page-item">
              <a
                class="page-link"
                @click="getUserList(state.page - 1)"
                v-if="state.page != 1"
                >Prev</a
              >
            </li>
            <li
              :class="state.page == page ? 'page-item active' : 'page-item'"
              v-for="page in state.pageList"
              :key="page"
            >
              <a class="page-link" @click="getUserList(page)">{{ page }}</a>
            </li>
            <li class="page-item">
              <a
                class="page-link"
                @click="getUserList(state.page + 1)"
                v-if="state.page != state.totalPage"
                >Next</a
              >
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import { useMeta } from "vue-meta";
import { useStore } from "vuex";
export default {
  name: "ToUsed",
  setup() {
    const store = useStore();
    const { meta } = useMeta({
      title: ":: OverClock",
    });
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
      memberId: "",
      email: "",
      name: "",
      nickname: ""
    });

    const url = "api/getlist";
    const headers = {
      "Content-Type": "application/json; charset=utf-8",
      Authorization: store.state.token,
      id: store.state.id,
    };
    function getUserList(page) {
      axios.post(url, { page: page }, { headers }).then(function (res) {
        // console.log(page + "asdasdasd");
        // console.log(res);
        // (state.dtoList = res.data.dtoList),
          (state.end = res.data.end),
          (state.next = res.data.next),
          (state.page = res.data.page),
          (state.pageList = res.data.pageList),
          (state.prev = res.data.prev),
          (state.size = res.data.size),
          (state.start = res.data.start),
          (state.totalPage = res.data.totalPage);
      });
    }
    const url2 = "api/adminMem";
    const headers2 = {
      "Content-Type": "application/json; charset=utf-8",
    };
    axios.post(url2, { headers2 }).then(function (res) {
      console.log(res);
      state.dtoList = res.data.members
    });

    // axios
    //   .post(url, { page: 1, category: "used" }, { headers })
    //   .then(function (res) {
    //     console.log(res);
    //     (state.dtoList = res.data.dtoList),
    //       (state.end = res.data.end),
    //       (state.next = res.data.next),
    //       (state.page = res.data.page),
    //       (state.pageList = res.data.pageList),
    //       (state.prev = res.data.prev),
    //       (state.size = res.data.size),
    //       (state.start = res.data.start),
    //       (state.totalPage = res.data.totalPage);
    //     showResult(res.data);
    //   });

    // const showResult = async (arr) => {
    //   const displayUrl = "/display";
    //   const url = `http://localhost:9090${displayUrl}`;
    //   let str2 = "";
    //   for (let i = 0; i < arr.dtoList.length; i++) {
    //     str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`;
    //     state.img[i] = str2;
    //   }
    // };
    // const body = {
    //   category: "used",
    // };

    // axios.post("/api/partsItemList", body, { headers }).then(function (res) {
    //   store.state.price = res.data[0].price;
    // });

    // function Join(list, i) {
    //   store.commit("setdtoList", ...[list]);
    //   store.commit("setPrice", ...[state.price[i]]);

    //   //조회수 처리
    //   const url2 = `/api/read/${list.id}`;
    //   const headers2 = {
    //     "Content-Type": "application/json; charset=utf-8",
    //   };

    //   axios
    //     .get(url2, { page: 1, category: "used" }, { headers2 })
    //     .then(function () {});
    // }

    return { state, getUserList, meta };
  },
};
</script>

<style scoped>
.btn-primary {
  float: right;
}
.pagination {
  width: 100px;
  margin: auto;
}
.table tbody tr td {
  padding: 10px;
}
.text-center a {
  display: block;
  text-decoration-line: none;
  width: 100%;
  height: 100%;
}
.text-center a:hover {
  background-color: #a0d4ff;
}
.product-name {
  width: 100%;
  line-height: 2.5em;
}

#hero:before {
  height: 500px;
}
#hero {
  height: inherit;
}
</style>
