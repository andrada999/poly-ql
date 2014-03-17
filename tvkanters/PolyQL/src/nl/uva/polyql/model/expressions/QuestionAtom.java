package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.exceptions.InvalidModifierException;
import nl.uva.polyql.exceptions.InvalidQuestionIdException;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.RuleContainer;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.modifiers.ModifierHelper;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public class QuestionAtom extends Expression {

    private final Question mQuestion;
    private final Modifier<?> mModifier;

    public QuestionAtom(final RuleContainer parentRuleContainer, final String id, final String modifier) {
        mQuestion = parentRuleContainer.getQuestion(id);
        if (mQuestion == null) {
            throw new InvalidQuestionIdException(id);
        }

        mModifier = ModifierHelper.getBySyntax(modifier);
        if (!mModifier.isValid(mQuestion.getType())) {
            throw new InvalidModifierException(mModifier, mQuestion.getType());
        }
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    public Value<?> getValue() {
        return mQuestion.getValue().applyModifier(mModifier);
    }

    @Override
    public String toString() {
        return mModifier.getSyntax() + mQuestion.getId() + " = " + getValue();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = new HashSet<>();
        questions.add(mQuestion);
        return questions;
    }
}