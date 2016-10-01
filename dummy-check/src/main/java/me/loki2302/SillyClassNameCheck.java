package me.loki2302;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class SillyClassNameCheck extends AbstractCheck {
    @Override
    public int[] getDefaultTokens() {
        return new int[] { TokenTypes.CLASS_DEF };
    }

    @Override
    public void visitToken(DetailAST ast) {
        String className = ast.findFirstToken(TokenTypes.IDENT).getText();
        if(className.equals("App")) {
            log(ast, String.format("Just \"%s\"? Really? You must be a genius...", className));
        }
    }
}
