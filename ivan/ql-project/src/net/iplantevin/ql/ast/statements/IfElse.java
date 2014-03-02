package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.visitors.IASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * IfElse statement. Adds a body for the else to the Conditional body.
 *
 * @author Ivan
 */
public class IfElse extends Conditional {
    private final Statement elseBody;

    public IfElse(Expression condition, Statement body, Statement elseBody, ParserRuleContext ctx) {
        super(condition, body, ctx);

        this.elseBody = elseBody;
    }

    public Statement getElseBody() {
        return elseBody;
    }

    @Override
    public String toString() {
        return super.toString() + "else " + elseBody.toString();
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
