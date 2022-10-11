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
                  <h3>{{state.dtoList.title}}</h3>
                  <ul>
                    <li><strong>상품명</strong>: Web design</li>
                    <li><strong>판매자</strong>: {{state.dtoList.memberId}}</li>
                    <li><strong>등록일자</strong>: 01 March, 2020</li>
                    <li><strong>위치</strong>: 부산광역시 <br>사하구</li>
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
                  <h2>거래정보</h2>
                  <p style="font-size: x-large;">
                    {{state.dtoList.content}}
                    </p>
                </div>
                <div><h3>조회수 : {{state.dtoList.viewCount}}</h3></div>
                
                <router-link to="/partsModify" class="btn2 btn btn-primary">수정</router-link>

                <Comment
              :dtoList="state.dtoList"
            />
          </div>
    </body>
  </section>
</template>

<script>
import { reactive } from '@vue/reactivity';
import { useStore } from 'vuex'
import Comment from '../Comment/Comment.vue';
import PcPay from '@/components/Pay/PcPay.vue';
export default {
  components: { Comment, PcPay },
    name: "UsedDetail",
    setup() {
      const store = useStore();
        const state = reactive({
          price: '',
          dtoList: '',
          memberId: null,
          postsId: null,
          title: '',
          content: '',
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
