<template>
  <div class="input-form2 col-md-12 mx-auto">
    <h4 class="mb-3">일반 회원가입</h4>
    <form class="validation-form" @submit.prevent>
      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="name">이름</label>
          <input type="text" class="form-control" v-model="state.name" id="name" placeholder="">
          <div class="invalid-feedback">
            이름을 입력해주세요.
          </div>
        </div>
        <div class="col-md-6 mb-3">
          <label for="nickname">닉네임</label>
          <input type="text" class="form-control" v-model="state.nickname" id="nickname" placeholder="">
          <div class="invalid-feedback">
            닉네임을 입력해주세요.
          </div>
        </div>
      </div>

      <div class="mb-3">
        <label for="email">이메일</label>
        <input type="email" class="form-control" v-model="state.email" id="email" placeholder="you@example.com">
          이메일을 입력해주세요.
      </div>

      <button @click="emailVali()" class="btn btn-outline-primary w-100">
        이메일 중복 확인
      </button>
      <button @click="emailCheck()" class="btn btn-outline-primary w-100" v-if="(state.ch == 1)">
        인증번호 전송
      </button>
      <EmailCheck v-if="(state.change == 1)"
      :keys="state.keys"
      :email="state.email" />

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
        <input type="text" class="form-control" v-model="state.phone" id="phone" placeholder="010-0000-0000">
        <div class="invalid-feedback">
          전화번호를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="city">도시</label>
        <input type="text" class="form-control" v-model="state.city" id="city" placeholder="부산광역시 사하구">
        <div class="invalid-feedback">
          도시를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="street">도로명</label>
        <input type="text" class="form-control" v-model="state.street" id="street" placeholder="낙동대로123번길">
        <div class="invalid-feedback">
          도로명 주소를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="zipcode">우편번호</label>
        <input type="text" class="form-control" v-model="state.zipcode" id="zipcode" placeholder="12345">
        <div class="invalid-feedback">
          우편번호를 입력해주세요.
        </div>
      </div>


      <hr class="mb-4">
      <div class="custom-control custom-checkbox">
        <input type="checkbox" class="custom-control-input" v-model="state.aggrement" id="aggrement">
        <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
      </div>
      <div class="mb-4"></div>
      <button class="btn btn-primary btn-lg btn-block" type="submit" @click="joinHandler">가입 완료</button>
      <tr>
        <td><a href="http://localhost:9090/oauth2/authorization/google" @click="asd">Google</a></td>
      </tr>
    </form>
  </div>
</template>

<script>
import { reactive } from '@vue/reactivity'
import axios from 'axios'
import router from '@/router'
import store from '@/store'
import EmailCheck from './EmailCheck.vue'
export default {
  name: 'ToJoin',
  setup() {
    
    const state = reactive({
      form: {
        id: "1",
        email: "",
        password: "",
        role: "2",
      },
      id: '',
      email: '',
      password: '',
      repassword: '',
      name: '',
      nickname: '',
      phone: '',
      city: '',
      street: '',
      zipcode: '',
      change: 0,
      key: '',
      emailVal: '',
      ch: 0
    })

    const emailCheck = () => {

      state.change = 1;
      if (state.email === "") {
        alert("이메일을 입력해주세요");
        state.email.value.focus();
        return false;
      }
      const url = "/api/passFind";
      const headers = {
        "Content-Type": "application/json",
      };
      console.log("---------------------");
      console.log(state.email);
      const body = { email: state.email };
      axios.get(url, body, { headers }).then(function (res) {
        console.log(res);
        if (res.data.email === state.email) {
          alert("이미 존재하는 이메일입니다.")
        } else if (res.data != "" || res.data.email != state.email) {
          console.log(typeof (res.data));
          alert("입력하신 이메일로 인증번호가 발송되었습니다.");
          axios.post("/api/join/emailCheck", body, { headers }).then(function (res) {
            console.log("---------------------------");
            console.log(res);
            console.log(res.data.key);
            state.key = res.data.key;
            state.emailVal = res.data.email;
          });
        } 
        else {
          alert("존재하지 않는 이메일입니다");
        }
      });

    }

    const asd = async () => {
      alert("asd");
      const url = "./member/login"
      const headers = { "Content-Type": "application/json; charset=utf-8;" }
      const body = { id: state.form.id, email: state.form.email, password: state.form.password, role: state.form.role };
      await axios.post(url, body, { headers }).then(function (res) {
        store.commit("setToken", res.data.token);
        store.commit("setId", state.form.id);
        store.commit("setEmail", res.data.email);
        store.commit("setRole", "2")
        // store.commit("setrole)
        console.log(res.data);
        alert("로그인되었습니다.");
        router.push(`/`)
      })
    }

    const emailVali = async () => {
      const url = "/api/emailVali"
      const headers = { "Content-Type": "application/json; charset=utf-8;" }
      const body = { email: state.email };
      console.log(state.email);
      await axios.post(url, body, { headers }).then(function (res) {
        if (res.data.validate === true) {
          alert("이미 존재하는 이메일입니다.")
          return false;
        } else (res.data.validate === false)
          alert("가입 가능한 이메일입니다.")
          state.ch = 1
      }
      )
    }

    const joinHandler = async () => {

      const url = './api/memberRegister'
      const headers = {
        "Content-Type": "application/json",
      }
      const body = {
        id: state.id,
        email: state.email,
        password: state.password,
        name: state.name,
        phone: state.phone,
        city: state.city,
        street: state.street,
        zipcode: state.zipcode,
        nickname: state.nickname,
      }
      console.log(body)
  
      console.log(store.state.email);
      if(store.state.email === 0) {
        return false;
      } else {
      const response = await axios.post(url, body, { headers })
      // console.log(response.data)
      if (response.status === 200) {
        alert('회원가입이 되었습니다.');
      } else {
        alert('회원가입에 실패하였습니다.')
      }
      router.push({ name: "Login" });
    }
    }

    return { joinHandler, state, asd, emailCheck, emailVali }
  },
  components: { EmailCheck  }
};
</script>

<style scoped>
.container2 {
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

#hero {
  overflow: scroll;

  max-height: 1100px;
}

#hero::before {
  height: 1100px;
}
</style>