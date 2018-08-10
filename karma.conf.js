<<<<<<< HEAD
// Karma configuration
// Generated on Thu Aug 09 2018 09:37:39 GMT-0400 (Eastern Daylight Time)

module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['requirejs', 'mocha', 'chai'],


    // list of files / patterns to load in the browser
    files: [
      { pattern: './src/main/resources/static/js/*.js', included: true },
      { pattern: './src/test/javascript/*.js', included: true },
	  
	  'test-main.js',
    ],


    // list of files / patterns to exclude
    exclude: [
    ],
	
	browserNoActivityTimeout: 100000,


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser should be started simultaneous
    concurrency: Infinity,
			customLaunchers: {
            FirefoxHeadless: {
                base: 'Firefox',
                flags: ['-headless'],
            },
	},
  })
}
=======
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
>>>>>>> master
