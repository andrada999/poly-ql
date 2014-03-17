package edu.uva.softwarecons.visitor.type;

import edu.uva.softwarecons.visitor.IQuestionnaireElement;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/5/14
 */
public interface ITypeElement extends IQuestionnaireElement{

    void accept(ITypeElementVisitor visitor);
}