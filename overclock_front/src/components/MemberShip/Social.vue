<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">
      <div class="container">
        <div class="input-form2 col-md-12 mx-auto">
          <form class="d-flex flex-column" action="login" method="post">
            <h3>소셜 로그인</h3>
            <div class=" idsection px-5  ">

              <div class="soso">
                <a href="http://localhost:9090/oauth2/authorization/google" @click="asd">
                  <img src="../../assets/img/google.png" />
                </a>
              </div>
              <div class="soso2">
                  <img src="../../assets/img/naver.png" style="width: 382px; height: 92px;" />
                </div>
                <div class="soso2">
                  <img src="../../assets/img/kakao.png" style="width: 382px; height: 92px;"/>
                </div>

                
                <button class="btn btn-warning mt-4 back" type="button" @click="goback">
                 돌아가기
                </button>
              </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import router from '@/router';
import store from '@/store';
import axios from 'axios';
import { reactive } from 'vue';

export default {
  name: "ToSocial",
  setup() {

    const state = reactive({
      form: {
        id: "1",
        email: "",
        password: "",
        role: "2",
      },
    })

    const goback = function () {
      router.push('/login')
    }

    const asd = async () => {
      alert("asd");
      const url = "./member/login"
      const headers = { "Content-Type": "application/json; charset=utf-8;" }
      const body = { id: state.form.id, email: state.form.email, password: state.form.password, role: state.form.role };
      await axios.post(url, body, { headers }).then(function (res) {
        store.commit("setToken", res.data.token);
        store.commit("setId", state.form.id);
        store.commit("setEmail", res.data.email);
        store.commit("setRole", "2")
        // store.commit("setrole)
        console.log(res.data);
        alert("로그인되었습니다.");
        router.push(`/`)
      })
    }
    return{asd,goback}
  },
};
</script>
<style scoped>
.container2 {
  height: 100vh;
}

.input-form2 {

  height: fit-content;

 max-width: fit-content;

  text-align: center;
  padding: 32px;

  margin-top: 45px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
}

.soso{
  width: 382px; 
  height:92px; 
  margin: 20px;
  border: 1px solid rgb(212, 203, 203);
  border-radius: 10px;
}
.soso2{
  width: 382px; 
  height:92px; 
  margin: 20px;
  border: 1px solid rgb(212, 203, 203);
  border-radius: 10px;
}

.back{
  width: 382px; 
  height: 50px; 
}

#hero {
  overflow: hidden;

  max-height: 1100px;
}

#hero::before {
  height: 1100px;
}

</style>
