<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container2" data-aos="fade-up">

      <div class="container">
        <div class="input-form2 col-md-12 mx-auto">
          <h4 class="mb-3">내정보</h4>
          <form class="validation-form" @submit.prevent>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="nickname">닉네임</label>
                <input type="text" class="form-control" v-model="state.nickname" id="nickname">
                <div class="invalid-feedback">
                </div>
              </div>
              <button @click="change">내 정보 수정</button>
            </div>
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
import store from '@/store'
export default {
  name: 'profileChange',
  props: ["email"],
  setup() {
    const state = reactive({
      id: store.state.id,
      nickname: "",
    })
    const nickname = ref('');
    const change = async () => {
      const headers = {
        "Content-Type": "application/json",
      }
      const body = {
        id: state.id,
        nickname: state.nickname
      }
      if (state.nickname === '') {
        alert("닉네임을 입력해주세요")
        return false;
      }
      console.log(state.nickname);
      const url = '/api/profileChange'
      const response = await axios.post(url, body, { headers })
      if (response.status === 200) {
        alert('닉네임이 변경되었습니다.');
      } else {
        alert('닉네임 변경에 실패했습니다.')
      }
      router.push({ name: "Main" })
    }
    return { change, state }
  }
}

</script>
<style>
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