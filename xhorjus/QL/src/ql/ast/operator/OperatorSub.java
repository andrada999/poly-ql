package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

/** 
 * Add operator
 */
public class OperatorSub extends OperatorArithmetic {
	public OperatorSub(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}