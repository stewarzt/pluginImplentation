import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		PlatformGui g = new PlatformGui();
		g.show();
		Path dir = Paths.get(args[0]);
		
		PluginManager.setPlatformGui(g);

		try {
			new WatcherLoader(dir, true).processEvents();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}