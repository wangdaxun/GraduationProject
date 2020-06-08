package com.wdx.manager.bean;

public class User {
 	private	Integer user_id;
 	private String user_logname;
 	private String user_pwd;
 	private String user_realname;
 	private String user_email;
 	private Integer user_role;
 	private Integer user_state;
 	
 	public User() {
 		super();
 	}

	public User(String user_logname, String user_pwd, String user_realname, String user_email,
			Integer user_role, Integer user_state) {
		super();
		this.user_logname = user_logname;
		this.user_pwd = user_pwd;
		this.user_realname = user_realname;
		this.user_email = user_email;
		this.user_role = user_role;
		this.user_state = user_state;
	}

	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_logname() {
		return user_logname;
	}

	public void setUser_logname(String user_logname) {
		this.user_logname = user_logname;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Integer getUser_role() {
		return user_role;
	}

	public void setUser_role(Integer usre_role) {
		this.user_role = usre_role;
	}

	public Integer getUser_state() {
		return user_state;
	}

	public void setUser_state(Integer user_state) {
		this.user_state = user_state;
	}
 	
	
}
