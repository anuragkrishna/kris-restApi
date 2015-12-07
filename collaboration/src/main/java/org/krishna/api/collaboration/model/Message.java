package org.krishna.api.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Message Model Class.
 * 
 * @author anurkris
 *
 */
@NamedQueries({
	@NamedQuery(
	name = "findAllMessages",
	query = "from Message m where m.conversationId = :conversationId"
	)
})
@Entity
@Table(name="messages")
@XmlRootElement
public class Message {

	@Id @GeneratedValue
	@Column(name="message_id")
	private long id;
	
	@Column(name="conversation_id")
	private long conversationId;

	@Column(name="message_author")
	private String author;
	
	@Column(name="message_post")
	private String post;
	
	@Column(name="message_lastModified")
	private Date lastModified;

	public Message() {

	}

	public Message(long id, String author, String message) {
		this.id = id;
		this.author = author;
		this.post = message;

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

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public long getConversationId() {
		return conversationId;
	}

	public void setConversationId(long conversationId) {
		this.conversationId = conversationId;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
