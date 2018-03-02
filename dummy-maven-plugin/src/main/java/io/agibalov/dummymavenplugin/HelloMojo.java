package io.agibalov.dummymavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

@Mojo(name = "hello", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class HelloMojo extends AbstractMojo {
    @Parameter(defaultValue = "${mojoExecution}", readonly = true)
    private MojoExecution mojoExecution;

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter(defaultValue = "${project.build.directory}", readonly = true)
    private File projectBuildDirectory;

    @Parameter(property = "who", defaultValue = "world", required = false)
    private String who;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(String.format("Hello %s!", who));
        getLog().info(String.format("mojoExecution.lifecyclePhase=%s", mojoExecution.getLifecyclePhase()));
        getLog().info(String.format("project.name=%s", project.getName()));
        getLog().info(String.format("project.build.directory=%s", projectBuildDirectory));
    }
}
