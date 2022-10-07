<template>

  <section id="hero" class="d-flex justify-content-center ">
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
                <div class="portfolio-info" >
                  <h3>titleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</h3>
                  <ul>
                    <li><strong>상품명</strong>: Web design</li>
                    <li><strong>판매자</strong>: ASU Company</li>
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
                    
                  </ul>
                </div>
              </div>
            </div>
            <div class="portfolio-description">
                  <h2>거래정보</h2>
                  <p>
                    군대간 친형 컴퓨터 뜯어서 팝니다/
                    부산내 직거래 가능/
                    준등기 +1800/
                    편택,반택 +1600/
                    </p>
                </div>
                <div><h3>조회수 : {{state.dtoList.viewCount}}</h3></div>
                <router-link to="" class="btn btn-primary">구매</router-link>
                <Comment/>
          </div>
    </body>
  </section>
</template>

<script>
import { reactive } from '@vue/reactivity';
import { useRoute } from 'vue-router';
import Comment from '../Comment/Comment.vue';
export default {
    name: "UsedDetail",
    setup() {
        const state = reactive({
            dtoList: [],
        });
        let route = useRoute();
        // console.log(route.query.name);
        let asd = JSON.parse(route.query.name.join("").split(","));
        state.dtoList = asd;
        console.log(asd);
        const displayUrl = "/display";
        const url = `http://localhost:9090${displayUrl}`;
        let img = "";
        img = `${url}?fileName=${asd.imageDTOList[0].imageURL}`;
        return { route, img, state };
    },
    components: { Comment }
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



</style>
