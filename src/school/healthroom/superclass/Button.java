package school.healthroom.superclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
	private String btnLink="";
	private String btnClickedLink="";

	public Button(String btnLink, String btnClickedLink) {
		this.btnLink = btnLink;
		this.btnClickedLink = btnClickedLink;
		
		setIcon(new ImageIcon("img/" + getBtnLink()));
		setSelectedIcon(new ImageIcon("img/" + getBtnClickedLink()));
		setPressedIcon(new ImageIcon("img/" + getBtnClickedLink()));

		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		
	}
	
	public Button(String btnLink) {
		this(btnLink, btnLink);
	}

	public String getBtnLink() {
		return btnLink;
	}

	public void setBtnLink(String btnLink) {
		this.btnLink = btnLink;
	}

	public String getBtnClickedLink() {
		return btnClickedLink;
	}

	public void setBtnClickedLink(String btnClickedLink) {
		this.btnClickedLink = btnClickedLink;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}	
