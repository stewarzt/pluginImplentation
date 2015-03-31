import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class PluginManager {

	private HashMap<String, Plugin> pluginList;
	
	public PluginManager()
	{
		this.pluginList = new HashMap<String, Plugin>();
	}
	
	
	public void addPlugin(Plugin p, String filename)
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
