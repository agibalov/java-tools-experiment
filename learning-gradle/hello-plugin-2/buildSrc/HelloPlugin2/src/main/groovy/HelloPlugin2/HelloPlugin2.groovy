package HelloPlugin2

import org.gradle.api.*

class HelloPlugin2 implements Plugin<Project> {
    void apply(Project project) {
        def messages = project.container(String)
        project.extensions.create("greeting", HelloPluginExtension)
        project.extensions.greeting.messages = messages

        project.task('hi') << {
            println "HelloPlugin says '${project.greeting.hi}'!"
        }

        project.task('bye') << {
            println "HelloPlugin says '${project.greeting.bye}'!"
        }

        project.task('printMessages') << {
            project.greeting.messages.each { m ->
                println "message: $m"
            }
        }
    }
}

class HelloPluginExtension {
    String hi = "default hi message"
    String bye = "default bye message"
    def messages;
}

class Message {
    final String name
    String message

    Message(String name) {
        this.name = name
    }
}
