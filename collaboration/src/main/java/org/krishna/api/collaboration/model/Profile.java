package org.krishna.api.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Profile Model Class.
 * 
 * @author anurkris
 *
 */
@Entity
@Table(name = "profiles")
@XmlRootElement
public class Profile {

	@Id
	@Column(name = "profile_name")
	private String name;

	@Column(name = "profile_age")
	private String age;

	@Column(name = "profile_lastmodified")
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
