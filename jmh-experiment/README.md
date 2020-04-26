# jmh-experiment

`./gradlew clean jmh` to run the benchmarks.

It looks like `./gradlew clean` is not enough for JMH plugin to understand that it needs to recompile things. Do `./gradlew --stop` and then `./gradlew jmh` to make sure everything gets rebuilt.
