<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">
      <div class="container">
        <div class="input-form2 col-md-12 mx-auto">
          <form class="d-flex flex-column" action="login" method="post">
            <h3>아이디 찾기</h3><hr>
            <span class="answer text-center" i-d-b-database="answerForRecovery1">휴대전화 번호</span>
            <div class="input-group idsection px-5 my-2">
              <input class="form-control" type="text" name="phone" id="phone" required placeholder="휴대전화 번호"
                v-model="state.phone" />
            </div>
            <div class="px-5 my-4">
              <button type="button" class="btn btn-outline-primary w-100" @click="phoneCheck()">인증번호 발송</button>
            </div>
            <span class="answer text-center" i-d-b-database="answerForRecovery1">인증번호</span>
            <input class="form-control" type="text" name="crn" id="crn" required placeholder="인증번호"
              v-model="state.crnInput" />
            <div class="px-5 my-4">
              <button type="button" class="btn btn-outline-primary w-100" @click="submit()">인증번호 확인</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { reactive } from "@vue/reactivity";
import PhoneCheck from "./PhoneCheck.vue";
import axios from "axios";
import router from '@/router';
// import store from "@/store";

export default {
  setup() {
    const state = reactive({
      phone: "",
      crn: "",
      crnInput: "",
      change: 0,
      email: ""
    })

    const phoneCheck = () => {
      if (state.phone === '') {
        alert('전화번호를 입력해주세요');
        state.phone.value.focus();
        return false;
      } 
      const url = '/api/phoneCheck'
      const headers = {
        "Content-Type": "application/json",
      }
      const body = { 
        phone: state.phone
      };
      console.log("==========================================");
      console.log(state.phone);
      axios.post(url, body, { headers }).then(function (res) {
        if (res.data.validate === false) {
          alert("전화번호가 존재하지 않습니다.")
          return false;
        } else (res.data.validate === true)
          alert("가입한 전화번호로 인증번호를 보냈습니다.")
          axios.post("/api/sendSMS", body, { headers }).then(function (res) {
            console.log("---------------------------");
            console.log(res);
            console.log(res.data);
            state.crn = res.data.crn;
            state.email = res.data.email;
            
          });
        })
    }
    
    const submit = () => {
      if (state.crnInput === "" || state.crnInput !== state.crn) {
              alert("인증번호가 일치하지 않습니다");
              return false;
          }
          alert(`회원님의 이메일은 ${state.email} 입니다`)
          router.push({path:"/login"})
      }
    return { state, PhoneCheck, submit, phoneCheck }
  },
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
  
