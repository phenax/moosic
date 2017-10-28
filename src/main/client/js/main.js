
import Vue from 'vue';
import VueRouter from 'vue-router';

import App from './App.vue';

Vue.use(VueRouter)

// Initialize the application
const app = new Vue({
	components: { App }
}).$mount('#applicationHook');

