package org.krishna.api.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Token {

	@Id @GeneratedValue
	private long id;
	
	@Column(name = "token_val")
	private long tokenVal;

	public long getTokenVal() {
		return tokenVal;
	}

	public void setTokenVal(long tokenVal) {
		this.tokenVal = tokenVal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
