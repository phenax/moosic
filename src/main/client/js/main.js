
import Vue from 'vue'
import { sync } from 'vuex-router-sync'

import RootApp from './App.vue'

import router from './routes'
import store from './store'

sync(store, router)

// Initialize the application
const app = new Vue({
	router,
	store,
	render: h => h(RootApp),
})

// Mount to hook
app.$mount('#applicationHook')

