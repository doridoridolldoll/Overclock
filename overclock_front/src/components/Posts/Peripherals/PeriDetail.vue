<template>
  <section id="hero" class="d-flex justify-content-center">
    <body class="form-floating">
      <div class="container portfolio-details input-form">
        <div class="row gy-4">
          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper">
              <div class="swiper-wrapper align-items-center">
                <div class="icon imgsize"><img :src="state.img" /></div>
              </div>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>상품정보</h3>
              <PeriDetail2
                v-if="state.dtoList.length != ''"
                :dtoList="state.dtoList"
                :periDetailId="state.periDetailId"
              />
              <strong>수량</strong>:
              <input
                type="number"
                min="1"
                max="999"
                v-model="state.count"
              /><br />
              <button
                class="btn1 btn btn-primary mt-3"
                v-if="state.role != '1'"
                @click="add"
              >
                담기
              </button>
              <router-link
                to="/partsModify"
                v-if="state.partsDetailMemberId == state.memberId"
                class="btn2 btn btn-primary mt-3"
                >수정</router-link
              >
            </div>
          </div>
        </div>
        <div class="portfolio-description">
          <h2>제품상세</h2>
          <p style="font-size: x-large">{{ state.dtoList.content }}</p>
        </div>
        <PeriComment :dtoList="state.dtoList" />
      </div>
    </body>
  </section>
</template>

<script>
import { useStore } from "vuex";
import { reactive } from "@vue/reactivity";
import PeriDetail2 from "@/components/Posts/Peripherals/PeriDetail2.vue";
import PeriComment from "@/components/Posts/Comment/PeriComment.vue";

import axios from "axios";
export default {
  components: { PeriComment, PeriDetail2 },

  name: "PeriDetail",
  setup() {
    const id = new URLSearchParams(window.location.search).get("id");
    const store = useStore();
    const state = reactive({
      regDate: "",
      title: "",
      price: "",
      dtoList: "",
      memberId: store.state.id, //로그인 사용자 Id
      postsId: null,
      partsDetailMemberId: store.state.dtoList.memberId, //글 작성자 Id
      role: "",
      periDetailId: id, //글 Id
      imgName: "",
      imgPath: "",
      imgUuid: "",
      img: ""
    });

    // let list = store.state.dtoList;
    // state.dtoList = store.state.dtoList;
    // state.price = store.state.price;
    // state.imgUrl = store.state.dtoList.imageDTOList[0].thumbnailURL;
    // state.title = state.dtoList.title;
    // state.role = store.state.role;

    const body2 = {
      id: state.periDetailId,
    };
    const headers = {
      "Content-Type": "application/json",
    };

    axios.post("/api/periDetail", body2, { headers }).then(function (res) {
      console.log("==================62929525925259259259=========");
      console.log(res);
      state.dtoList = res.data.articles[0];
      console.log(state.dtoList);
      const displayUrl = "/display";
      const url = `http://localhost:9090${displayUrl}`;
      state.imgName = res.data.articles[0].imgName;
      state.imgPath = res.data.articles[0].imgPath;
      state.imgUuid = res.data.articles[0].imgUuid;
      let str = state.imgPath + "/" +state.imgUuid + "_" + state.imgName;
      state.img = `${url}?fileName=${str}`;
    });
    console.log("==================333333333333=========");
    console.log(state.dtoList);

    function add() {
      const url = "/register/cartAdd";
      const headers = {
        "Content-Type": "application/json",
      };
      const body = {
        memberId: state.memberId,
        cartName: state.title,
        price: state.price * state.count,
        count: state.count,
        imgUrl: state.imgUrl,
      };
      if (state.memberId == 0) {
        alert("로그인 후 사용가능합니다");
        return;
      }
      axios.post(url, body, { headers }).then(function (res) {
        console.log("===========================");
        console.log(res);
        alert("장바구니에 담았습니다 ");
      });
    }
    return { state, add };
  },
};
</script>
<style scoped>
.input-form {
  text-align: center;

  max-width: 900px;

  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

  overflow: hidden;

  word-break: break-all;
}

#hero h2 {
  color: rgb(0, 0, 0);
}

.col-lg-8 {
  max-height: 40vh;
}

p {
  margin-bottom: 1rem;
}

#hero:before {
  height: 2000px;
}

#hero {
  overflow: scroll;
}

.btn1 {
  margin-right: 10px;
}

.btn2 {
  margin-right: 10px;
}
.imgsize {
  width: 300px;
  height: 300px;
}
</style>
