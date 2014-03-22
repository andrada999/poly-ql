package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.expr.evaluate.Int;
import ast.expr.evaluate.Undefined;
import ast.expr.evaluate.Value;

public class ComputedControl extends Control{

	private final JLabel label;
	private Value value;
	
	public ComputedControl() {
		super();
		label = new JLabel();
		label.setVisible(false);
		value = new Undefined();
	}

	public void setValue(Value val){
		this.value = val;
		if (val instanceof Int){
			this.label.setText(((Int)val).getValue().toString());
		}
	}
	@Override
	public JComponent getComponent() {
		return label;
	}

	@Override
	public Value getValue() {
		return value;
	}

}
