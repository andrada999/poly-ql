package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Visitor that checks a QLTree on duplicate labels
 * @author Sammie Katt
 *
 */
public class DuplicateLabel extends QLErrorVisitor {

	List<Label> labels = new ArrayList<Label>();
	
	public List<QLErrorMsg> visitQuestion(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		Label qLabel = question.getLabel();
		
		if (labels.contains(qLabel)) {
			msgs.add(new QLErrorMsg("A duplicate label is used: " + qLabel));
		} else {
			labels.add(qLabel);
		}
		
		return msgs;
	}
}
