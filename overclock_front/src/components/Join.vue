<template>
    <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container" data-aos="fade-up">

        <div class="container">
            <div class="input-form col-md-12 mx-auto">
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
                  <input type="password" class="form-control" v-model="state.password" id="password" placeholder="" required>
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

                <!-- <div class="mb-3">
                  <label for="address">주소</label>
                  <input type="text" class="form-control" v-model="state.address" id="address" placeholder="서울특별시 강남구" required>
                  <div class="invalid-feedback">
                    주소를 입력해주세요.
                  </div>
                </div> -->
      
              
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="aggrement" required>
                  <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
                </div>
                <div class="mb-4"></div>
                <button class="btn btn-primary btn-lg btn-block" type="submit" @click="joinHandler">가입 완료</button>
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
      phone       : '',
      address     : ''
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
        email : state.email, password : state.password, name : state.name
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

</style>