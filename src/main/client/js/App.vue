
<template>
	<div id='appRoot'>
		<div>
			<div>Yo {{message}}</div>
		</div>

		<router-link to="/">Go to Foo</router-link>
		<router-link to="/bar">Go to Bar</router-link>

		<router-view></router-view>
	</div>
</template>

<script>

import VueRouter from 'vue-router';

const TestComponent = { template: '<div>Wpooooooo</div>' };
const NoComponent = { template: '<div>404</div>' };

export default {
	router: new VueRouter({
		mode: 'history',
		routes: [
			{ path: '/', component: TestComponent },
			{ path: '*', component: NoComponent },
		],
	}),
	data() {
		return {
			message: 'Message'
		};
	}
}

</script>

<style lang="scss" scoped>
	$cool: #51e980;
	.cool {
		.cool {
			color: $cool;
		}
	}
</style>
