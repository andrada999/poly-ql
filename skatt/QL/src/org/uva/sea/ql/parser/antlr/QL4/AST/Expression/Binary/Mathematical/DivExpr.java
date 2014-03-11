package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;

/**
 * Represents a division expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class DivExpr extends BiMathExpr {

	public DivExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Div(" + super.toString() + ")";
	}
}