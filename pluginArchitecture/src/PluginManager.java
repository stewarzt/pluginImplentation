import java.util.HashMap;


public class PluginManager {

	private static HashMap<String, IPlugin> pluginList = new HashMap<String, IPlugin>();
	private static PlatformGui platformGui;
	
	
	public static void addPlugin(IPlugin p, String filename)
	{
		if(!pluginList.containsKey(filename))
		{
			pluginList.put(filename, p);
			platformGui.AddPlugin(filename);
			System.out.println("Added");
		}
	}
	
	public static void removePlugin(String filename)
	{
		pluginList.remove(filename);
		System.out.println("Removed");
	}
	
	public static void executePlugin(String pluginName)
	{
		
	}
	
	public static IPlugin GetPlugin(String name) {
		return pluginList.get(name);
	}

	public static PlatformGui getPlatformGui() {
		return platformGui;
	}

	public static void setPlatformGui(PlatformGui platformGui) {
		PluginManager.platformGui = platformGui;
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
