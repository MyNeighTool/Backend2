package com.ped.myneightool.model;


import javax.persistence.Embeddable;

@Embeddable
public class Connection {
	
	private String login;
	private String password;
	
	public Connection(){
		
	}
	
	public Connection(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

}
