import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


/***
 * This class contains the panel that lists the currently available
 * plug-ins by name.
 * @author uphusar
 *
 */
@SuppressWarnings("serial")
public class ListingPanel extends JPanel implements MouseListener {
	
	private PlatformGui gui;
	
	private DefaultListModel<String> listModel;
	private JList<String> list;
	
	public ListingPanel(PlatformGui gui) {
		super();
		this.gui = gui;
		listModel = new DefaultListModel<String>();
		
		// This gives us auto scaling to the parent size for our 1 child component
		this.setLayout(new GridLayout(1,1));
		
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		JScrollPane pane = new JScrollPane(list);
		
		list.addMouseListener(this);
		
		this.add(pane);
	}
	
	public void AddPluginName(String name) {
		listModel.addElement(name);
	}
	
	public void RemovePluginName(String name) {
		listModel.removeElement(name);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = list.locationToIndex(e.getPoint());
		String pluginName = listModel.get(index);
		gui.LoadPlugin(pluginName);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	
}
