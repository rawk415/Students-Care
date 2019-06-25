package school.healthroom.superclass;

import java.io.Serializable;
import java.sql.Date;

/**
 *   CREATE TABLE Log(
 *   logid NUMBER(2) PRIMARY KEY,
 *   stuid NUMBER(5) REFERENCES Students(stuid),
 *   mediname VARCHAR2(25) REFERENCES MediBox(mediname),
 *   logdate DATE);
 *   
 *   create sequence num_seq
 *   started with 1
 *   increment by 1;
 */

public class Log_Table {
	private int logID;
	private int stuID;
	private String mediname;
	private Date date;

	public Log_Table(int logID, int stuID, String mediname, Date date) {
		this.logID = logID;
		this.stuID = stuID;
		this.mediname = mediname;
		this.date = date;
	}

	public Log_Table() {
		super();
	}

	public int getLogID() {
		return logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}

	public String getMediname() {
		return mediname;
	}

	public void setMediname(String mediname) {
		this.mediname = mediname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
