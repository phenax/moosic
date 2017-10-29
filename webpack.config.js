
const webpack = require('webpack');
const path = require('path');
const fs = require('fs');

const SOURCE_DIR = path.resolve('./src/main/client/js');
const BUILD_DIR = path.resolve('./src/main/public/js');

const _js = filename => path.join(SOURCE_DIR, filename + '.js');

const webpackConfig= {

	target: 'web',

	entry: {
		script: [ _js('main') ],
		// serviceworker: [ _js('serviceworker') ],
		// ssr: [ _js('ssr') ],
	},

	output: {
		path: BUILD_DIR,
		filename: '[name].js',
		publicPath: '/js/',
	},

	resolve: {
		extensions: ['.js', '.vue'],
	},

	module: {
		loaders: [
			{
				test: /\.vue$/,
				loader: 'vue-loader'
			},
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: /node_modules/
			},
			{
				test: /\.s[a|c]ss$/,
				loader: 'style-loader!css-loader!sass-loader'
			}
		]
	},

	devtool: 'source-map',

	plugins: [
		new webpack.LoaderOptionsPlugin({
			options: {
				vue: {
					loaders: {
						scss: 'style-loader!css-loader!sass-loader'
					}
				},
			}
		}),
		// new webpack.ProvidePlugin({
		// 	'Promise': 'es6-promise',
		// 	'fetch': 'imports?this=>global!exports?global.fetch!whatwg-fetch'
		// }),
		// function() {
		// 	this.plugin('done', function(stats) {

		// 		const assets = stats.toJson().assets.filter(f => /\.js$/.test(f.name));

		// 		const bundleStats = {
		// 			assets
		// 		};

		// 		fs.writeFileSync(
		// 			path.join(__dirname, 'client', 'bundle-stats.json'),
		// 			JSON.stringify(bundleStats)
		// 		);
		// 	});
		// },
	],
};


// For production builds
if(process.argv.indexOf('-p') !== -1) {

	webpackConfig.plugins.push(
		new webpack.optimize.UglifyJsPlugin()
	);

	webpackConfig.plugins.push(
		new webpack.DefinePlugin({
			'process.env': {
				NODE_ENV: '"production"'
			}
		})
	);

	webpackConfig.devtool= false;
} else {
	webpackConfig.plugins.push(
		new webpack.DefinePlugin({
			'process.env': {
				NODE_ENV: '"development"'
			}
		})
	);
}

module.exports= webpackConfig;
