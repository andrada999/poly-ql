package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiLogicExpr;

/**
 * Represents or expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class OrExpr extends BiLogicExpr {

	public OrExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Or(" + super.toString() + ")";
	}
}