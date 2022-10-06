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
                <input type="text" class="form-control readonly" v-model="state.name" id="name" readonly>
                <div class="invalid-feedback">
                  이름을 입력해주세요.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="nickname">닉네임</label>
                <input type="text" class="form-control" v-model="state.nickname" id="nickname" required>
                <div class="invalid-feedback">
                  닉네임을 입력해주세요.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="email">이메일</label>
              <input type="email" class="form-control readonly" v-model="state.email" id="email" readonly>
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
            </div>

            <button class="btn btn-primary btn-lg btn-block" @click="modify">수정하기</button>
          </form>
        </div>
      </div>
    </div>
  </section>

</template>

<script>
import { reactive } from '@vue/reactivity'
import axios from 'axios'
import router from '@/router'
import { useStore } from 'vuex'
export default {
  name: 'ToProfil',
  setup() {
    const store = useStore();
    const state = reactive({
      id: store.state.dtoList.id,
      email: store.state.email,
      nickname: '',
      password: '',
      repassword: '',
      name: '',
      phone: '',
      city: '',
      street: '',
      zipcode: '',
    })
    const headers = {
      "Content-Type": "application/json",
    }
    const body = {
      id: store.state.id,
      email: state.email,
      nickname: state.nickname,
      password: state.password,
      repassword: state.repassword,
      name: state.name,
      mobile: state.mobile,
      city: state.city,
      street: state.street,
      zipcode: state.zipcode,
    }
    axios.post("/api/mList", body, { headers }).then(function (res) {
      state.id = res.data[0].id
      state.name = res.data[0].name
      state.email = res.data[0].email
      state.nickname = res.data[0].nickname
      state.mobile = res.data[0].mobile
      state.city = res.data[0].city
      state.street = res.data[0].street
      state.zipcode = res.data[0].zipcode
      console.log(res.data)
      console.log(state.phone)
      console.log(state.city)
    })
    const modify = async () => {
      const url = '/api/mModify/send'
      const headers = {
        "Content-Type": "application/json"
      }
      const body = {
        id : state.id,
        nickname : state.nickname,
        password : state.password,
        phone : state.mobile
      }
      const response = await axios.post(url, body, { headers })
      if (response.status === 200) {
        alert('회원정보가 수정되었습니다.');
      } else {
        alert('회원가입에 실패하였습니다.')
      }
      router.push({ name: "Profil" });
    }
    return { modify, state }
  }
}
</script>

<style scoped>
.container2 {
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

.readonly {
  background-color: #cfd6d6;
}
</style>