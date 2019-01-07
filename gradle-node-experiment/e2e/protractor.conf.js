var multiCapabilities;
if(process.env.TRAVIS) {
  multiCapabilities = [{ browserName: 'firefox' }];
} else {
  multiCapabilities = [{ browserName: 'chrome' }, { browserName: 'firefox' }];
}

module.exports = {
  config: {
    seleniumAddress: 'http://localhost:4444/wd/hub',
    multiCapabilities: multiCapabilities,
    maxSessions: 1,
    suites: {
      all: '*.spec.js'
    },
    baseUrl: 'http://localhost:8080/'
  }
};
