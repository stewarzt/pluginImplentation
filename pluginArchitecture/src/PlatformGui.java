import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PlatformGui extends JFrame {
	
	private GuiLoader pluginGuiLoader;
	
	private ListingPanel listingPanel;
	private ExecutionPanel pluginPanel;
	private StatusPanel statusPanel;

	public PlatformGui() {
		super();
		
		// Create the components that make up this frame
		statusPanel = new StatusPanel();
		DisplayStatusMessage("Loaded Status Panel");
		pluginPanel = new ExecutionPanel();
		DisplayStatusMessage("Loaded Execution Panel");
		
		// Create Plug-in Architecture Bindings
		pluginGuiLoader = new GuiLoader(pluginPanel, statusPanel);
		DisplayStatusMessage("Plugin Loader Ready");
		listingPanel = new ListingPanel(this);
		DisplayStatusMessage("Loaded Listing Panel");
		
		// Change some default settings
		this.setTitle("Plugin Architecture");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Add the components to the container
		Container pane = this.getContentPane();
		pane.add(listingPanel, BorderLayout.WEST);
		pane.add(pluginPanel, BorderLayout.CENTER);
		pane.add(statusPanel, BorderLayout.PAGE_END);
		
		pluginGuiLoader.LoadInitialPanel();
	}
	
	public void DisplayStatusMessage(String message) {
		statusPanel.HandleStatusMessage(message);
	}
	
	protected void LoadPlugin(String name) {
		pluginGuiLoader.LoadPluginByName(name);
		DisplayStatusMessage("Loaded the Plugin: " + name);
	}
	
	public void AddPlugin(String pluginName)
	{
		listingPanel.AddPluginName(pluginName);
	}
	
	public void RemovePlugin(String pluginName)
	{
		listingPanel.RemovePluginName(pluginName);
	}	
}
