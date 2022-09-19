<template>
  <div>
    <h1>{{ message }}</h1>
    <form>
      <label for="">
        <input type="text" ref="email" v-model="state.email" placeholder="Email"
          required autofocus class="form-control" @keyup="emailCheckHandler" />
      </label><br>
      <label for="">
        <input type="password" class="form-control" ref="password" v-model="state.password" placeholder="Password"/>
      </label><br>
      <label for="">
        <input type="password" class="form-control" ref="repassword" v-model="state.repassword" placeholder="RePassword"/>
      </label><br />
      <label for="">
        <input type="text" class="form-control" ref="name" v-model="state.name" placeholder="Name"/>
      </label><br />
      <div class="box"></div>
      <FileUpload />
      <label for="">
        {{ state.emailCheck }}
        <el-button type="primary" @click="joinHandler">Register</el-button>
      </label>
    </form>
  </div>
  <Teleport to="body">
    <!-- use the modal component, pass in the prop -->
    <modal :show="state.showModal" @close="state.showModal = false">
      <template #header>
        <h3>Notice</h3>
      </template>
      <template #body>
        <h3>회원가입 완료</h3>
      </template>
      <template #footer>
        <button class="modal-default-button" type="button" @click="goHome">홈으로 가기</button>
        <button type="button" class="btn btn-secondary">Secondary</button>
      </template>
    </modal>
  </Teleport>
</template>

<script>
import {reactive, ref} from '@vue/reactivity'
import axios from 'axios'
import {useRouter} from 'vue-router';
import Modal from './teleport/Modal.vue'
import FileUpload from './FileUpload.vue'

export default {
  name: 'TheJoin',
  components: { Modal, FileUpload },
  setup() {
    const router = useRouter();
    const state = reactive({
      email       : '',
      password    : '',
      repassword  : '',
      name        : '',
      imgeDTOList : new Array(),
      emailCheck  : '',
      token       : sessionStorage.getItem("TOKEN"),
      showModal   : false,
    })
    const email = ref('')
    const password = ref('')
    const repassword = ref('')
    const name = ref('')
    const emailCheckHandler = async() => {
      const url ='/apiserverex/api/emailCheck'
      const headers = {
        "Content-Type" : "application/json",
        Authorization: state.token, 
        "token": state.token }
      const body ={email : state.email}
      const response = await axios.post(url, body, {headers})
      if(response.status === 200){
        state.emailCheck=(response.data.result === 1)?"사용불가":"사용가능"
      } else {
        state.emailCheck="중복 확인"
      }
    }
    const joinHandler = async() => {
      if(state.email === ''){
        alert('Check Email');email.value.focus(); return false;
      } else if(state.password === ''){
        alert('Check Password');password.value.focus(); return false;
      } else if(state.repassword === ''){
        alert('Check RePassword');repassword.value.focus(); return false;
      } else if(state.name === ''){
        alert('Check Name');name.value.focus(); return false;
      } else if(state.password != state.repassword){
        alert('Check Password and RePassword');
        password.value.value='';repassword.value.value='';
        password.value.focus(); return false;
      }
      let str = "";
      const liArr = document.querySelectorAll(".uploadResult ul li")
      for(let i=0;i<liArr.length;i++){
        const target = liArr[i];
        str += `
          <input type="hidden" name="imageDTOList[${i}].imgName" 
          value="${target.dataset.name}">
          <input type="hidden" name="imageDTOList[${i}].path" 
          value="${target.dataset.path}">
          <input type="hidden" name="imageDTOList[${i}].uuid" 
          value="${target.dataset.uuid}">          
        `
        const obj = {
          imgNmae : target.dataset.name,
          path    : target.dataset.path,
          uuid    : target.dataset.uuid
        }
        state.imgeDTOList.push(obj)
      }
      document.querySelector(".box").innerHTML = str
      
      const url = '/apiserverex/api/memberRegister'
      const headers = {
        "Content-Type" : "application/json",
        Authorization: state.token, 
        "token": state.token }
      const body = {
        email : state.email, password : state.password, name : state.name,
        imageDTOList: state.imageDTOList
      }
      const response = await axios.post(url, body, {headers})
      console.log(response.data)
      if(response.status === 200){
        // alert('회원가입이 되었습니다.');
        state.showModal = true
      } else {
        alert('회원가입에 실패하였습니다.')
      }
    }
    const goHome = () =>{
      router.push({name: "Home"})
    }
    
    return {state,email,name,password,repassword,emailCheckHandler,joinHandler,goHome}
  },
  data() {
    return {message: 'Welcome Join'}
  }
};
</script>

<style>
  label {
    display: inline-block;width:500px;text-align: right;color: red;
    margin: 10px 0;
  }
  /* @import url(../assets/commonstyle.css); */
</style>