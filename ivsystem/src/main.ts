import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/css/global.css'
//导入axios,qs
import qs from 'qs'
import axios from 'axios'

const app = createApp(App)
//挂载axios,qs
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$qs = qs;

app.use(store).use(router).use(ElementPlus).mount('#app')

