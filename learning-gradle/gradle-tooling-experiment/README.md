# The Gradle Tooling API hello world

There's a `src/build.gradle` with a single task `hello`. Running the `./gradlew clean distZip` will build a distribution package that includes:

* That `build.gradle` from `src`
* Gradle Tooling libraries
* A .sh file

When running that .sh file, the app will use Gradle Tooling to run the `hello` task found in `build.gradle`.
