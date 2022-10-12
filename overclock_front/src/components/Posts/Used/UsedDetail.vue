<template>

  <section id="hero" class="d-flex justify-content-center ">
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
                <div class="portfolio-info" >
                  <h3>상품정보</h3>
                  <UsedDetail2
                    :dtoList="state.dtoList"
                    :postsDetailId="state.postsDetailId"
                  />
                </div>
                <div class="portfolio-info">
                  <ul>
                    <li><strong>수량</strong>: <input type="number" value="1" min="1" max="999"></li>


                  </ul>
                </div>
              </div>
            </div>
            <div class="portfolio-description">
                  <h2>거래정보</h2>
                  <p style="font-size: x-large;">
                    {{state.dtoList.content}}
                    </p>
                </div>

                
                <router-link to="/partsModify" class="btn2 btn btn-primary"
                  v-if="(state.usedDetailMemberId == state.memberId)">수정</router-link>

                <UsedComment
              :dtoList="state.dtoList"
            />
          </div>
    </body>
  </section>
</template>

<script>
import { reactive } from '@vue/reactivity';
import { useStore } from 'vuex'
import UsedComment from '../Comment/UsedComment.vue';
import UsedDetail2 from '@/components/Posts/Used/UsedDetail2.vue'
export default {
  components: { UsedComment,UsedDetail2 },
    name: "UsedDetail",
    setup() {
      const id = new URLSearchParams(window.location.search).get("id")
      const store = useStore();
        const state = reactive({
          price: '',
          dtoList: '',
          memberId: store.state.id,
          postsId: null,
          title: '',
          content: '',
          postsDetailId: id,
          usedDetailMemberId : store.state.dtoList.memberId,
          
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

  word-break: break-all;

  overflow: hidden;


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
.imgsize{
  width: 300px;
  height: 300px;
}


</style>
