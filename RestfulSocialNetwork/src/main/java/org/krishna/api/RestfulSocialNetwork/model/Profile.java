package org.krishna.api.RestfulSocialNetwork.model;

import java.util.Date;

/**
 * Profile Model Class.
 * 
 * @author anurkris
 *
 */
public class Profile {

	private String name;
	private String age;
	private Date lastModified;

	public Profile() {

	}

	public Profile(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
