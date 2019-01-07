# dummy-maven-plugin-tester

```
mvn clean dummy:hello

[INFO] --- dummy-maven-plugin:1.0-SNAPSHOT:hello (default-cli) @ dummy-maven-plugin-tester ---
[INFO] Hello world!
[INFO] mojoExecution.lifecyclePhase=null
[INFO] project.name=dummy-maven-plugin-tester
[INFO] project.build.directory=/home/loki2302/dummy-maven-plugin-tester/target
```

```
mvn clean dummy:hello -P custom-name

[INFO] --- dummy-maven-plugin:1.0-SNAPSHOT:hello (default-cli) @ dummy-maven-plugin-tester ---
[INFO] Hello DEAR USER!
[INFO] mojoExecution.lifecyclePhase=null
[INFO] project.name=dummy-maven-plugin-tester
[INFO] project.build.directory=/home/loki2302/dummy-maven-plugin-tester/target
```
