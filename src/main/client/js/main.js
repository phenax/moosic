
import Vue from 'vue';

import router from './libs/router';
import RootApp from './App.vue';


// Initialize the application
const app = new Vue({
	router,
	render: h => h(RootApp),
});

// Mount to hook
app.$mount('#applicationHook');

