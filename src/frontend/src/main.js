import Vue from 'vue'
import App from './App.vue'
import {BootstrapVue, BootstrapVueIcons, IconsPlugin} from "bootstrap-vue";
import VueRouter from "vue-router";
import AppointmentTable from "@/components/AppointmentTable";
import CliendsView from "@/components/CliendsView";

Vue.config.productionTip = false

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.use(IconsPlugin);
Vue.use(VueRouter);
const router = new VueRouter({
    mode: 'history',
    base: __dirname,
    routes: [
        {path: '/clients', component: CliendsView},
        {path: "/", component: AppointmentTable}


    ]
});

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';


new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
