package nl.uva.polyql.model.values;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.view.ValueView;

public class InvalidValue extends Value<Object> {

    public InvalidValue() {
        super(null);
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public ValueView getView(final Question question) {
        return null;
    }

    @Override
    public void setViewValue(final ValueView view) {}

    @Override
    public InvalidValue applyModifier(final Modifier<?> modifier) {
        throw new UnsupportedOperationException();
    }

}
