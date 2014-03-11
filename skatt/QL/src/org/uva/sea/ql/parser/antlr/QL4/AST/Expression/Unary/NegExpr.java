package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;

/**
 * Represents the not expression in QL AST (!expression)
 * @author Sammie Katt
 *
 */
public class NegExpr extends UnaryExpr {
	public NegExpr(Expression expr) {
		super(expr);
	}
	
	public String toString() {
		return "Not(" + super.toString() + ")";
	}
}