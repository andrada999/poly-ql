package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;


public class Add extends BinaryOperator {

	
	public Add(Expression left, Expression right){
		
		super(left,right);
	}

	public void accept(IVisitor visitor) {
			
		visitor.visit(this);
		
	}
	
	public String show(){
		return "+";
	}



}