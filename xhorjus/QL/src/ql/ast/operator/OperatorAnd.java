package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeBool;
import ql.ast.type.TypeInterface;

/** 
 * Logical AND operator
 */
public class OperatorAnd extends BinaryOperator {
	public OperatorAnd(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public TypeInterface getType() {
		return new TypeBool();
	}

	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}