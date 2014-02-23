package nl.uva.polyql.model.expressions.operators.bool;

public class EqualsOperator extends BooleanOperator {

    public static final String SYNTAX = "==";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected Boolean performOperation(boolean left, boolean right) {
        return left == right;
    }

    @Override
    protected Boolean performOperation(double left, double right) {
        return left == right;
    }

    @Override
    protected Boolean performOperation(String left, String right) {
        return left.equals(right);
    }

}
