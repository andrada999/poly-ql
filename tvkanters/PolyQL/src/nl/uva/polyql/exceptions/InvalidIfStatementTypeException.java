package nl.uva.polyql.exceptions;

import nl.uva.polyql.model.types.Type;

public class InvalidIfStatementTypeException extends ParsingException {

    private static final long serialVersionUID = -7553479915956670117L;

    private final Type mType;

    public InvalidIfStatementTypeException(final Type type) {
        super("Invalid if-statement expression type: " + type + ", should be BOOLEAN");
        mType = type;
    }

    public Type getId() {
        return mType;
    }
}