package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

/**
 * Logical AND (&&).
 *
 * @author Ivan
 */
public class And extends Binary {
    public And(Expression left, Expression right, LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new BooleanType();
    }

    @Override
    public String toString() {
        return getLeftHS() + " && " + getRightHS();
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
