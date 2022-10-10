<template>

  <div class="input-form2 col-md-12 mx-auto">
    <h4 class="mb-3">업체 회원가입</h4>
    <form class="validation-form" @submit.prevent>
        <div class="mb-3">
          <label for="name">회사명</label>
          <input type="text" class="form-control" v-model="state.cpName" id="copname" placeholder="" required>
          <div class="invalid-feedback">
            회사명을 입력해주세요.
          </div>
        </div>
        <div class="mb-3">
          <label for="email">이메일</label>
          <input type="email" class="form-control" v-model="state.email" id="email" placeholder="you@example.com">
            이메일을 입력해주세요.
          </div>
      <div class="mb-3">
        <label for="copcode">사업자등록번호</label>
        <input type="copcode" class="form-control" v-model="state.cpCode" id="copcode" placeholder="" required>
        <div class="invalid-feedback">
          사업자등록번호를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="password">비밀번호</label>
        <input type="password" class="form-control" v-model="state.cpPw" id="coppassword">
        <div class="invalid-feedback">
          비밀번호를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="repassword">비밀번호확인</label>
        <input type="password" class="form-control" v-model="state.reCpPw" id="recoppassword">
        <div class="invalid-feedback">
          비밀번호를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="phone">전화번호</label>
        <input type="text" class="form-control" v-model="state.cpPhone" id="copphone" placeholder="010-0000-0000" required>
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
        <tr><td><a href="http://localhost:9090/oauth2/authorization/google">Google</a></td></tr> 
    </form>
  </div>

  </template>
  
  <script>
  import {reactive} from '@vue/reactivity'
  import axios from 'axios'
  import router from '@/router'
  export default {
    name:'ToJoin',
  setup(){
    const state = reactive({
      email : '',
      id          : '',
      cpCode       : '',
      cpPw    : '',
      reCpPw  : '', 
      cpName        : '',
      cpPhone       : '',
      city        : '',
      street      : '',
      zipcode     : '',
    })
    const joinHandler = async() => {
      console.log("asas")
      const url = './api/companyRegister'
      const headers = {
        "Content-Type" : "application/json",
      }
      const body = {
        email : state.email,
        id : state.id,
        crn : state.cpCode,
        password   : state.cpPw,
        name : state.cpName,
        phone : state.cpPhone,
        city : state. city,
        street : state.street,
        zipcode : state.zipcode,
      }
      console.log(body)
      // if (state.copcode === '') {
      // alert('이메일을 입력해주세요'); 
      // state.copcode.value.focus(); return false;
      // } else if (!(state.copcode.includes("@") && state.copcode.includes("."))) {
      // alert('이메일 양식이 맞지 않습니다.'); 
      // state.copcode.value.focus(); return false;
      // } else if (state.password === '') {
      // alert('비밀번호를 입력해주세요'); 
      // state.password.value.focus(); return false;
      // } else if (state.repassword === '') {
      // alert('비밀번호를 입력해주세요'); 
      // state.repassword.value.focus(); return false;
      // } else if (state.name === '') {
      // alert('이름을 입력해주세요'); 
      // state.nickname.value.focus(); return false;
      // } else if (state.nickname === '') {
      // alert('닉네임을 입력해주세요'); 
      // state.name.value.focus(); return false;
      // } else if (state.phone === '') {
      // alert('전화번호를 입력해주세요'); 
      // state.phone.value.focus(); return false;
      // } else if (state.city === '') {
      // alert('도시명을 입력해주세요'); 
      // state.city.value.focus(); return false;
      // } else if (state.street === '') {
      // alert('도로명주소를 입력해주세요'); 
      // state.street.value.focus(); return false;
      // } else if (state.zipcode === '') {
      // alert('우편번호를 입력해주세요'); 
      // state.zipcode.value.focus(); return false;
      // } else if (state.password != state.repassword) {
      // alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요');
      // state.password.value.value = ''; 
      // state.repassword.value.value = '';
      // state.password.value.focus(); return false;
      // }
      const response = await axios.post(url, body, {headers})
      if(response.status === 200){
        alert('회원가입이 되었습니다.');
      } else {
        alert('회원가입에 실패하였습니다.')
      }
      router.push({name: "Login"});
    }
    return {joinHandler,state}
  }
  }
  </script>
  
  <style scoped>
  .container2{
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
  
  #hero{
    overflow: scroll;
  
    max-height: 1100px;
  }
  
  #hero::before{
    height: 1100px;
  }
  
  </style>