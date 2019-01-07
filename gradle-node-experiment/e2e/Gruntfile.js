module.exports = function(grunt) {
  grunt.initConfig({
    shell: {
      webDriver: {
        options: {
          stdout: true
        },
        command: require('path')
          .resolve('node_modules/protractor/bin/webdriver-manager') + ' update'
      }
    },
    protractor_webdriver: {
      options: {
        keepAlive: true
      },
      dummy: {}
    },
    protractor: {
      options: {
        configFile: 'protractor.conf.js'
      },
      all: {}
    }
  });

  grunt.loadNpmTasks('grunt-shell');
  grunt.loadNpmTasks('grunt-protractor-webdriver');
  grunt.loadNpmTasks('grunt-protractor-runner');

  grunt.registerTask('webdriver-update', 'Install/update WebDriver', ['shell:webDriver']);
  grunt.registerTask('e2e-test', 'Run E2E tests', ['protractor_webdriver:dummy', 'protractor:all']);
};
