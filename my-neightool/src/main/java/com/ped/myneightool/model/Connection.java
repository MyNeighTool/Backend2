package com.ped.myneightool.model;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
/*@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Embeddable*/
public class Connection implements Serializable {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;*/

	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;

	public Connection() { }

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
