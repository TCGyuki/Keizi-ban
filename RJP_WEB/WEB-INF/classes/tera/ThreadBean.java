package tera;

import java.io.Serializable;
import java.sql.Date;

public class ThreadBean implements Serializable {
    private String  Thread_ID;
	private String  Thread_Title;
	private String  Thread_User;
    private String  Thread_Date;

	public ThreadBean(){}

	public String getThreadID() {
		return Thread_ID;
	}
	public void setThreadID(String Thread_ID) {
		this.Thread_ID = Thread_ID;
	}

	public String getThreadTitle() {
		return Thread_Title;
	}
	public void setThreadTitle(String Thread_Title) {
		this.Thread_Title = Thread_Title;
	}

	public String getThreadUser() {
		return Thread_User;
	}
	public void setThreadUser(String Thread_User) {
		this.Thread_User = Thread_User;
	}

    public String getThreadDate() {
		return Thread_Date;
	}
	public void setThreadDate(String Thread_Date) {
		this.Thread_Date = Thread_Date;
	}
}