import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


/***
 * This class handles the logic around loading the JPanel for a 
 * plugin into the ExecutionPanel of the PlatformGui
 * @author uphusar
 *
 */
public class GuiLoader {
	
	private ExecutionPanel executionPanel;
	private IStatusReceiver statusReceiver;
	
	public GuiLoader(ExecutionPanel executionPanel, IStatusReceiver receiver) {
		this.executionPanel = executionPanel;
		this.statusReceiver = receiver;
	}
	
	public void LoadPluginByName(String name) {
		
		// TODO: the following line is temporary code remove
		// it after integrating
		this.executionPanel.LoadPanel(CreatePanel(name));
		
		IPlugin plugin = PluginManager.GetPlugin(name);
		if(plugin == null) return;
		JComponent pluginPanel = plugin.buildUI(this.statusReceiver);
		this.executionPanel.LoadPanel(pluginPanel);
	}
	
	protected static JPanel CreatePanel(String labelText) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(new JLabel(labelText), BorderLayout.CENTER);
		return panel;
	}
	
	public void LoadInitialPanel() {
		JPanel panel = CreatePanel("Click on a plugin to the left to load it!");
		this.executionPanel.LoadPanel(panel);
	}
	
}
