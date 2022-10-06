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
            name="copid"
            id="copid"
            v-model="state.form.copcode"
            required
            placeholder="사업자등록번호"
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
    name: "ToLogin",
    setup() {
      const state = reactive({
        form: {
          copcode: "",
          coppassword: "",
          role: "2",
  
        },
      });
      const submit = async () => {
        if (state.form.copcode === "") {
          alert("사업자등록번호를 확인해주세요");
          return false;
        } else if (state.form.coppassword === "") {
          alert("비밀번호를 확인해주세요");
          return false;
        }
  
        const url = "./member/login"
        const headers = { "Content-Type": "application/json; charset=utf-8;"}
  
        const body = { email: state.form.email, password: state.form.password, role: state.form.role };
        try {
          await axios.post(url, body, { headers }).then(function (res) {
            store.commit("setToken", res.data.token);
            store.commit("setId", res.data.id);
            store.commit("setEmail", res.data.email);
              store.commit("setRole", "2")
            // store.commit("setrole)
            console.log(res.data);
            alert("로그인되었습니다.");
            router.push(`/`);
          });
        } catch (err) {
          alert("로그인에 실패하였습니다.");
        }
      };
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
  