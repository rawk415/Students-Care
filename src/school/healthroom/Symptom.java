package school.healthroom;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.MainFrame;

public class Symptom extends MainFrame implements ActionListener {

	private Button btnPain;
	private Button btnCold;
	private Button btnHotFlush;
	private Button btnStomach;
	private Button btnCut;
	private Button btntabak;

	public MediBox mediBox;
	private String symptom;

	private int id;

	public Symptom(int id) {
		super("증상배경.png");
		this.id = id;

		btnPain = new Button("통증/통증버튼.png", "통증/통증클릭.png");
		btnPain.setBounds(183, 334, 316, 158);
		getBackgroundPanel().add(btnPain);
		btnPain.addActionListener(this);

		btnHotFlush = new Button("발열/발열버튼.png", "발열/발열클릭.png");
		btnHotFlush.setBounds(556, 334, 316, 158);
		getBackgroundPanel().add(btnHotFlush);
		btnHotFlush.addActionListener(this);

		btnCold = new Button("감기/감기버튼.png", "감기/감기클릭.png");
		btnCold.setBounds(923, 334, 316, 158);
		getBackgroundPanel().add(btnCold);
		btnCold.addActionListener(this);

		btnStomach = new Button("소화불량/소화불량버튼.png", "소화불량/소화불량클릭.png");
		btnStomach.setBounds(183, 548, 316, 158);
		getBackgroundPanel().add(btnStomach);
		btnStomach.addActionListener(this);

		btnCut = new Button("찰과상/찰과상버튼.png", "찰과상/찰과상클릭.png");
		btnCut.setBounds(556, 548, 316, 158);
		getBackgroundPanel().add(btnCut);
		btnCut.addActionListener(this);

		btntabak = new Button("타박상/타박상버튼.png", "타박상/타박상클릭.png");
		btntabak.setBounds(923, 548, 316, 158);
		getBackgroundPanel().add(btntabak);
		btntabak.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnPain) {
			symptom = "통증";
		} else if (obj == btnHotFlush) {
			symptom = "발열";
		} else if (obj == btnCold) {
			symptom = "감기";
		} else if (obj == btnStomach) {
			symptom = "소화불량";
		} else if (obj == btnCut) {
			symptom = "찰과상";
		} else if (obj == btntabak) {
			symptom = "타박상";
		}
		new MediBox(id, symptom);
		setVisible(false);

	}

}
