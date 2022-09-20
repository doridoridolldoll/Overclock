<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="input-form col-md-12 mx-auto form-floating">
        <i class="bi bi-person-workspace"></i>
        <h3 class="h3 mb-3 fw-normal" style="color: black">로그인</h3>

        <div class="form-floating">
          <input
            type="email"
            class="form-control"
            id="floatingInput"
            v-model="state.email"
            placeholder="name@example.com"
          />
          <label for="floatingInput">이메일</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            v-model="state.password"
            placeholder="Password"
          />
          <label for="floatingPassword">비밀번호</label>
        </div>

        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me" /> 아이디 저장
          </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" 
        type="submit" 
        @click="loginHandler">
          Sign in
        </button>
        <router-link to="/join"
          class="w-100 btn btn-ji btn-secondary"
          type="submit"
          style="margin-top: 10px"
          @click="goJoin"
        >
          Join in
        </router-link>
    </div>
</section>
</template>

<script>
import { reactive } from 'vue';
export default {
name:'ToLogin',
setup(){
const state = reactive({
  email       : '',
  password    : '',
})
const loginHandler = async() => { //eslint-disable-line no-unused-vars
  if (state.email === '') {
  alert('이메일을 입력해주세요'); 
  state.email.value.focus(); return false;
  } else if (!(state.email.includes("@") && state.email.includes("."))) {
  alert('이메일 양식이 맞지 않습니다.'); 
  state.email.value.focus(); return false;
  } else if (state.password === '') {
  alert('비밀번호를 입력해주세요'); 
  state.password.value.focus(); return false;
}
}
return{loginHandler,state}
}
}


</script>

<style>
  .input-form {
    text-align: center;

    max-width: 680px;

    margin-top: 80px;
    padding: 32px;

    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
  }


</style>