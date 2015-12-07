package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.krishna.api.collaboration.model.Conversation;
import org.krishna.api.collaboration.util.HibernateUtil;

/**
 * Conversation Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class ConversationDAO implements ConversationDAOInterface {

	private static ConversationDAO conversationDAO;
	private Session session = null;
	
	private ConversationDAO() {
	}

	/**
	 * Get conversationDAO object.
	 * 
	 * @return
	 */
	public static ConversationDAO getInstance() {
		if (conversationDAO != null) {
			return conversationDAO;
		}
		conversationDAO = new ConversationDAO();
		return conversationDAO;

	}

	/**
	 * Get all conversations.
	 */
	@Override
	public List<Conversation> findAllConversations() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Conversation");
		List<Conversation> list = (List<Conversation>)query.list();
		session.getTransaction().commit();		
		session.close();
		return list;
	}

	/**
	 * Find a conversation based on id
	 * 
	 * @param id
	 *            conversation id.
	 */
	@Override
	public Conversation findConversation(long conversationId) 
	{
		Conversation conversation = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		conversation = session.get(Conversation.class,conversationId);		
		session.getTransaction().commit();
		session.close();
		return conversation;

	}

	/**
	 * Insert Conversation.
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation insertConversation(Conversation conversation) {

		conversation.setLastModified(new Date());
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(conversation);		
		session.getTransaction().commit();
		session.close();
		return conversation;

	}

	/**
	 * Update Conversation
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation updateConversationName(Conversation conversation) 
	{
		conversation.setLastModified(new Date());
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(conversation);	
		session.getTransaction().commit();
		session.close();
		return conversation;
	}

	/**
	 * Delete conversation.
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation deleteConversation(long conversationId) {

		Conversation conversation = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		conversation = session.get(Conversation.class,conversationId);
		session.delete(conversation);
		session.getTransaction().commit();
		session.close();
		return conversation;

	}

	/**
	 * Get Last modified
	 * 
	 * @param conversationId
	 *            conversation Id.
	 */
	@Override
	public Date getLastModified(long conversationId) 
	{
		Date lastModified = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		lastModified = session.get(Conversation.class,conversationId).getLastModified();		
		session.getTransaction().commit();
		session.close();
		return lastModified;
	}

}
