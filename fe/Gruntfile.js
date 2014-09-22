module.exports = function(grunt) {

    grunt.initConfig({
        builddir: "src/main/resources/resources",
        copy: {
            bootstrap: {
                expand: true,
                flatten: true,
                src: "bower_components/bootstrap/dist/css/bootstrap.min.css",
                dest: "<%= builddir %>/"
            }
        },
        clean: [ "<%= builddir %>" ]
    });

    grunt.loadNpmTasks("grunt-contrib-copy");
    grunt.loadNpmTasks("grunt-contrib-clean");
    grunt.registerTask("build", ["copy"]);

};