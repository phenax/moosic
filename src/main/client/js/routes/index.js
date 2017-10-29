
import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

import HomePage from '../pages/HomePage.vue'
const NoComponent = Vue.component('moo-error', { render: h => h('div', '404') })

export default new VueRouter({
	mode: 'history',
	routes: [
		{ path: '/', component: HomePage },
		{ path: '*', component: NoComponent },
	],
})

