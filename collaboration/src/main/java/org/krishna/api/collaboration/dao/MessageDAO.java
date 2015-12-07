package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.krishna.api.collaboration.model.Message;
import org.krishna.api.collaboration.util.HibernateUtil;

/**
 * Message Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class MessageDAO implements MessageDAOInterface {

	private static MessageDAO MessageDAO;
	private Session session = null;

	private MessageDAO() {
	}

	/**
	 * Get MessageDAO object.
	 * 
	 * @return
	 */
	public static MessageDAO getInstance() {
		if (MessageDAO != null) {
			return MessageDAO;
		}
		MessageDAO = new MessageDAO();
		return MessageDAO;

	}

	/**
	 * Find all messages in a conversation
	 * 
	 * @param conversationId
	 *            conversation id.
	 */
	@Override
	public List<Message> findAllMessages(long conversationId) {

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findAllMessages").setString("conversationId",
				String.valueOf(conversationId));
		List<Message> messages = query.list();
		session.getTransaction().commit();
		session.close();

		return messages;
	}

	/**
	 * Find a message.
	 * 
	 * @param conversationId
	 *            conversation id.
	 * @param messageId
	 *            Message Id.
	 */
	@Override
	public Message findMessage(long messageId) {

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = session.get(Message.class, messageId);
		session.getTransaction().commit();
		session.close();

		return message;
	}

	/**
	 * Insert a message.
	 * 
	 * @param conversationId
	 *            conversation Id
	 * @param message
	 *            Message Object.
	 */
	@Override
	public Message insertMessage(Message message) {

		Date now = new Date();
		message.setLastModified(now);
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		session.close();

		return message;
	}

	/**
	 * Update a message
	 * 
	 * @param conversationId
	 *            conversation Id
	 * @param message
	 *            message object.
	 */
	@Override
	public Message updateMessage(Message message) {

		Date now = new Date();
		message.setLastModified(now);

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message dMessage = session.get(Message.class, message.getId());
		dMessage.setPost(message.getPost());
		session.getTransaction().commit();
		session.close();

		return message;
	}

	/**
	 * Delete Message in conversation.
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            Message Id.
	 */
	@Override
	public Message deleteMessage(long messageId) {

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = session.get(Message.class, messageId);
		session.delete(message);
		session.getTransaction().commit();
		session.close();
		return message;
	}

	/**
	 * Get Last modified
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            Message Id.
	 */
	@Override
	public Date getLastModified(long messageId) {
		Date lastModified = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		lastModified = session.get(Message.class, messageId).getLastModified();
		session.getTransaction().commit();
		session.close();
		return lastModified;
	}
}
