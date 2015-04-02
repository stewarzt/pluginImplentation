import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PluginImplementation implements IPlugin {

	private JButton button;
	private IStatusReceiver receiver;
	private JPanel panel;
	
    private ActionListener actions = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == button)
            {
            	receiver.HandleStatusMessage("Hello World!");
            }
        }
    }; 
	
	@Override
	public JPanel buildUI(IStatusReceiver receiver) {
		
		this.receiver = receiver;
		
		JButton button = new JButton("Say Hello World!");
		this.button = button;
		
		button.addActionListener(actions);
		
		JPanel panel = new JPanel();
		panel.add(button);
		
		//receiver.HandleStatusMessage("Hello World!");
		
		return panel;
	}

	@Override
	public void breakdownUI() {
		panel.remove(button);
	}

	@Override
	public void suspendProcess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeProcess() {
		// TODO Auto-generated method stub
		
	}

}
