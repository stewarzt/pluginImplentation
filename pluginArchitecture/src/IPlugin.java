import javax.swing.JPanel;

public interface IPlugin {

	public void buildUI(JPanel panel);
	
	public void breakdownUI();
	
	public void suspendProcess();
	
	public void resumeProcess();
	
}