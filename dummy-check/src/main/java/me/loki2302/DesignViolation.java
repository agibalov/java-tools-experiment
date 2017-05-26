package me.loki2302;

public class DesignViolation {
    public final int lineNumber;
    public final String controllerClassName;
    public final String controllerFieldName;
    public final String repositoryClassName;

    public DesignViolation(
            int lineNumber,
            String controllerClassName,
            String controllerFieldName,
            String repositoryClassName) {

        this.lineNumber = lineNumber;
        this.controllerClassName = controllerClassName;
        this.controllerFieldName = controllerFieldName;
        this.repositoryClassName = repositoryClassName;
    }
}
