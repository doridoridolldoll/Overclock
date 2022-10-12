<template>
  <section id="hero" class="d-flex justify-content-center">
    <body class="form-floating">
          <div class="container portfolio-details input-form">
            <div class="row gy-4">
              <div class="col-lg-8">
                <div class="portfolio-details-slider swiper">
                  <div class="swiper-wrapper align-items-center">
                      <div class="icon imgsize"><img v-bind:src="img"/></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="portfolio-info">
                  <h3>상품정보</h3>
                  <PartsDetail2
                    :dtoList="state.dtoList"
                    :partsDetailId="state.partsDetailId"/>
                    <strong>수량</strong>: <input type="number" min="1" max="999" v-model="state.count"><br>
                <button class="btn1 btn btn-primary mt-3"  v-if="(state.role != '1')" @click="add">담기</button>
                <router-link to="/partsModify" v-if="(state.partsDetailMemberId == state.memberId)" class="btn2 btn btn-primary mt-3">수정</router-link>
                </div>

              </div>
            </div>
            <div class="portfolio-description">
                  <h2>제품상세</h2>

                  <p style="font-size: x-large;">
              {{state.dtoList.content}}
                    </p>

                </div>




            <Comment
              :dtoList="state.dtoList"
            />

          </div>
    </body>
  </section>
</template>

<script>
import { useStore } from 'vuex'
import { reactive } from '@vue/reactivity';
import Comment from '@/components/Posts/Comment/Comment.vue';
// import PcPay from '@/components/Pay/PcPay.vue';
  export default {
  components: { Comment },
      name: 'PeriDetail',
      setup(){
        const store = useStore();
        const state = reactive({
          price: '',
          dtoList: '',
          memberId: null,
          postsId: null,
        });
        

        let list = store.state.dtoList;
        console.log(store.state.dtoList);
        state.dtoList = store.state.dtoList;
        state.price =store.state.price;
        // state.postsId = state.dtoList.id
        // console.log(state.postsId);

        // state.memberId = state.dtoList.memberId;
        // console.log(state.memberId);
        const displayUrl = "/display";
        const url = `http://localhost:9090${displayUrl}`;
        let img = "";
        img = `${url}?fileName=${list.imageDTOList[0].imageURL}`;
        // // console.log(list.imageDTOList);
        return {state,img};
    }
}
// import { defineProps } from 'vue '
// let props = defineProps(["partsList", "test"])
// console.log(props.partsList);
// console.log(props.test);
// console.log(props);

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
.col-lg-8{
  max-height: 40vh;
}
p{
  margin-bottom: 1rem;
}
#hero:before{
  height: 2000px;
}
#hero{
    overflow: scroll;
}
.btn1{
  margin-right: 10px;
}
.btn2{
  margin-right: 10px;
}
</style>
