package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Not extends UnaryOperator {

	public Not(Expression expr) {
		
		super(expr);
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}
	
	public String toString(){
		return "!";
	}

	public Type typeOf(TypeEnvironment environment) {
		return new BooleanType();
	}

}
