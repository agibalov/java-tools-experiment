module.exports = function(grunt) {
    grunt.initConfig({
        srcDir: 'src/main/web',
        bowerComponentsDir: 'bower_components',
        distDir: 'dist/resources',
        tmpBuildDir: 'tmp',

        templatesJsFile: '<%= tmpBuildDir %>/templates.js',
        ngtemplates: {
            all: {
                src: ['<%= srcDir %>/**/*.html', '!**/index.html'],
                dest: '<%= templatesJsFile %>',
                options: {
                    module: 'app.templates',
                    standalone: true,
                    url: function(url) {
                        return url.replace('src/main/web/', '');
                    }
                }
            }
        },

        amalgamatedJsFile: '<%= distDir %>/app.js',
        uglify: {
            all: {
                src: [
                    '<%= bowerComponentsDir %>/angular/angular.min.js',
                    '<%= bowerComponentsDir %>/angular-route/angular-route.min.js',
                    '<%= templatesJsFile %>',
                    '<%= srcDir %>/**/*.js'
                ],
                dest: '<%= amalgamatedJsFile %>'
            }
        },

        amalgamatedCssFile: '<%= distDir %>/app.css',
        cssmin: {
            all: {
                files: {
                    '<%= amalgamatedCssFile %>': [
                        '<%= bowerComponentsDir %>/bootstrap/dist/css/bootstrap.min.css',
                        '<%= bowerComponentsDir %>/angular/angular-csp.css'
                    ]
                }
            }
        },

        copy: {
            indexHtml: {
                expand: true,
                flatten: true,
                src: '<%= srcDir %>/index.html',
                dest: '<%= distDir %>'
            }
        },

        karma: {
            options: {
                configFile: 'karma.conf.js'
            },
            runOnce: {
                singleRun: true
            },
            watch: {
                singleRun: false
            }
        },

        clean: {
            dist: ['<%= distDir %>'],
            tmp: ['<%= tmpBuildDir %>']
        }
    });

    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-angular-templates');
    grunt.loadNpmTasks('grunt-karma');

    grunt.registerTask('build', ['clean:dist', 'ngtemplates', 'copy', 'uglify', 'cssmin', 'clean:tmp']);
    grunt.registerTask('test', ['karma:runOnce']);
    grunt.registerTask('watch', ['karma:watch']);
};
