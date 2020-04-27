# sso

* oss 前端内容

## 启动

* npm run serve

# 添加饿了么组件

安装：`vue add element`

## 配置
* 主要配置组件和css
```js
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'
```
* 注册
```js
// 注册element-ui
Vue.use(ElementUI)
```

# 路由添加

安装：`npm install vue-router --save`

* 添加到vue 中
```js
import router from './router'

new Vue({
  router:router,
  render: h => h(App),
}).$mount('#app')

```