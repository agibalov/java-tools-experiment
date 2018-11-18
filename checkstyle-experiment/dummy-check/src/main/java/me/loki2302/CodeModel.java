package me.loki2302;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeModel {
    private final JavaProjectBuilder javaProjectBuilder;

    public CodeModel(JavaProjectBuilder javaProjectBuilder) {
        this.javaProjectBuilder = javaProjectBuilder;
    }

    public List<DesignViolation> getDesignViolations(File file) {
        List<JavaClass> classes = getControllerClasses(file);

        List<DesignViolation> designViolations = new ArrayList<>();
        for(JavaClass controllerClass : classes) {
            List<JavaField> fieldsOfTypeJpaRepository =
                    getJpaRepositoryFields(controllerClass);

            List<DesignViolation> thisControllerViolations =
                    fieldsOfTypeJpaRepository.stream()
                    .map(field -> new DesignViolation(
                            field.getLineNumber() + 1,
                            controllerClass.getName(),
                            field.getName(),
                            field.getType().getName()))
                    .collect(Collectors.toList());
            designViolations.addAll(thisControllerViolations);
        }

        return designViolations;
    }

    private List<JavaClass> getControllerClasses(File file) {
        return javaProjectBuilder.getClasses().stream()
                .filter(c -> file.equals(getJavaClassSource(c)))
                .filter(CodeModel::isRestController)
                .collect(Collectors.toList());
    }

    private List<JavaField> getJpaRepositoryFields(JavaClass javaClass) {
        final String JPA_REPOSITORY_CLASS_NAME =
                "org.springframework.data.jpa.repository.JpaRepository";
        return javaClass.getFields().stream()
                .filter(f -> f.getType().isA(JPA_REPOSITORY_CLASS_NAME))
                .collect(Collectors.toList());
    }

    private static File getJavaClassSource(JavaClass javaClass) {
        try {
            return new File(javaClass.getSource().getURL().toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isRestController(JavaClass javaClass) {
        final String REST_CONTROLLER_CLASS_NAME =
                "org.springframework.web.bind.annotation.RestController";
        return javaClass.getAnnotations().stream()
                .map(a -> a.getType())
                .anyMatch(c -> c.isA(REST_CONTROLLER_CLASS_NAME));
    }
}
