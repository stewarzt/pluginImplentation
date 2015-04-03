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
	
	private IPlugin loadedPlugin;
	
	public GuiLoader(ExecutionPanel executionPanel, IStatusReceiver receiver) {
		this.executionPanel = executionPanel;
		this.statusReceiver = receiver;
	}
	
	public void LoadPluginByName(String name) {
		IPlugin plugin = PluginManager.GetPlugin(name);
		if(plugin == null) return;
		
		if (plugin == this.loadedPlugin){
			return;
		}
		
		// Change the loaded plugin out, and suspend the old one
		if (loadedPlugin != null){
			loadedPlugin.suspendProcess();
		}
		
		JComponent pluginPanel = plugin.buildUI(this.statusReceiver);
		this.executionPanel.LoadPanel(pluginPanel);
		
		this.loadedPlugin = plugin;
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
