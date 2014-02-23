package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class Field extends Question implements Question.OnUpdateListener {

    private Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String content, final Expression expression) {
        super(parent, id, content, expression.getReturnType());

        mExpression = expression;

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        setValue(mExpression.getValue());

        // TODO: Update displayed value of the field
    }
}
