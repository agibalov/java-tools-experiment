String buildLog = new File("${basedir}/build.log").text
assert buildLog.contains('Hello DEAR USER!')
assert buildLog.contains('mojoExecution.lifecyclePhase=null')
assert buildLog.contains('project.name=dummy-maven-plugin-tester')
assert buildLog =~ /project\.build\.directory=\/.+\/target\/its\/explicit-goal-execution-config\/target/
