<template>

  <section id="hero" class="d-flex align-items-center justify-content-center ">
    <body>
      <main id="main">
        <section id="portfolio-details" class="portfolio-details">
          <div class="container input-form flex-wrap">
            <div class="row gy-4">
              <div class="col-lg-8">
                <div class="portfolio-details-slider swiper">
                  <div class="swiper-wrapper align-items-center">
                    <div class="swiper-slide">
                      <img src="https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTmUHH0v9f2o86r8JPMrnRhY6V_Si8AT_ldqmyq4TxxTsNdXMHIsqqrDmA_R48ZbxSHCz2iSWqCvvrXhCHhSDNIYZAQ1RO0i0Jhn2Mw5dN7NG4Rm4RVnuIJ&usqp=CAE" style="width:370px;height:300px;"></div>
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
                <router-link to="" class="btn btn-primary">구매</router-link>
          </div>
        </section>
      </main>
    </body>
  </section>
</template>

<script>
export default {
  name: "ToDetail",
  setup() {},
};
</script>
<style scoped>
.input-form {
  text-align: center;

  max-width: 1000px;

  margin-top: 80px;
  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

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

</style>
