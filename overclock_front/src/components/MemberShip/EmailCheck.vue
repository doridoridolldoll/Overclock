<template>

  <form class="d-flex flex-column" action="login" method="post">
    <span class="answer text-center mt-3" i-d-b-database="answerForRecovery1">인증번호</span>
    <input class="form-control" type="text" placeholder="인증번호" v-model="state.keyInput" />
    <div class="px-5 my-4">
      <button type="button" class="btn btn-outline-primary w-100" @click="certify()">인증</button>
    </div>
  </form>
</template>
<script>
import store from '@/store';
import { reactive } from '@vue/reactivity'
export default {
  name: 'EmailCheck',
  props: ["keys","email"],
  setup(props) {
 
    const state = reactive({
      keys: props.keys,
      keyInput: ""
    })

    const certify = async () => {

      if (state.keysInput === '') {
        alert('인증번호를 입력해주세요.');
        return false;
      } else if (state.keysInput !== state.keys) {
        alert('인증번호가 일치하지 않습니다.')
        return false;
      } else {
        store.commit("setEmail", props.email )
        alert('인증되었습니다.')
      }
    }
    return { certify, state }
  }
}

</script>