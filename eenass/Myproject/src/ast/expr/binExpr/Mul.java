package ast.expr.binExpr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.IntType;
import ast.expr.types.Type;

public class Mul extends BinExpr{

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Symboles symb) {
		return new IntType();		
	}


}
