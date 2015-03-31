import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ExecutionPanel extends JPanel {

	private JComponent currentPluginPanel;
	
	public ExecutionPanel() {
		super();
		// Gives auto maximal scaling size to the child element
		this.setLayout(new GridLayout(1,1));
	}
	
	public ExecutionPanel(JComponent panel) {
		this();
		currentPluginPanel = panel;
	}
	
	public void LoadPanel(JComponent panel) {
		if(currentPluginPanel != null)
			this.remove(currentPluginPanel);
		currentPluginPanel = panel;
		this.add(panel);
		revalidate(); // forces the panel to redraw itself
	}
	
}
