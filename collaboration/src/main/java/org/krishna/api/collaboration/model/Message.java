package org.krishna.api.collaboration.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Message Model Class.
 * 
 * @author anurkris
 *
 */
@XmlRootElement
public class Message {

	private long id;
	private String author;
	private String message;
	private Date lastModified;

	public Message() {

	}

	public Message(long id, String author, String message) {
		this.id = id;
		this.author = author;
		this.message = message;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}