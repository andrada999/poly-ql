package ast.statement;

import ast.Visitor;
import ast.expr.Identifier;
import ast.expr.literal.StrLiteral;
import ast.types.Type;

public class Question extends Statement {
	
	private final Identifier id;
	private final StrLiteral label;
	private final Type type;

	public Question(Identifier id, StrLiteral label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public Identifier getId(){
		return id;
	}
	
	public StrLiteral getLabel(){
		return label;
	}

	public Type getType(){
		return type;
	}
}
