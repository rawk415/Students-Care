package school.healthroom.superclass;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private ImagePanel backgroundPanel;

	public MainFrame(String panelImage) {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		backgroundPanel = new ImagePanel(new ImageIcon("img/"+panelImage).getImage());
		setSize(backgroundPanel.getWidth(), backgroundPanel.getHeight());
		setLocationRelativeTo(null);
		add(backgroundPanel);
		
		
	}
	public ImagePanel getBackgroundPanel() {
		return backgroundPanel;
	}

	public void setBackgroundPanel(ImagePanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}
}
