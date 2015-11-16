package org.krishna.api.RestfulSocialNetwork.model;

/**
 * Profile Model Class.
 * 
 * @author anurkris
 *
 */
public class Profile {

	private String name;
	private String age;

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

}
