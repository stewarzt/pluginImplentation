import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements IStatusReceiver {
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	public StatusPanel() {
		super();
		textArea = new JTextArea();
		// This gives us auto scaling to the parent size for our 1 child component
		this.setLayout(new GridLayout(1,1));
		// Set a static height
		this.setPreferredSize(new Dimension(this.getWidth(), 150));
		scrollPane = new JScrollPane (textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane);
	}

	@Override
	public void HandleStatusMessage(String message) {
		// TODO Auto-generated method stub
		textArea.append(message + "\n");
		ScrollToBottom();
	}
	
	private void ScrollToBottom() {
		final int bottom = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(bottom);
	}
	
}
