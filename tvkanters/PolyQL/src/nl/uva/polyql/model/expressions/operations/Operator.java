package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.InvalidValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;
import nl.uva.polyql.utils.SyntaxKey;

public abstract class Operator implements SyntaxKey {

    public Value<?> performOperation(final Operation operation) {
        return operation.getLeft().getValue().performOperationOnLeft(this, operation.getRight().getValue());
    }

    public Value<?> performOperation(final BooleanValue leftValue, final BooleanValue booleanValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final NumberValue leftValue, final NumberValue numberValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final StringValue leftValue, final NumberValue numberValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final NumberValue leftValue, final StringValue stringValue) {
        return new InvalidValue();
    }

    public Value<?> performOperation(final StringValue leftValue, final StringValue stringValue) {
        return new InvalidValue();
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
