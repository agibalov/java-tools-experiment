gradle-node-experiment [![Build Status](https://travis-ci.org/loki2302/gradle-node-experiment.svg?branch=master)](https://travis-ci.org/loki2302/gradle-node-experiment)
======================

A PoC Spring Boot web app that has its front end part built using Node/Bower/Grunt.

`./gradlew clean build` and `./gradlew clean`.

In some cases it may require that you do `export npm_config_cache=/home/loki2302/xxx` before running. I didn't manage to find out what the problem is, and if it's possible to fix it without `export`.

To run e2e-tests: `./gradlew clean e2e`.
