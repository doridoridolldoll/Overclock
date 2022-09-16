import { createApp } from 'vue'
import App from './App.vue'
import '@/assets/css/style.css' 
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue-icons.css";
import router from './router'

import "bootstrap";
createApp(App).use(router).mount('#app')
