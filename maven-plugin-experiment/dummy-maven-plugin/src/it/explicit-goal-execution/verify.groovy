String buildLog = new File("${basedir}/build.log").text
assert buildLog.contains('Hello world!')
assert buildLog.contains('mojoExecution.lifecyclePhase=null')
assert buildLog.contains('project.name=dummy-maven-plugin-tester')
assert buildLog =~ /project\.build\.directory=\/.+\/target\/its\/explicit-goal-execution\/target/
