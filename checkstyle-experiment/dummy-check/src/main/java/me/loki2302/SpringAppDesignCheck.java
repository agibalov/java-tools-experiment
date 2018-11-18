package me.loki2302;

import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.thoughtworks.qdox.JavaProjectBuilder;

import java.io.File;
import java.util.List;

public class SpringAppDesignCheck extends AbstractFileSetCheck {
    private File sourceRoot;
    private CodeModel codeModel;

    public void setSourceRoot(File sourceRoot) {
        if(sourceRoot.exists()) {
            this.sourceRoot = sourceRoot;
        }
    }

    @Override
    public void beginProcessing(String charset) {
        JavaProjectBuilder jpb = new JavaProjectBuilder();
        jpb.addSourceTree(sourceRoot);
        codeModel = new CodeModel(jpb);
    }

    @Override
    protected void processFiltered(File file, List<String> lines) throws CheckstyleException {
        List<DesignViolation> designViolations =
                codeModel.getDesignViolations(file);
        for(DesignViolation designViolation : designViolations) {
            String message = String.format(
                    "%s is a controller and references %s via field %s",
                    designViolation.controllerClassName,
                    designViolation.repositoryClassName,
                    designViolation.controllerFieldName);
            log(designViolation.lineNumber, message);
        }
    }
}
