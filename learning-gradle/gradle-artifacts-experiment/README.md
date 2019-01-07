# gradle-artifacts-experiment

Learning how artifacts and dependencies work in Gradle.

* `:chapter1` exposes artifacts `page1.txt` and `page2.txt`
* `:chapter2` exposes artifacts `page3.txt` and `page4.txt`
* `root` depends on `:chapter1` and `:chapter2` - it takes all dependency contents and puts them into a Zip archive.

Run `./gradlew book` and then see `build/book.zip`
