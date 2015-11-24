package org.krishna.api.collaboration.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.krishna.api.collaboration.dao.ConversationDAO;
import org.krishna.api.collaboration.model.Conversation;
import org.krishna.api.collaboration.model.Message;

/**
 * Conversation Service Class.
 * 
 * @author anurkris
 *
 */
public class ConversationService {

	/**
	 * Get all conversations
	 * 
	 * @return list of conversations
	 */
	public List<Conversation> getAllConversations() {
		return ConversationDAO.getInstance().findAllConversations();
	}

	/**
	 * Get all conversations
	 * 
	 * @return list of conversations
	 */
	public Conversation getConversation(long id) {
		return ConversationDAO.getInstance().findConversation(id);
	}

	/**
	 * Add conversation
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	public Conversation createConversation(Conversation conversation) {
		conversation.setMessages(new HashMap<Long, Message>());
		return ConversationDAO.getInstance().insertConversation(conversation);
	}

	/**
	 * Update conversation Name
	 * 
	 * @param conversation
	 *            conversation object
	 */
	public Conversation updateConversationName(Conversation conversation) {
		return ConversationDAO.getInstance().updateConversationName(conversation);
	}

	/**
	 * Update conversation Name
	 * 
	 * @param conversationId
	 *            conversation Id.
	 */
	public Conversation deleteConversation(long conversationId) {
		return ConversationDAO.getInstance().deleteConversation(conversationId);
	}

	/**
	 * Get last modified time stamp.
	 * 
	 * @param conversationId
	 *            conversation Id.
	 */
	public Date getlastModifiedTimeStamp(long conversationId) {
		return ConversationDAO.getInstance().getLastModified((conversationId));
	}

}
