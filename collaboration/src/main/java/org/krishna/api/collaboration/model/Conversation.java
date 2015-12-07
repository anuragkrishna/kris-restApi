package org.krishna.api.collaboration.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Conversation Model Class.
 * 
 * @author anurkris
 *
 */
@XmlRootElement
@Entity
@Table(name="conversations")
public class Conversation {

	@Id
	@GeneratedValue
	@Column(name="conversation_id")
	private long id;
	
	@Column(name="conversation_name")
	private String name;
	
	@Column(name="conversation_author")
	private String author;

	@Transient
	@XmlTransient
	@ElementCollection
	@CollectionTable(name="message", joinColumns=@JoinColumn(name="conversation_id"))
	private Collection<Message> messages;

	@Column(name="conversation_lastmodified")
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

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
