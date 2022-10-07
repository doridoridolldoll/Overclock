<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">
      <div class="container">
        <div class="input-form2 col-md-12 mx-auto">
          <form class="d-flex flex-column" action="login" method="post">
            <span class="answer text-center" i-d-b-database="answerForRecovery1">이메일</span>
            <div class="input-group idsection px-5 my-2">
              <input class="form-control" type="text" name="id" id="id" required placeholder="email"
                v-model="state.email" />
            </div>
            <div class="px-5 my-4">
              <button type="button" class="btn btn-outline-primary w-100" @click="submit()">비밀번호 찾기</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { reactive} from "@vue/reactivity";
import axios from "axios";
// import store from "@/store";

export default {
  setup() {
    const state = reactive({
      email: ""
    })

    const submit = () => {
      if (state.email === '') {
        alert('이메일을 입력해주세요');
        state.email.value.focus();
        return false;
      } 
      // else if (!(state.email.includes("@") && state.email.includes("."))) {
      //   alert('이메일 양식이 맞지 않습니다.');
      //   email.value.focus();
      //   return false;
      // }
      const url = '/api/passFind'
      const headers = {
        "Content-Type": "application/json",
      }
      console.log("---------------------");
      console.log(state.email);
      const body = { email: state.email };
      console.log(state.email);
      axios.get(url, body, { headers }).then(function (res) {
        console.log(res)
        if (res.data != '' || res.data != state.email) {
          console.log(typeof (res.data));
          alert('입력하신 이메일로 임시 비밀번호가 발송되었습니다.');

          axios.post("/api/passFind/send", body, {headers}).then(function(res){
            console.log(res);
          })
        } else {
          alert('존재하지 않는 이메일입니다');
        }
        
      })
    }
    return { state, submit }
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
  
