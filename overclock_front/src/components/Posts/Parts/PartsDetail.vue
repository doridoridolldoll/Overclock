<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <body>
      <main id="main">
        <section id="portfolio-details" class="portfolio-details">
          <div class="container input-form">
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
                <router-link to="" class="btn btn-primary">구매</router-link>
          </div>
        </section>
      </main>
      <div></div>
    </body>
  </section>
</template>

<script>
import {useRoute} from 'vue-router'
    export default {
        name: 'PartsDetail',
        setup(){  
          let route = useRoute()
          let asd = JSON.parse(route.query.name.join("").split(","));
          console.log(asd);
          const displayUrl = "/display";
          const url = `http://localhost:9090${displayUrl}`;
          let img = '';
          img = `${url}?fileName=${asd.imageDTOList[0].imageURL}`;
          

          return {route,asd,img}
        }
    }
<<<<<<< Updated upstream
// import { defineProps } from 'vue '
// let props = defineProps(["partsList", "test"])
// console.log(props.partsList);
// console.log(props.test);
// console.log(props);
=======
    console.log("body : " + body.id)
    axios.post(url, body, { headers })
      .then(function (res) {
        state.dtoList = res.data.articles[0];
        const displayUrl = "/display";
        const url = `http://localhost:9090${displayUrl}`;
        state.imgName = res.data.articles[0].imgName;
        state.imgPath = res.data.articles[0].imgPath;
        state.imgUuid = res.data.articles[0].imgUuid;
        let str = state.imgPath + "/" +state.imgUuid + "_" + state.imgName;
        state.img = `${url}?fileName=${str}`;
    });





    //장바구니 담기

    function add(){
      const url = "./register/cartAdd";
      const headers = {
        "Content-Type": "application/json"
      };
      const body = {
        memberId : state.memberId,
        cartName: state.title,
        price: state.price*state.count,
        count: state.count,
        imgUrl: state.imgUrl,
      }
      if(state.memberId == 0){
        alert("로그인 후 사용가능합니다");
        return;
      }
      axios.post(url, body, { headers })
        .then(function(res){
          console.log("===========================")
          console.log(res)
          alert("장바구니에 담았습니다 ")
        })
    }
    return { state, add };
  }
}
>>>>>>> Stashed changes

</script>
<style scoped>
.input-form {
  text-align: center;

  max-width: 900px;

  margin-top: 80px;
  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
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
</style>
