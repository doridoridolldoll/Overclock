<template>
  
      <div
        id="back"
        class="d-flex flex-column form-floating"
        action="login"
        method="post"
      >
      <h3>업체 로그인</h3>
        <div class="input-group idsection px-5 my-2">
          <input
            class="form-control"
            type="text"
            name="id"
            id="id"
            v-model="state.form.email"
            required
            placeholder="이메일"
          />
        </div>
  
        <div class="input-group passwordsection px-5 my-2 w-100">
          <input
            class="form-control"
            type="password"
            name="coppassword"
            id="coppassword"
            v-model="state.form.coppassword"
            placeholder="비밀번호"
            required
          />
        </div>
        <div class="px-5 my-4">
          <button @click="submit()" class="btn btn-outline-primary w-100">
            로그인
          </button>
        </div>
      </div>
  </template>
  <script>
  import { reactive } from "@vue/reactivity";
  import axios from "axios";
  import store from "@/store";
  import router from "@/router";
  
  export default {
    name: "ToCpLogin",
    setup() {
      const state = reactive({
        form: {
          email : "",
          copcode: "",
          coppassword: "",
          role: "1",

        },
        crn: null,
      });
      const submit = async () => {
        if (state.form.coppassword === "") {
          alert("비밀번호를 확인해주세요");
          return false;
        }
        const url2 = "/api/crn";
        const headers = { 
          "Content-Type": "application/json; charset=utf-8;" 
        };
        const body2 = { 
          email: state.form.email,
          };
        axios.post(url2, body2, {headers}).then(function(res){
          state.crn = res.data
          console.log(state.crn)
          if(state.crn != 0){ //사업자 등록번호가 있으면 로그인
            const url = "./member/login"
            const headers = { "Content-Type": "application/json; charset=utf-8;"}
            const body = {email : state.form.email, cpcode : state.form.copcode, password: state.form.coppassword, role: state.form.role };
            try {
              axios.post(url, body, { headers }).then(function (res) {
                store.commit("setToken", res.data.token);
                store.commit("setId", res.data.id);
                store.commit("setEmail", res.data.email);
                  store.commit("setRole", state.form.role)
                // store.commit("setrole)
                console.log("==================")
                console.log(res.data);
                alert("로그인되었습니다.");
                router.push(`/`);
              });
            } catch (err) {
              alert("로그인에 실패하였습니다.");
            }
          }else{
            alert("업체 유저로 로그인 해주세요");
          }
        })
      }
      return { state, submit };
    },
  };
  </script>
  <style scoped>
  #back {
    background: white;
    text-align: center;
  
    -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
  
  }
  #back h3{
    margin-top: 30px;
  }
  </style>
  