1. Run `./gradlew clean app:bootRepackage` to get the app built with features A and B
2. Run `./gradlew clean app:bootRepackage -PwithoutA` to get the app built without A, but with B
3. Run `./gradlew clean app:bootRepackage -PwithoutB` to get the app built without B, but with A
4. Run `./gradlew clean app:bootRepackage -PwithoutA -PwithoutB` to the the app build without A and B
