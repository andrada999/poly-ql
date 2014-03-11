package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;

/**
 * Represents the greater than expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class GreExpr extends BiMathExpr {

	public GreExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Gre(" + super.toString() + ")";
	}
}