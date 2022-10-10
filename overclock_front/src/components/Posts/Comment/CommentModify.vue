<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <form class="form-floating input-form9 " @submit.prevent>
      <h5 class="mt-4">댓글 수정</h5>
      <div class="form-group">
          <label>내용</label>
          <textarea class ="form-control" v-model="state.content" rows="5" name="content"></textarea>
      </div>
      <button class="btn btn-primary btn7" @click="modify" style="margin: 10px;">등록</button>
      <button class="btn btn-primary btn7" @click="deleted" style="margin: 10px;">삭제</button>
</form>
</section>
</template>

<script>
import axios from "axios";
import { reactive } from "vue";

export default {
  name: "WritePage",
  setup() {
      const id = new URLSearchParams(window.location.search).get("id")

      const state = reactive({
          id: id,
          content: '',
      })
      const modify = async() => {
          const url = '/api/cModify/send'
          const headers = {
          "Content-Type" : "application/json"
          }
          const body= {
              id: state.id,
              content: state.content
          }
      
          await axios.post(url, body, {headers} ).then((res) => {
            state.id  = res;
          })
      }
      const deleted = async() => {
          const url = '/api/cDelete'
          const headers = {
          "Content-Type" : "application/json"
          }
          const body= {
              id: state.id,
              content: state.content
          }
          console.log(state.id)
          console.log(typeof(state.id))
          await axios.post(url, body, {headers} )
      }
      return { state, modify, deleted }
  },
};
</script>

<style scoped>
.input-form9 {
  text-align: center;
  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
}


</style>
