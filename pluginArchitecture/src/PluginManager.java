import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class PluginManager {

	private HashMap<String, IPlugin> pluginList;
	
	public PluginManager()
	{
		this.pluginList = new HashMap<String, IPlugin>();
	}
	
	
	public void addPlugin(IPlugin p, String filename)
	{
		if(!this.pluginList.containsKey(filename))
		{
			this.pluginList.put(filename, p);
			System.out.println("Added");
		}
	}
	
	public void removePlugin(String filename)
	{
		this.pluginList.remove(filename);
		System.out.println("Removed");
	}
	
	public void executePlugin(String pluginName)
	{
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		Path dir = Paths.get(args[0]);
		PluginManager p = new PluginManager();
		
		
        try {
			new WatcherLoader(dir, true, p).processEvents();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
