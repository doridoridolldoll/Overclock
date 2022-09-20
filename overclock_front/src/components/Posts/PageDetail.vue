<template>
        <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="board-detail">
      <div class="common-buttons">
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnUpdate">수정</button>&nbsp;
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnDelete">삭제</button>&nbsp;
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnList">목록</button>
      </div>
      <div class="board-contents">
        <h3>{{ title }}</h3>
        <div>
          <strong class="w3-large">{{ member_id }}</strong>
          <br>
          <span>{{ reg_date }}</span>
        </div>
      </div>
      <div class="board-contents">
        <span>{{ content }}</span>
      </div>
      <div class="common-buttons">
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnUpdate">수정</button>&nbsp;
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnDelete">삭제</button>&nbsp;
        <button type="button" class="w3-button w3-round form-floating" v-on:click="fnList">목록</button>
      </div>
    </div>
    </section>
  </template>
  
  <script>
  import {reactive } from '@vue/reactivity'
  export default {
    name: 'ToDetail',
    setup(){
  const state = reactive({

    title       :'',
    member_id   :'',
    reg_date    :'',
    content     :'',

  })


    }
  }
  </script>
  <style scoped>
  
  
  </style>