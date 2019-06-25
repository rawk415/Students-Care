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
import school.healthroom.superclass.MediBox_List;

public class MediBox extends MainFrame implements ActionListener{
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btnBack;

	private int id;
	private String symptom;
	private String medicine1;
	private String medicine2;
	private String medicine3;
	private int whichMediList;
	
	public ArrayList<MediBox_List> medicineList = new ArrayList<MediBox_List>();
	
	
	public MediBox(int id, String symptom) {
		super(symptom + "/" + symptom + "배경.png");
		this.id = id;
		
		medicineList.add(new MediBox_List("통증", "게보린", "이지엔식스", "타이레놀"));
		medicineList.add(new MediBox_List("발열", "바이엘아스피린", "부루펜정", "이지엔식스이브"));
		medicineList.add(new MediBox_List("감기", "스트렙실", "코메키나", "테라플루"));
		medicineList.add(new MediBox_List("소화불량", "까스활명수", "베아제", "훼스탈플러스"));
		medicineList.add(new MediBox_List("찰과상", "듀오덤", "드레싱밴드", "이지덤"));
		medicineList.add(new MediBox_List("타박상", "신신파스", "제일쿨파프", "케토톱겔"));
		
		for(whichMediList = 0; whichMediList<=5; whichMediList++) {
			if(symptom == medicineList.get(whichMediList).getSymptom()) {
				this.symptom = symptom;
				this.medicine1 = medicineList.get(whichMediList).getMedicine1();
				this.medicine2 = medicineList.get(whichMediList).getMedicine2();
				this.medicine3 = medicineList.get(whichMediList).getMedicine3();
				break;
			}
		}

		btn1 = new Button(symptom + "/" + medicine1 + ".png", symptom + "/" + medicine1 + ".png");
		btn1.setBounds(325, 327, 690, 116);
		getBackgroundPanel().add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new Button(symptom + "/" + medicine2 + ".png", symptom + "/" + medicine2 + ".png");
		btn2.setBounds(325, 410, 690, 116);
		getBackgroundPanel().add(btn2);
		btn2.addActionListener(this);
		
		btn3 = new Button(symptom + "/" + medicine3 + ".png", symptom + "/" + medicine3 + ".png");
		btn3.setBounds(325, 493, 690, 116);
		getBackgroundPanel().add(btn3);
		btn3.addActionListener(this);
		
		btnBack = new Button("뒤로가기.png", "뒤로가기.png");
		btnBack.setBounds(25, 25, 31, 22);
		getBackgroundPanel().add(btnBack);
		btnBack.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn1) {
			new Medicine_Info(id, symptom, medicine1, this);
		} else if(obj == btn2) {
			new Medicine_Info(id, symptom, medicine2, this);
		} else if(obj == btn3) {
			new Medicine_Info(id, symptom, medicine3, this);
		} else if(obj == btnBack) {
			new Symptom(id);
			dispose();
		}
	}
	
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getMedicine1() {
		return medicine1;
	}

	public void setMedicine1(String medicine1) {
		this.medicine1 = medicine1;
	}

	public String getMedicine2() {
		return medicine2;
	}

	public void setMedicine2(String medicine2) {
		this.medicine2 = medicine2;
	}

	public String getMedicine3() {
		return medicine3;
	}

	public void setMedicine3(String medicine3) {
		this.medicine3 = medicine3;
	}

}
