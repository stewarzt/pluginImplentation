import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class PluginManager {

	private static HashMap<String, IPlugin> pluginList;
	
	public PluginManager()
	{
		pluginList = new HashMap<String, IPlugin>();
	}
	
	
	public void addPlugin(IPlugin p, String filename)
	{
		if(!pluginList.containsKey(filename))
		{
			pluginList.put(filename, p);
			System.out.println("Added");
		}
	}
	
	public void removePlugin(String filename)
	{
		pluginList.remove(filename);
		System.out.println("Removed");
	}
	
	public static IPlugin GetPlugin(String name) {
		return pluginList.get(name);
	}
	
	
//	public static void main(String[] args)
//	{
//		Path dir = Paths.get(args[0]);
//		PluginManager p = new PluginManager();
//		
//		
//        try {
//			new WatcherLoader(dir, true, p).processEvents();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
