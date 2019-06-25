package school.healthroom.superclass;

import java.sql.Date;

/**
 * CREATE TABLE Students( 
 * stuid NUMBER(5) PRIMARY KEY, 
 * stuname VARCHAR2(10),
 * stutel VARCHAR2(20));
 */

public class Student_Table {
	private int stuID;
	private String stuName;

	public Student_Table(int stuID, String stuName) {
		this.stuID = stuID;
		this.stuName = stuName;
	}
	
	public Student_Table() {
		super();
	}

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

}
