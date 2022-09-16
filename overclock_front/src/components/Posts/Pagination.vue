<template>
  <div>
    <ul class="pagination h-20 justify-content-center align-items-center">
      <li class="page-item " >
        <a href="#" class="page-link" tabindex="-1" @click="onPageChange(page - 1)">Previous</a>
      </li>
      <li :class="pg==page?'page-item active':'page-item '" v-for="(pg, i) in pageList" :key="(pg, i)">
        <a href="#" class="page-link" @click="onPageChange(pg)">{{pg}}</a>
      </li>
      <li class="page-item ">
        <a href="#" class="page-link" @click="onPageChange(page + 1)">Next</a>
      </li>
    </ul>
  </div>
</template>

<script>
import { computed } from 'vue'
import { useStore } from 'vuex'

export default {
  name: 'ThePagination',
  props: ['page','prev','next','start','end','pageList','totalPage'],
  setup(){
    const store = useStore()
    const counter = computed(function() {return store.state.counter})
    const inc = function(){store.commit("setCounter", counter.value + 1)}
    const onPageChange = (val) => {store.dispatch('handleGetPageList', val)}
    return { counter, inc, onPageChange }
  },
  data(){return {message: 'Pagination'}}
}
</script>

<style>
  .page-item{width: 50px;}
  .page-item:first-child{width: 80px;}
  .page-item:last-child{width: 80px;}
</style>
