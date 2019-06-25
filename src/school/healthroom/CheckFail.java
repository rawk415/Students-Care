package school.healthroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.MainFrame;

public class CheckFail extends MainFrame {
	private Button btnOK;

	public CheckFail() {
		super("인증실패배경.png");
//		setSize(400, 186);
		
		btnOK = new Button("인증실패OK.png", "인증실패OK클릭.png");
		btnOK.setBounds(157, 138, 161, 45);
		getBackgroundPanel().add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setVisible(true);

	}

}
