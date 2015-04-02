import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PluginImplementation implements IPlugin {

	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	private IStatusReceiver receiver;
	private JPanel panel;
	
	private JLabel timeDisplay;
	
	private Date startingTime;
	private Timer timer;
	
	private class incrementTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			DateFormat df = new SimpleDateFormat("hh:mm:ss");
			
			long millis = new Date().getTime() - startingTime.getTime(); 
			
			String timeText = String.format("%02d:%02d:%02d", 
					TimeUnit.MILLISECONDS.toHours(millis),
					TimeUnit.MILLISECONDS.toMinutes(millis) -  
					TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
					TimeUnit.MILLISECONDS.toSeconds(millis) - 
					TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));  
			
			timeDisplay.setText(timeText); 
			
			timer.schedule(new incrementTask(), 100);
		}
		
	
	}
	
	private long timeElapsed = 0;
	
    private ActionListener actions = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == startButton)
            {
            	receiver.HandleStatusMessage("Starting Timer");
            	
            	if (timer == null){
            		
            	
            	}
            	
            	startingTime = new Date();
            	
            	if (timer != null){
            		timer.cancel();
            		timer.purge();
            		timer = null;
            	}
            	
            	timer = new Timer();
            	
            	timer.schedule(new incrementTask(), 100);
            }
            else if (ae.getSource() == stopButton)
            {
            	receiver.HandleStatusMessage("Stopping Timer");
            	
            	if (timer != null)
            	{
            		timer.cancel();
            	}
            }
            else if (ae.getSource() == resetButton)
            {
            	receiver.HandleStatusMessage("Resetting Timer");
            	
            	if (timer != null)
            	{
            		timer.cancel();
            		timer.purge();
            		timer = null;
            	}
            	
            	timeElapsed = 0;
            	
            	timeDisplay.setText("00:00:00");
            }
        }
    }; 
	
	@Override
	public JPanel buildUI(IStatusReceiver receiver) {
		// This is the stopwatch plugin
		
		this.receiver = receiver;
		
		// Setup the label
		timeDisplay = new JLabel("00:00:00");
		
		// Setup the buttons
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		
		// Bind them all so that pressing something will cause the given actions
		startButton.addActionListener(actions);
		stopButton.addActionListener(actions);
		resetButton.addActionListener(actions);
		
		JPanel panel = new JPanel();
		panel.add(timeDisplay);
		panel.add(startButton);
		panel.add(stopButton);
		panel.add(resetButton);
				
		return panel;
	}

	@Override
	public void breakdownUI() {
		panel.remove(startButton);
		panel.remove(stopButton);
		panel.remove(resetButton);
	}

	@Override
	public void suspendProcess() {
		
		
	}

	@Override
	public void resumeProcess() {
		// TODO Auto-generated method stub
		
	}

}
