import Vue from "vue";
import App from "./App.vue";
import "element-ui/lib/theme-chalk/index.css";
import "./plugins/element.js";
import "./plugins/axios.js";
import router from "./router/router.js"; //引入路由JS
import "./style/theme.css"; //自己写的样式
import "./style/characters.css"; //自己写的样式
Vue.config.productionTip = false;




new Vue({
    router: router,
    render: h => h(App)
}).$mount("#app");
