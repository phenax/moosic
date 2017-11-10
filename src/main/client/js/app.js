
import Vue from 'vue';
import { sync } from 'vuex-router-sync';

import RootApp from './App.vue';

import router from './routes/routes.js';
import store from './store/store.js';

sync(store, router);

// Initialize the application
export default new Vue({
	router,
	store,
	...RootApp,
});
