
// TODO: Last optimization for the future maybe

global.window = global;


import vueAppRoot from './app';

import vueSsr from 'vue-server-renderer';
const renderer = vueSsr.createRenderer()

console.log(renderer);

// TODO: Find a way to return it
global.renderSsr = () => {
	renderer.renderToString(vueAppRoot, (err, html) => {
		if (err) throw err;
		console.log(html);
	});
};

global.renderSsr();
