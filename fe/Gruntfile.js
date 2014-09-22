module.exports = function(grunt) {

    grunt.initConfig({
        builddir: "src/main/resources/resources",
        uglify: {
            app: {
                src: "src/main/web/**/*.js",
                dest: "<%= builddir %>/all.js"
            }
        },
        concat: {
            angular: {
                src: [
                    "bower_components/angular/angular.min.js",
                    "bower_components/angular-route/angular-route.min.js"
                ],
                dest: "<%= builddir %>/angular.js"
            }
        },
        copy: {
            app: {
                expand: true,
                flatten: true,
                src: "src/main/web/**/*.html",
                dest: "<%= builddir %>/"
            },
            bootstrap: {
                expand: true,
                flatten: true,
                src: "bower_components/bootstrap/dist/css/bootstrap.min.css",
                dest: "<%= builddir %>/"
            }
        },
        clean: [ "<%= builddir %>" ]
    });

    grunt.loadNpmTasks("grunt-contrib-uglify");
    grunt.loadNpmTasks("grunt-contrib-copy");
    grunt.loadNpmTasks("grunt-contrib-concat");
    grunt.loadNpmTasks("grunt-contrib-clean");
    grunt.registerTask("build", ["uglify", "copy", "concat"]);

};