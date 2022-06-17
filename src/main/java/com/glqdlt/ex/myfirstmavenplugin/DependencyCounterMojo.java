package com.glqdlt.ex.myfirstmavenplugin;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author glqdlt
 */
@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class DependencyCounterMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Parameter(property = "in")
    String origin;

    @Parameter(property = "out")
    String output;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencies = project.getDependencies();
        getLog().info("Copy Start");

        try {
            Files.copy(Paths.get(origin), Paths.get(output));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getLog().info("Copy Compelete");
    }
}
