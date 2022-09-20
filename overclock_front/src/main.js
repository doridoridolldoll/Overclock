import { createApp } from 'vue'
import App from './App.vue'
import '@/assets/css/style.css' 
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue-icons.css";
import CKEditor from "@ckeditor/ckeditor5-vue";
import "@ckeditor/ckeditor5-build-classic/build/translations/ko";
import router from './router'

import "bootstrap";
createApp(App).use(router).use(CKEditor).mount('#app')
