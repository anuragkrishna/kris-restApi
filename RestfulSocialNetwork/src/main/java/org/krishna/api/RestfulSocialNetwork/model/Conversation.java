package org.krishna.api.RestfulSocialNetwork.model;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Conversation Model Class.
 * 
 * @author anurkris
 *
 */
@XmlRootElement
public class Conversation {

	private long id;
	private String name;
	private String author;
	@XmlTransient
	private Map<Long, Message> messages;
	private Date lastModified;

	public Conversation() {
	}

	public Conversation(long id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Map<Long, Message> getMessages() {
		return messages;
	}

	public void setMessages(Map<Long, Message> messages) {
		this.messages = messages;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
