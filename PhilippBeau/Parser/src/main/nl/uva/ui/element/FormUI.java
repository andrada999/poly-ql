package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.Form;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;

public class FormUI extends UIElement {

    private final List<Statement> _block;

    public FormUI(final Form form, final List<Statement> block, final UI parentUI) {
        super(parentUI);
        _block = block;
    }

    @Override
    public JPanel getPanel() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

        for (Statement child : _block) {
            layout.add(child.getLayout(_parentUI).getPanel());
        }

        return layout;
    }

}
