process.env.CHROME_BIN = require('puppeteer').executablePath()

module.exports = function (config) {
	'use strict';
    config.set({
		basePath: '',
        frameworks: ['mocha', 'chai'],
        files: [
            './src/main/resources/static/js/*.js',
            './src/test/javascript/*.js',
        ],
		preprocessors: {
			'./src/main/resources/static/js/*.js': [ 'coverage' ],
			'./src/test/javascript/*.js': [ 'coverage' ],
		},
		babelPreprocessor: {
			options: {
				"presets": ["env"],
			},
		},
        reporters: ['coverage', 'progress'],
        port: 9876,  // karma web server port
        colors: true,
        logLevel: config.LOG_INFO,
        browsers: ['Chrome'],
        autoWatch: true,
		browserNoActivityTimeout: 2000,
		singleRun: false,
        concurrency: Infinity,
		coverageReporter: {
		  dir: 'coverage',
		  reporters: [
			{
			  type: 'json',
			  subdir: '.',
			  file: 'coverage.json'
			},
			{
			  type: 'html',
			  subdir: 'report-html'
			},
		  ],
		},
    });
}