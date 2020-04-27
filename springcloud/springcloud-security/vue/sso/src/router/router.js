import Vue from "vue"; //导入vue
import VueRouter from "vue-router";
import Login from "../components/login/login.vue"; //引入组件



Vue.use(VueRouter); //配置插件
// 配置路由
const routes = [
    {
        path: "/login",
        component: Login,
        name: "login"
    }
];
// 创建 router 实例，然后传 `routes` 配置'
export default new VueRouter({
    routes, // (缩写) 相当于 routes: routes
    mode: "history"
});
