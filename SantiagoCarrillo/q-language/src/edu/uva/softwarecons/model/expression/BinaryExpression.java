package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class BinaryExpression implements Expression {

    private final Expression leftExpression;

    private final Expression rightExpression;


    protected BinaryExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }
}
