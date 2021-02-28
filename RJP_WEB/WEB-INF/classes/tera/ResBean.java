package tera;

import java.io.Serializable;

public class ResBean implements Serializable {
    private String  Res_ID;
	private String  Res_User;
	private String  Res_Date;
    private String  Res_comment;
	private String	Thread_ID;

	public ResBean(){}

	public String getResID() {
		return Res_ID;
	}
	public void setResID(String Res_ID) {
		this.Res_ID = Res_ID;
	}

	public String getResUser() {
		return Res_User;
	}
	public void setResUser(String Res_User) {
		this.Res_User = Res_User;
	}

	public String getResDate() {
		return Res_Date;
	}
	public void setResDate(String Res_Date) {
		this.Res_Date = Res_Date;
	}

    public String getResComment() {
		return Res_comment;
	}
	public void setResComment(String Res_comment) {
		this.Res_comment = Res_comment;
	}
	public String getThreadID() {
		return Thread_ID;
	}
	public void setThreadID(String Thread_ID) {
		this.Thread_ID = Thread_ID;
	}
}