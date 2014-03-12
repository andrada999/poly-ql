package main.nl.uva.parser.elements.expressions.atoms;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.type.Value;

public class TextAtom extends Expression {

    public TextAtom() {
        this("");
    }

    public TextAtom(final String value) {
        this(new Text(value));
    }

    public TextAtom(final Text value) {
        _value = value;
    }

    @Override
    public String toString() {
        return "Text: " + _value;
    }

    @Override
    public List<ValidationError> validate() {
        return new ArrayList<>();
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public void recalculateValueImpl() {
        throw new UnsupportedOperationException();
    }
}
