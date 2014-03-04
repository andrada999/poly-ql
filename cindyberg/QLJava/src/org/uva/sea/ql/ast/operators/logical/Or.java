package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Or extends BinaryOperator {

	public Or(Expression left,Expression right) {
		super(left,right);
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}
	
	public String show(){
		return "||";
	}

	public Type typeOf(TypeEnvironment environment) {
		return new BooleanType();
	}

}
