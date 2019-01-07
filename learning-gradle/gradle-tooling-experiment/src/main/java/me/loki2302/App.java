package me.loki2302;

import org.gradle.tooling.BuildLauncher;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;

public class App {
    public static void main(String[] args) {

        GradleConnector gradleConnector = GradleConnector.newConnector();
        gradleConnector.forProjectDirectory(new File("."));

        ProjectConnection projectConnection = gradleConnector.connect();
        try {
            BuildLauncher buildLauncher = projectConnection.newBuild();
            buildLauncher.forTasks("hello");
            buildLauncher.setStandardOutput(System.out);
            buildLauncher.setStandardError(System.err);

            buildLauncher.run();
        } finally {
            projectConnection.close();
        }

    }
}
