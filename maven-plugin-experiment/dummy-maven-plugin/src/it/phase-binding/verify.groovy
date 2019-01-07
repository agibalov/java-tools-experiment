String buildLog = new File("${basedir}/build.log").text
assert buildLog.contains('Hello world!')
assert buildLog.contains('mojoExecution.lifecyclePhase=generate-resources')
assert buildLog.contains('project.name=dummy-maven-plugin-tester')
assert buildLog =~ /project\.build\.directory=\/.+\/target\/its\/phase-binding\/target/
