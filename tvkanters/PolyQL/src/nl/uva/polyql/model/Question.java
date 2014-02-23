package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.Set;

public class Question extends Rule {

    private final String mId;
    private final String mLabel;
    private final Types mType;
    private Object mValue;
    private boolean mValueValid = true;

    private final Set<OnUpdateListener> mUpdateListeners = new HashSet<>();

    protected Question(final RuleContainer parent, final String id, final String label, final String type) {
        this(parent, id, label, Types.valueOf(type.toUpperCase()));
    }

    protected Question(final RuleContainer parent, final String id, final String label, final Types type) {
        super(parent);

        if (parent.getQuestion(id) != null) {
            throw new RuntimeException("Duplicate rule ID");
        }

        mId = id;
        mLabel = (String) Types.STRING.parseInput(label);
        mType = type;

        setValue(mType.getDefaultValue());
    }

    public String getId() {
        return mId;
    }

    public String getContent() {
        return mLabel;
    }

    public Types getType() {
        return mType;
    }

    public void setValue(final Object value) {
        mValue = value;

        for (final OnUpdateListener valueListener : mUpdateListeners) {
            valueListener.onQuestionUpdate(this);
        }
    }

    public void setValueFromInput(final String input) {
        final Object value = mType.parseInput(input);
        mValueValid = value != null;
        setValue(value);
    }

    public Object getValue() {
        return mValue;
    }

    public boolean isValueValid() {
        return mValueValid;
    }

    public void addUpdateListener(final OnUpdateListener listener) {
        System.out.println("LISTENER " + listener + " ADDED TO " + this);
        mUpdateListeners.add(listener);
    }

    @Override
    public String toString() {
        return mId + " = " + mValue;
    }

    public interface OnUpdateListener {

        public void onQuestionUpdate(final Question question);
    }
}
