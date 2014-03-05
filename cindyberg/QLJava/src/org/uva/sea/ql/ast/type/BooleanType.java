package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class BooleanType extends Type{

	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public String toString(){
		return "boolean";
	}

	
	public boolean isCompatibleWithBoolean() {
		return true;
	}
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithBoolean();
	}
}
