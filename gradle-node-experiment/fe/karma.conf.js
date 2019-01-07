module.exports = function(config) {
  var c = {
    basePath: './',
    files: [
      'bower_components/angular/angular.js',
      'bower_components/angular-route/angular-route.js',
      'bower_components/angular-mocks/angular-mocks.js',
      'src/main/web/**/*.js',
      'src/main/web/**/*.html',
      'src/test/web/**/*.spec.js'
    ],
    preprocessors: {
      'src/main/web/**/*.html': ['ng-html2js']
    },
    autowatch: true,
    frameworks: ['jasmine'],
    plugins: [
      'karma-chrome-launcher',
      'karma-firefox-launcher',
      'karma-jasmine',
      'karma-ng-html2js-preprocessor'
    ],
    ngHtml2JsPreprocessor: {
      stripPrefix: 'src/main/web/',
      moduleName: 'app.templates'
    }
  };

  if(process.env.TRAVIS) {
    c.browsers = ['Firefox'];
  } else {
    c.browsers = ['Firefox', 'Chrome'];
  }

  config.set(c);
};
