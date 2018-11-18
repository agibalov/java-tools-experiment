package me.loki2302;

import com.puppycrawl.tools.checkstyle.api.*;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ClassCountCheck extends AbstractFileSetCheck {
    @Override
    protected void processFiltered(File file, List<String> lines) throws CheckstyleException {
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        try {
            javaProjectBuilder.addSource(file);
        } catch (IOException e) {
            throw new CheckstyleException("Can't load " + file.getAbsolutePath(), e);
        }

        Collection<JavaClass> javaClasses = javaProjectBuilder.getClasses();
        if(javaClasses.size() > 1) {
            log(0, String.format("Really? %d classes in a single file?", javaClasses.size()));
        }
    }
}
