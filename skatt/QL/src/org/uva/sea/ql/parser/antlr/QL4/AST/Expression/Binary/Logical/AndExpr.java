package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiLogicExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents and expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class AndExpr extends BiLogicExpr {

	public AndExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "And(" + super.toString() + ")";
	}

}
