var spawn = require('child_process').spawn;

describe('the app', function() {
    var be;
    beforeEach(function(done) {
        console.log('LAUNCHING THE APP');
        be = spawn('java', ['-jar', '../be/build/libs/be-1.0.jar']);
        var output = '';
        var started = false;
        be.stdout.on('data', function(data) {
            if(!started) {
                output += data;
                if(output.indexOf('Started App in') > -1) {
                    console.log('THE APP SEEMS TO BE UP!');
                    started = true;
                    done();
                }
            }
        });
    });

    afterEach(function(done) {
        be.on('exit', function(code, signal) {
            console.log('THE APP HAS FINISHED WITH CODE ' + code + ', SIGNAL ' + signal);
            be = null;

            done();
        });

        console.log('TERMINATING THE APP');
        be.kill();
    });

    it('should load when I go to /', function() {
        browser.get('/');
        expect(browser.getLocationAbsUrl()).toBe('/');
    });

    describe('when I am there', function() {
        beforeEach(function() {
            browser.get('/');
        });

        it('should let me add the numbers', function() {
            expect(element(by.model('a')).getAttribute('value')).toBe('2');
            expect(element(by.model('b')).getAttribute('value')).toBe('3');

            element(by.model('a')).clear();
            element(by.model('a')).sendKeys('222');

            element(by.model('b')).clear();
            element(by.model('b')).sendKeys('333');

            expect(element(by.model('a')).getAttribute('value')).toBe('222');
            expect(element(by.model('b')).getAttribute('value')).toBe('333');

            element(by.css('button')).click();

            expect(element(by.css('.alert')).getText()).toBe('Hurray! The result is 555.');
        });
    });
});
