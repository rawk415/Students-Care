package school.healthroom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.DAO;
import school.healthroom.superclass.MainFrame;
import school.healthroom.superclass.Student_Table;

public class Infomation extends MainFrame implements ActionListener {
	private JTextField tfStuID = new JTextField(10);
	private JTextField tfStuName = new JTextField(10);
	private JLabel lblID = new JLabel();
	private JLabel lblName = new JLabel();
	private Button btnCheck;
	
	private int id;
	private String name;

	public Infomation() {
		super("로그인창2.png");

		makeTextField(lblID, tfStuID, 284);
		makeTextField(lblName, tfStuName, 365);
		tfStuName.addActionListener(this);

		btnCheck = new Button("진단버튼.png", "진단버튼(클릭).png");
		btnCheck.setBounds(550, 473, 332, 94);
		getBackgroundPanel().add(btnCheck);
		btnCheck.addActionListener(this);

		setVisible(true);
	}

	private void makeTextField(JLabel lbl, JTextField tf, int y) {
		lbl.setLayout(new BorderLayout());
		lbl.setIcon(new ImageIcon("img/입력창.png"));
		lbl.setBounds(490, y, 455, 79);
		getBackgroundPanel().add(lbl);
		tf.setOpaque(false);
		tf.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 테두리 x
		tf.setFont(new Font("나눔바른고딕", Font.PLAIN, 28));
		lbl.add(tf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnCheck || obj == tfStuName) {
			id = Integer.parseInt(tfStuID.getText());
			name = tfStuName.getText();

			// DB Check
			DAO dao = DAO.sharedInstance();
			// student table 만들고 getList
			List<Student_Table> list = dao.getListStudent();
			for(Student_Table students : list) {
				if(id == students.getStuID()) {
					if(name.equals(students.getStuName())) {
						new Symptom(id);
						dispose();
						return;
					}
				}
			}
			new CheckFail();
			tfStuID.setText("");
			tfStuName.setText("");
			tfStuID.requestFocusInWindow();
		}
	}

}
