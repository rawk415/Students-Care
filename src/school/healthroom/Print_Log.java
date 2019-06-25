package school.healthroom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import school.healthroom.superclass.Button;
import school.healthroom.superclass.DAO;
import school.healthroom.superclass.Log_Table;
import school.healthroom.superclass.MainFrame;

public class Print_Log extends MainFrame{
	
	private String colNames[] = {"순서", "학번", "약 이름", "날짜"};
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private JTable table;
	private JScrollPane scrollPane;
	
	private int logID;
	private int stuID;
	private String mediName;
	private String date;
	private Font font = new Font("나눔바른고딕", Font.PLAIN, 28);
	
	public Print_Log() {
		super("배경.png");
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setRowHeight(30);
		table.setForeground(new Color(253,246,248));
		table.setBackground(new Color(0, 0, 0, 0F));	
		table.setShowGrid(false);
		table.setOpaque(false); 
		table.setIntercellSpacing(new Dimension(0,0));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setSize(1000,500);
		scrollPane.setLocation(200, 100);
		scrollPane.setOpaque(false); 
		scrollPane.getViewport().setOpaque(false); 
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBackground(new Color(0, 0, 0, 0F));
		
        
		getBackgroundPanel().add(scrollPane);
		
		JTableHeader jheader = table.getTableHeader();
		jheader.setBackground(new Color(213, 87, 128));
		jheader.setForeground(Color.WHITE);
		jheader.setFont(font);
		
		DAO dao = DAO.sharedInstance();
		List<Log_Table> list = dao.getListLog();
		for(Log_Table logs : list) {
			logID = logs.getLogID();
			stuID = logs.getStuID();
			mediName = logs.getMediname();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			date = df.format(logs.getDate());
			
			model.addRow(new Object[] {logID, stuID, mediName, date});
		}
		
		Button btnOK = new Button("인증실패OK.png", "인증실패OK클릭.png");
		getBackgroundPanel().add(btnOK);
		btnOK.setBounds(523, 600, 332, 94);
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
		
		
		
		setVisible(true);
	}

}
