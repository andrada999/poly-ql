package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * Identifier.
 *
 * @author Ivan
 */
public class ID extends Expression {
    private final String name;

    public ID(String name, LineInfo lineInfo) {
        super(lineInfo);
        this.name = name;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return idTypeStore.getDeclaredType(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
