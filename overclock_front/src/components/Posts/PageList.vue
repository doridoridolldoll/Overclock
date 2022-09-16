<template>
  <div>
    <h1>{{ message }} {{ counter }} <button @click="inc">Plus</button> </h1>

    <Table
      :dtoList="state.dtoList"
      :page="state.page"
      :prev="state.prev"
      :next="state.next"
      :start="state.start"
      :end="state.end"
      :pageList="state.pageList"
      :totalPage="state.totalPage"
    />
  </div>
</template>

<script>
import { onMounted } from 'vue'
import { computed } from 'vue'
import { reactive } from '@vue/reactivity'
import { useStore } from 'vuex'
import Table from './Used.vue'

export default {
  name: 'ThePageList',
  components: { Table },
  setup() {
    const store = useStore()
    const counter = computed(function () {
      return store.state.counter
    })
    const inc = function () {
      store.commit('setCounter', counter.value + 1)
    }
    onMounted(() => { 
      store.dispatch('handleGetPageList')
    }) 
    const state = reactive({
      dtoList: computed(function(){return store.state.dtoList}),
      page: computed(function(){return store.state.page}),
      prev: computed(function(){return store.state.prev}),
      next: computed(function(){return store.state.next}),
      start: computed(function(){return store.state.start}),
      end: computed(function(){return store.state.end}),
      pageList: computed(function(){return store.state.pageList}),
      totalPage: computed(function(){return store.state.totalPage})
    })

    return {
      message: 'Page List',state,counter,inc,
    }
  },
  data() {
    return {showModal: false}
  }
}
</script>

<style></style>
