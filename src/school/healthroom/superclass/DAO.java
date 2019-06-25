package school.healthroom.superclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;
import javax.xml.transform.Result;

public class DAO { // DataAccessObject
	static {
		try {
			Class.forName(DatabaseConstant.DRIVERNAME);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패 : " + e.getMessage());
		}
	} 

	private static DAO obj;

	public static DAO sharedInstance() {
		if (obj == null) {
			obj = new DAO();
		}
		return obj;
	}

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	private boolean connect() {
		boolean result = false;
		try {
			connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USER,
					DatabaseConstant.PASSWORD);
			result = true;
		} catch (SQLException e) {
			System.out.println("연결 실패 :" + e.getMessage());
		}
		return result;
	}

	private void close() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			System.out.println("해제 실패: " + e.getMessage());
		}
	}

	public List<Log_Table> getListLog() {
		List<Log_Table> list = null;
		String sql = "SELECT * FROM log order by logID";
		if (connect()) {
			try {
				statement = connection.createStatement();
				if (statement != null) {
					resultSet = statement.executeQuery(sql);
					list = new ArrayList<Log_Table>();
					while (resultSet.next()) {
						Log_Table logs = new Log_Table(); 
						logs.setLogID(resultSet.getInt("logID"));
						logs.setStuID(resultSet.getInt("stuID"));
						logs.setMediname(resultSet.getString("mediName"));
						logs.setDate(resultSet.getDate("logdate"));
						list.add(logs);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("데이터베이스 연결에 실패했습니다.");
			System.exit(0);
		}
		return list;
	}
	
	public boolean InsertLog(Log_Table log) {
		boolean result = false;
		if(this.connect()) {
			try {
				String sql = "INSERT INTO log(logid,stuid,mediname,logdate) VALUES(num_seq.nextval,?,?,?)"; // 컬럼에 값 넣기
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				// ?에 값 넣기 = > 바인딩
				preparedStatement.setInt(1, log.getStuID());
				preparedStatement.setString(2, log.getMediname());
				preparedStatement.setDate(3, log.getDate());
				
				int r = preparedStatement.executeUpdate();
				if(r>0) {
					result = true;
				}
				
				preparedStatement.close();
				this.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("데이터베이스 연결에 실패했습니다.");
			System.exit(0);
		}
		return result;
	}
	
	
	public List<Student_Table> getListStudent() {
		List<Student_Table> list = null;
		String sql = "SELECT * FROM Students";
		if (connect()) {
			try {
				statement = connection.createStatement();
				if (statement != null) {
					resultSet = statement.executeQuery(sql);
					list = new ArrayList<Student_Table>();
					while (resultSet.next()) {
						Student_Table students = new Student_Table(); 
						students.setStuID(resultSet.getInt("StuID"));
						students.setStuName(resultSet.getString("StuName"));
						list.add(students);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("데이터베이스 연결에 실패했습니다.");
			System.exit(0);
		}
		return list;
	}
	
	
}
