import javax.swing.JPanel;

public interface IPlugin {

	public JPanel buildUI(IStatusReceiver receiver);
	
	public void breakdownUI();
	
	public void suspendProcess();
	
	public void resumeProcess();
	
}