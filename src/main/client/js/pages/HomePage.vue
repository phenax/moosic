
<style lang="scss" scoped>

</style>

<template>
	<div>
		<h2>Hello world</h2>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
		</p>
		<div>
			<div>{{ $store.state.count }} {{ count }}</div>
			<button @click="$store.commit('INCREMENT')">+</button>
			<button @click="$store.commit('DECREMENT')">-</button>
		</div>
	</div>
</template>

<script>

export default {
	computed: {
		count() { return this.$store.state.count }, // One example computed way and one directly
	},
}

</script>
