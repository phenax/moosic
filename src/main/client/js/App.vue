
<style lang="scss" scoped>

$cool: #51e980;
.cool {
	.cool {
		color: $cool;
	}
}

</style>

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

export default {
	name: 'moo-app',
	data() {
		return {
			message: 'Message'
		};
	}
};

</script>

