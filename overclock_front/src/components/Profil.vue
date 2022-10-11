<template>
    <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">
  
        <div class="container">
            <div class="input-form2 col-md-12 mx-auto">
              <h4 class="mb-3">내정보</h4>
              <form class="validation-form" @submit.prevent>
                <div class="row">
                  <div class="col-md-6 mb-3">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" v-model="state.name" id="name"  readonly>
                    <div class="invalid-feedback">
                      이름을 입력해주세요.
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <label for="nickname">닉네임</label>
                    <input type="text" class="form-control" v-model="state.nickname" id="nickname" readonly>
                    <div class="invalid-feedback">
                      닉네임을 입력해주세요.
                    </div>
                  </div>
                </div>
      
                <div class="mb-3">
                  <label for="email">이메일</label>
                  <input type="email" class="form-control" v-model="state.email" id="email"  readonly>
                  <div class="invalid-feedback">
                    이메일을 입력해주세요.
                  </div>
                </div>
                <div class="mb-3">
                  <label for="phone">전화번호</label>
                  <input type="text" class="form-control" v-model="state.phone" id="phone" readonly>
                  <div class="invalid-feedback">
                    전화번호를 입력해주세요.
                  </div>
                <!-- </div>
                <button class="btn btn-primary btn-lg btn-block" @click="modify" >수정</button>
                <div> -->
                  <button @click="handleClick">회원정보 수정</button>
                  <Modal ref="modal"/>
                </div>
              </form>
            </div>
        </div>
      </div>
  </section>
  </template>
  
  <script>
  import {reactive} from '@vue/reactivity'
  import axios from 'axios'
  import router from '@/router'
  import { useStore } from 'vuex'
  import Modal from './Modal.vue'
  import { ref } from "vue";

  export default {
    name:'ToProfil',
    components: {Modal},
  setup(){
    const store = useStore();
    const state = reactive({
      id          : store.state.dtoList.id,
      email       : store.state.email,
      password    : '',
      repassword  : '', 
      name        : '',
      nickname    : '',
      phone       : '',
      city        : '',
      street      : '',
      zipcode     : '',
      modal : false,
      message: ""
    })

    const modal = ref(null);

    const result = ref("");

    // async-await을 사용하여, Modal로부터 응답을 기다리게 된다.
    const handleClick = async () => {
      const ok = await modal.value.show();
      if (ok) {
        result.value = "확인을 눌렀군요!";
      } else {
        result.value = "취소를 눌렀네요?";
      }
    };

    const headers = {
        "Content-Type" : "application/json",
      }
    const body = {

      id: store.state.id,
      email: state.email,
      password: state.password,
      repassword: state.repassword,
      name: state.name,
      phone: state.phone,
      city: state.city,
      street: state.street,
      zipcode: state.zipcode,
      nickname: state.nickname,
    }
    axios.post("/api/mList", body, { headers }).then(function (res) {
      state.name = res.data.name
      state.nickname = res.data.nickname
      state.phone = res.data.phone

      console.log(res.data)
      console.log(state.phone)
      console.log(state.city)
    })
    const modify = async() => {
      const url = '/api/mModify/send'


      console.log(body)
      // if (state.email === '') {
      // alert('이메일을 입력해주세요'); 
      // state.email.value.focus(); return false;
      // } else if (!(state.email.includes("@") && state.email.includes("."))) {
      // alert('이메일 양식이 맞지 않습니다.'); 
      // state.email.value.focus(); return false;
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
      // console.log(response.data)
      if(response.status === 200){
        alert('회원정보가 수정되었습니다.');
      } else {
        alert('회원가입에 실패하였습니다.')
      }
      router.push({name: "Login"});
    }
    return {modify,
            state,
            modal,
            result,
            handleClick,}
  }
  
  }
  </script>
  
  <style scoped>
  .container2{
  height: 100vh;
  }
  .input-form2 {
    margin-top: 50px;
        text-align: center;
        padding: 32px;
  
        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
      }
  
  </style>