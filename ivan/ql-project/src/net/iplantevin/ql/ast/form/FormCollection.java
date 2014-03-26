package net.iplantevin.ql.ast.form;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

import java.util.List;

/**
 * Root of a Questionnaire Language AST (QLAST). Contains a list of Form objects.
 *
 * @author Ivan
 */
public class FormCollection extends ASTNode {
    private List<Form> forms;

    public FormCollection(List<Form> forms, LineInfo lineInfo) {
        super(lineInfo);
        this.forms = forms;
    }

    public List<Form> getForms() {
        return forms;
    }

    @Override
    public String toString() {
        String formCollection = "";
        for (Form form : forms) {
            formCollection += form.toString() + "\n";
        }
        return formCollection;
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
