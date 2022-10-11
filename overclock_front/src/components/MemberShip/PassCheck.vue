<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">
      <div class="container">
        <div class="input-form2 col-md-12 mx-auto">
          <form class="d-flex flex-column" action="login" method="post">
            <span class="answer text-center" id="answerForRecovery1">비밀번호</span>
            <div class="input-group idsection px-5 my-2">
              <input class="form-control" type="password" name="password" id="password" required placeholder="패스워드"
                v-model="state.password" />
            </div>
            <div class="px-5 my-4">
              <button type="button" class="btn btn-outline-primary w-100" @click="submit()">비밀번호 확인</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import store from "@/store";
import { reactive, ref } from "@vue/reactivity";
import axios from "axios";
// import store from "@/store";

export default {
  setup() {
    const state = reactive({
      id: store.state.id,
      nickname: ""
    })
    const nickname = ref('')

    const submit = () => {
      if (state.nickname === '') {
        alert('닉네임을 입력해주세요');
        nickname.value.focus();
        return false;
      } 
        
      const url = '/api/passCheck'
      const headers = {
        "Content-Type": "application/json",
      }
      const body = { nickname: state.nickname };
      axios.post(url, body, { headers }).then(function (res) {
        if (res.data != '') {
          console.log(typeof (res.data));
          alert('성공');
        } 
      })
    }
    return { state, submit,  }
  }
};
</script>
<style scoped>
  .container2 {
    height: 100vh;
  }
  
  .input-form2 {
    text-align: center;
    padding: 32px;
  
    margin-top: 45px;
  
    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
  }
  
  #hero {
    overflow: scroll;
  
    max-height: 1100px;
  }
  
  #hero::before {
    height: 1100px;
  }
  </style>
  
