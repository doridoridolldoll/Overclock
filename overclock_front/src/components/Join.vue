<template>
    <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">

        <div class="container">
            <div class="input-form2 col-md-12 mx-auto">
              <h4 class="mb-3">회원가입</h4>
              <form class="validation-form" novalidate>
                <div class="row">
                  <div class="col-md-6 mb-3">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" v-model="state.name" id="name" placeholder="" required>
                    <div class="invalid-feedback">
                      이름을 입력해주세요.
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <label for="nickname">닉네임</label>
                    <input type="text" class="form-control" v-model="state.nickname" id="nickname" placeholder="" required>
                    <div class="invalid-feedback">
                      닉네임을 입력해주세요.
                    </div>
                  </div>
                </div>
      
                <div class="mb-3">
                  <label for="email">이메일</label>
                  <input type="email" class="form-control" v-model="state.email" id="email" placeholder="you@example.com" required>
                  <div class="invalid-feedback">
                    이메일을 입력해주세요.
                  </div>
                </div>

                <div class="mb-3">
                  <label for="password">비밀번호</label>
                  <input type="password" class="form-control" v-model="state.password" id="password">
                  <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                  </div>
                </div>

                <div class="mb-3">
                  <label for="repassword">비밀번호확인</label>
                  <input type="password" class="form-control" v-model="state.repassword" id="repassword">
                  <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                  </div>
                </div>

                <div class="mb-3">
                  <label for="phone">전화번호</label>
                  <input type="text" class="form-control" v-model="state.phone" id="phone" placeholder="010-0000-0000" required>
                  <div class="invalid-feedback">
                    전화번호를 입력해주세요.
                  </div>
                </div>

                <div class="mb-3">
                  <label for="city">도시</label>
                  <input type="text" class="form-control" v-model="state.city" id="city" placeholder="부산광역시 사하구" required>
                  <div class="invalid-feedback">
                    도시를 입력해주세요.
                  </div>
                </div>
      
                <div class="mb-3">
                  <label for="street">도로명</label>
                  <input type="text" class="form-control" v-model="state.street" id="street" placeholder="낙동대로123번길" required>
                  <div class="invalid-feedback">
                    도로명 주소를 입력해주세요.
                  </div>
                </div>
      
                <div class="mb-3">
                  <label for="zipcode">우편번호</label>
                  <input type="text" class="form-control" v-model="state.zipcode" id="zipcode" placeholder="12345" required>
                  <div class="invalid-feedback">
                    우편번호를 입력해주세요.
                  </div>
                </div>
      
              
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" v-model="state.aggrement" id="aggrement" required>
                  <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
                </div>
                <div class="mb-4"></div>
                <button class="btn btn-primary btn-lg btn-block" type="submit" @click="joinHandler" >가입 완료</button>
              </form>
            </div>
          </div>
        </div> 
    </section>

</template>

<script>
import {reactive } from '@vue/reactivity'
import axios from 'axios'
export default {
    name:'ToJoin',
  setup(){
    const state = reactive({
      email       : '',
      password    : '',
      repassword  : '', 
      name        : '',
      nickname    : '',
      phone       : '',
      city        : '',
      street      : '',
      zipcode     : '',
    })
    // const email = ref('')
    // const password = ref('')
    // const repassword = ref('')
    const joinHandler = async() => {

      const url = '/api/memberRegister'
      const headers = {
        "Content-Type" : "application/json",
      }
      const body = {
        email : state.email,
        password : state.password,
        name : state.name,
        phone : state.phone,
        city : state.city,
        street : state.street,
        zipcode : state.zipcode,
        nickname : state.nickname,
      }
      if (state.email === '') {
      alert('이메일을 입력해주세요'); 
      state.email.value.focus(); return false;
      } else if (!(state.email.includes("@") && state.email.includes("."))) {
      alert('이메일 양식이 맞지 않습니다.'); 
      state.email.value.focus(); return false;
      } else if (state.password === '') {
      alert('비밀번호를 입력해주세요'); 
      state.password.value.focus(); return false;
      } else if (state.repassword === '') {
      alert('비밀번호를 입력해주세요'); 
      state.repassword.value.focus(); return false;
      } else if (state.name === '') {
      alert('이름을 입력해주세요'); 
      state.nickname.value.focus(); return false;
      } else if (state.nickname === '') {
      alert('닉네임을 입력해주세요'); 
      state.name.value.focus(); return false;
      } else if (state.phone === '') {
      alert('전화번호를 입력해주세요'); 
      state.phone.value.focus(); return false;
      } else if (state.city === '') {
      alert('도시명을 입력해주세요'); 
      state.city.value.focus(); return false;
      } else if (state.street === '') {
      alert('도로명주소를 입력해주세요'); 
      state.street.value.focus(); return false;
      } else if (state.zipcode === '') {
      alert('우편번호를 입력해주세요'); 
      state.zipcode.value.focus(); return false;
      } else if (state.password != state.repassword) {
      alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요');
      state.password.value.value = ''; 
      state.repassword.value.value = '';
      state.password.value.focus(); return false;
      }
      const response = await axios.post(url, body, {headers})
      console.log(response.data)
      if(response.status === 200){
        alert('회원가입이 되었습니다.');
      } else {
        alert('회원가입에 실패하였습니다.')
      }
    }
    return {joinHandler,state}
  }
}
</script>

<style>
 .container2{
  height: 100vh;
 }
 .input-form2 {
        text-align: center;
        padding: 32px;

        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
      }

</style>