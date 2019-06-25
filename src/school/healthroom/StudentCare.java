package school.healthroom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.MainFrame;

public class StudentCare extends MainFrame{
	
	public StudentCare() {
		super("메인.png");
		
		Button btnOK = new Button("시작.png", "시작(클릭).png");
		getBackgroundPanel().add(btnOK);
		btnOK.setBounds(523, 475, 332, 94);
		btnOK.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new Infomation();
				dispose();
			}
		});
		
		setVisible(true); 
	}
	public static void main(String[] args) {
		new StudentCare();
	}
	
}
