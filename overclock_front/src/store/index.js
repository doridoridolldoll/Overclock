// store/index.js
import { createStore } from 'vuex'
import VuexPersistence from 'vuex-persist'

const vuexLocal = new VuexPersistence({
  storage: window.localStorage,
  key: "TOKEN",

  });

export default createStore({
  state: {
    token: 0,
    email: 0,
    id: 0,
    axiosLink:".",
  },
  getters: {
    
  },
  mutations: {
    
    setToken(state, payload){
      state.token = payload
    },
    setEmail(state, payload){
      state.email = payload
    },
    setId(state, payload){
      state.id = payload
    }
  },
  actions: {
    
  },
  modules: {

  },
  plugins: [new VuexPersistence().plugin, vuexLocal.plugin]
}
)
