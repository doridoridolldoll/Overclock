<template>
  <MyModal ref="baseModal">
    <div class="content-container">
      <form class="validation-form" @submit.prevent>
        <span class="answer text-center" id="answerForRecovery1">비밀번호 확인</span>
        <div class="mb-3">
          <label for="password">비밀번호</label>
          <input type="password" class="form-control" v-model="state.password" id="password" required>
          <div class="invalid-feedback">
            비밀번호를 입력해주세요.
          </div>
        </div>
      </form>
    </div>
    <div class="buttons-container">

      <button class="btn btn-primary mr-2" @click="check">수정</button>
      <button class="btn btn-warning" @click="cancel">취소</button>

    </div>
  </MyModal>
</template>
  
<script>
import MyModal from "./MyModal.vue";
import { reactive, ref } from "vue";
import axios from "axios";
import store from "@/store";
import router from "@/router";

  
export default {
  name: "ProfileModal",
  components: {
    MyModal,
  },
  // 렌더링할 텍스트를 가져옵니다.
  props: {
  },
  setup() {

    const state = reactive({
      id : store.state.id,
      password : "",
    })
    // 자식 컴포넌트를 핸들링하기 위한 ref
    const baseModal = ref(null);
    // Promise 객체를 핸들링하기 위한 ref
    const resolvePromise = ref(null);

    const show = () => {
      // baseModal을 직접 컨트롤합니다.
      baseModal.value.open();
      // Promise 객체를 사용하여, 현재 모달에서 확인 / 취소의
      // 응답이 돌아가기 전까지 작업을 기다리게 할 수 있습니다.
      return new Promise((resolve) => {
        // resolve 함수를 담아 외부에서 사용합니다.
        resolvePromise.value = resolve;
      });
    };

    const confirm = () => {
      baseModal.value.close();
      resolvePromise.value(true);
    };

    const cancel = () => {
      baseModal.value.close();
      resolvePromise.value(false);
    };
    
    const check = async() => {
      if (state.password === '') {
      alert('비밀번호를 입력해주세요');
      state.password.value.focus();
      return false;
      } 
      const url = '/api/passCheck'
      const headers = {
        "Content-Type": "application/json",
      }
      const body = { 
        id : state.id,
        password: state.password
      };
      console.log("==========================================");
      console.log(state.password);
      axios.post(url, body, { headers }).then(function (res) {
        console.log(res);
        if (res.data === false) {
          alert("비밀번호가 일치하지 않습니다.")
          return false;
        } else (res.data === true)
          alert("비밀번호가 일치합니다.")
          router.push({ name: "ProfileChange" })
          });
        }
    return { baseModal, show, confirm, cancel, state, check };
  }
};
</script>
<style scoped>
.buttons-container{
  text-align: center;
}
.btn-primary{
  margin-right: 10px;
}
.validation-form{
  text-align: center;
}
.modal-container{
  border-radius: 10px;
}
</style>