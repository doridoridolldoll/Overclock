<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div
      id="back"
      class="d-flex flex-column form-floating"
      action="login"
      method="post"
    >
    <h3>로그인</h3>
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
          name="password"
          id="password"
          v-model="state.form.password"
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
  </section>
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
        id: "1",
        email: "",
        password: "",
        role: "2",

      },
    });
    const submit = async () => {
      if (state.form.email === "") {
        alert("아이디를 확인해주세요");
        return false;
      } else if (state.form.password === "") {
        alert("비밀번호를 확인해주세요");
        return false;
      }









      const url = "./member/login"
      const headers = { "Content-Type": "application/json; charset=utf-8;"}

      const body = {id:state.form.id, email: state.form.email, password: state.form.password, role: state.form.role };
      try {
        await axios.post(url, body, { headers }).then(function (res) {
          store.commit("setToken", res.data.token);
         
          store.commit("setId", state.form.id);
           console.log(state.form.id);
          store.commit("setEmail", res.data.email);

            store.commit("setRole", "2")
          // store.commit("setrole) 
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
