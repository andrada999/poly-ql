package gui.component;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;

public class CheckBox extends Control implements ItemListener{

	private JCheckBox checkBox;
	public CheckBox() {
		super();
		checkBox = new JCheckBox();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		publishEventChange();		
	}

	@Override
	public JComponent getComponent() {
		return checkBox;
	}

	@Override
	public Value getValue() {
		return new Bool(checkBox.isSelected());
	}

}
