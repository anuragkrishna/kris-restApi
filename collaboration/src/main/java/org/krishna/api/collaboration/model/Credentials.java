package org.krishna.api.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User Credentials model class.
 * 
 * @author anurkris
 *
 */
@Entity
@Table(name = "credentials")
public class Credentials {

	@Id
	@Column(name = "credentials_username")
	private String username;

	@Column(name = "credentials_password")
	private String password;
	
	@OneToOne
	private Token token;

	public Credentials() {
	}

	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	
	

}
