var webpack = require('webpack');

module.exports = {
		entry: {
			app: './scripts/app.js',
			vendor: ['angular', 'angular-route']
		},
		output: {
			filename: './scripts/bundle.js'
		},
		plugins: [
		          new webpack.optimize
		          .CommonsChunkPlugin('vendor', './scripts/bundle.vendor.js')
		],
		devtool: 'source-map'
}