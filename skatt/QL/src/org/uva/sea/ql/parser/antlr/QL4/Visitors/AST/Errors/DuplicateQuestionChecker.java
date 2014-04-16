package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateQuestionError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QLErrorGenerator;

/**
 * Visitor that checks a QLTree on duplicate question identifiers
 * @author Sammie Katt
 *
 */
public class DuplicateQuestionChecker extends QLErrorGenerator {

	/**
	 * The list of identifiers found when visiting
	 */
	List<Identifier> ids = new ArrayList<Identifier>();
	
	@Override
	/**
	 * When visiting a question, its identifier is compared to 
	 * previous visited questions identifiers. If it is a duplicate,
	 * a warning is returned, otherwise it is added to the list 
	 * of known identifiers 
	 */
	public List<QLErrorMsg> visit(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		Identifier qId = question.getIdentifier();
		
		if (ids.contains(qId)) {
			msgs.add(new DuplicateQuestionError(qId));
		} else {
			ids.add(qId);
		}
		
		return msgs;
	}
}
