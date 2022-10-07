<template>
  <section id="hero" class="d-flex justify-content-center">
    <body class="form-floating">
          <div class="container portfolio-details input-form">
            <div class="row gy-4">
              <div class="col-lg-8">
                <div class="portfolio-details-slider swiper">
                  <div class="swiper-wrapper align-items-center">
                      <div class="icon"><img v-bind:src="img"/></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="portfolio-info">
                  <h3>상품정보</h3>
                  <ul>
                    <li><strong></strong>: Web design</li>
                    <li><strong>판매자</strong>: ASU Company</li>
                    <li><strong>등록일자</strong>: 01 March, 2020</li>
                    <li>
                      <strong>가격</strong>:
                      999,999,999
                    </li>
                  </ul>
                </div>
                <div class="portfolio-info">
                  <ul>
                    <li><strong>수량</strong>: <input type="number" value="1" min="1" max="999"></li>

                    <PcPay
                      :price="state.price">
                      </PcPay>
                    
                  </ul>
                </div>
              </div>
            </div>
            <div class="portfolio-description">
                  <h2>제품상세</h2>
                  <p>
                    RTX 3060 Ti / 8nm / 
                    베이스클럭: 1680MHz / 
                    스트림 프로세서: 4864개 / 
                    PCIe4.0x16 / GDDR6(DDR6) / 
                    출력단자: HDMI2.1 , DP1.4 / 
                    부가기능: 제로팬(0-dB기술) , 
                    8K 해상도 지원 , 4K 해상도 지원 ,
                     HDCP 지원 / 정격파워 600W 이상 /
                      전원 포트: 8핀 x1개 / 2개 팬 / 
                      가로(길이): 198mm / 백플레이트
                    </p>
                </div>
                <div>{{state.price}}</div>
                <div><h3>조회수 : {{state.dtoList.viewCount}}</h3></div>

                <router-link to="" class="btn1 btn btn-primary ">구매</router-link>
                <router-link to="/partsModify" class="btn2 btn btn-primary">수정</router-link>

                <Comment
              :dtoList="state.dtoList"
            />

          </div>
      <div></div>
    </body>
  </section>
</template>

<script>
import { useStore } from 'vuex'
// import {useRoute} from 'vue-router'
import { reactive } from '@vue/reactivity';
import Comment from '@/components/Posts/Comment/Comment.vue';
import PcPay from '@/components/Pay/PcPay.vue';
  export default {
  components: { Comment, PcPay },
      name: 'PartsDetail',
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
