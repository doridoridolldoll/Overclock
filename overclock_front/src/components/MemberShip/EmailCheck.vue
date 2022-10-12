<template>

  <form class="d-flex flex-column" action="login" method="post">

    <span class="answer text-center" i-d-b-database="answerForRecovery1"></span>
    {{state.ok}}
    <input class="form-control" type="text" placeholder="인증번호" ref="keyInput" v-model="state.keyInput" v-if="state.change==1"/>
<hr>
    <div class="px-5 my-4">
      <button type="button" class="btn btn-outline-primary w-100" @click="certify()" v-if="state.change==1" value="title" @input="$emit('titleFromChild', $event)">인증</button>
    </div>
  </form>
</template>
<script>
import store from '@/store';
import { reactive, ref } from '@vue/reactivity'
export default {
  name: 'EmailCheck',
  props: ["keys","email"],
  setup(props) {
 
    const state = reactive({
      keys: props.keys,
      keyInput: "",
      change: 1,
      ok: null,
      title:{type :String, required : true}
    })
    console.log(state.keys);
    
    const keyInput = ref('')

    const certify = async () => {
      console.log(state.keyInput);
      if (state.keyInput === '') {
        alert('인증번호를 입력해주세요.');
        keyInput.value.focus();
        return false;
      } else if (state.keyInput !== props.keys) {
        alert('인증번호가 일치하지 않습니다.')
        state.keyInput = null;
        keyInput.value.focus();
        return false;
      } else {
        alert('인증되었습니다.')
        state.change = 0;
        state.ok = "이메일 인증 완료";
        
        store.commit("setEmail", props.email )
      }
    }
    return { certify, state, ref, keyInput }
  }
}

</script>