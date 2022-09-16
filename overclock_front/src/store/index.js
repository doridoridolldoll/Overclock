// store/index.js
import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    //데이터 상태를 관리(중앙 집중식)
    counter: 10,
    dtoList: '',
    page: '',
    prev: '',
    next: '',
    start: '',
    end: '',
    pageList: '',
    totalPage: '',
  },
  getters: {
    //동일한 로직을 중앙에서 관리
    time2(state) {
      return state.counter * 2
    },
  },
  mutations: {
    //Vuex의 state 값을 변경하는 로직
    setCounter(state, value) {
      state.counter = value
    },
    setPageData(state, res) {
        console.log(res);
      state.dtoList = res.data.dtoList
      state.page = res.data.page
      state.prev = res.data.prev
      state.next = res.data.next
      state.start = res.data.start
      state.end = res.data.end
      state.pageList = res.data.pageList
      state.totalPage = res.data.totalPage
    },
  },
  actions: {
    async handleGetPageList(context, value) {
      context.state.page = value === '' ? 1 : value
      console.log('>>>' + context.state.page + '<<<')
      const url = '/api/get-page-list'
      const headers = {
        'Content-Type': 'application/json'
      }
      const body = { page: context.state.page }
      await axios.post(url, body, { headers }).then(function (res) {
        console.log(res);
        if (res.status === 200) {
          context.commit('setPageData', res)
        }
      })
    },
  },
})
