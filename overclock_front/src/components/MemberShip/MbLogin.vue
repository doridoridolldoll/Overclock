<template>

    <div
      id="back"
      class="d-flex flex-column form-floating"
      action="login"
      method="post"
    >
    <h3>개인 로그인</h3>
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
          <button class="btn btn-warning mt-4 w-100">
            <router-link to="/social" class="nav-link scrollto">소셜 로그인</router-link>
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
    name: "ToMbLogin",
    setup() {
        const state = reactive({
            form: {
                id: "",
                email: "",
                password: "",
                crn: ""
                role: "0",
            },
            crn: null,
        });
        const submit = async () => {
            if (state.form.email === "") {
                alert("아이디를 확인해주세요");
                return false;
            }
            else if (state.form.password === "") {
                alert("비밀번호를 확인해주세요");
                return false;
            }
            const url = "./member/login";
            const headers = { "Content-Type": "application/json; charset=utf-8;" };
            const body = {
              id: state.form.id,
              email: state.form.email,
              password: state.form.password,
              role: state.form.role,
            };
            try {
                await axios.post(url, body, { headers }).then(function (res) {
                    store.commit("setToken", res.data.token);
                    store.commit("setId", res.data.id);
                    state.form.id = res.data.id;
                    // console.log(res.data);
                    store.commit("setEmail", res.data.email);
                    store.commit("setRole", "2");
                    store.commit("setCrn", res.data.crn)
                    // store.commit("setrole) 
                    alert("로그인되었습니다.");
                    router.push(`/`);
                });
            }
            catch (err) {
                alert("로그인에 실패하였습니다.");
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
              console.log(state.crn);
              if(state.crn == 0){ //사업자 등록번호가 없으면 로그인
                const url = "./member/login";
                const body = { id: state.form.id, email: state.form.email, password: state.form.password, role: state.form.role };
                try {
                    axios.post(url, body, { headers }).then(function (res) {
                        store.commit("setToken", res.data.token);
                        store.commit("setId", res.data.id);
                        state.form.id = res.data.id;
                        store.commit("setEmail", res.data.email);
                        store.commit("setRole", state.form.role);
                        alert("로그인되었습니다.");
                        router.push(`/`);
                    });
                }
                catch (err) {
                    alert("로그인에 실패하였습니다.");
                }
              }
              else{
                alert("일반 유저로 로그인 해주세요")
              }
            })
          
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
