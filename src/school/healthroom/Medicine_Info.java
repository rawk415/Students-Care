package school.healthroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.DAO;
import school.healthroom.superclass.Log_Table;
import school.healthroom.superclass.MainFrame;



public class Medicine_Info extends MainFrame implements ActionListener{
	private Button btnOK;
	private Button btnCancel;
	private int id;
	private String symptom;
	private String medicine;
	private MediBox medibox;
	
	public Medicine_Info(int id, String symptom, String medicine, MediBox medibox) {
		super(symptom + "/" + medicine + "정보.png");
		this.id = id;
		this.symptom = symptom;
		this.medicine = medicine;
		this.medibox = medibox;
		setLocation(600, 340);
			
		btnCancel = new Button("약정보뒤로.png","약정보뒤로클릭시.png");
		btnCancel.setBounds(300, 306, 191, 62);
		getBackgroundPanel().add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnOK = new Button("약정보확인버튼.png","약정보확인클릭.png");
		btnOK.setBounds(474, 306, 191, 62);
		getBackgroundPanel().add(btnOK);
		btnOK.addActionListener(this);
		
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnOK) {
			//insert log table
			DAO dao = DAO.sharedInstance();
			
			Log_Table log = new Log_Table();
			log.setStuID(this.id);
			log.setMediname(medicine);
			Date date = new Date(System.currentTimeMillis());
			log.setDate(date);
			
			dao.InsertLog(log);
			
			//log table 표현
			new Print_Log();
			medibox.dispose();
			
			//개수 감소 & 확인
		} else if(obj == btnCancel) {
			dispose();
		}
		
	}
}
