package ql.ast.expression.logical;

import ql.ast.expression.BinaryExpression;
import ql.ast.expression.IExpression;
import ql.ast.type.BooleanType;
import ql.ast.visitor_elements.IExpressionElementVisitor;

/**
 * @author orosu
 */
public class LogicalOr extends BinaryExpression
{
    public LogicalOr(IExpression leftSubExpression, IExpression rightSubExpression)
    {
        super(leftSubExpression, rightSubExpression);
    }

    @Override
    public BooleanType getType()
    {
        return new BooleanType();
    }

    @Override
    public <T> T accept(IExpressionElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
