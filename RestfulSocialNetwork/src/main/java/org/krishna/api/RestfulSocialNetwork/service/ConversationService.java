package org.krishna.api.RestfulSocialNetwork.service;

import java.util.HashMap;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.dao.ConversationDAO;
import org.krishna.api.RestfulSocialNetwork.model.Conversation;
import org.krishna.api.RestfulSocialNetwork.model.Message;

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
	 * @param conversation conversation object.
	 */
	public Conversation createConversation(Conversation conversation) {
		conversation.setMessages(new HashMap<Long, Message>());
		return ConversationDAO.getInstance().insertConversation(conversation);
	}

	/**
	 * Update conversation Name
	 * 
	 * @param conversation conversation object
	 */
	public Conversation updateConversationName(Conversation conversation) {
		return ConversationDAO.getInstance().updateConversationName(conversation);
	}

	/**
	 * Update conversation Name
	 * 
	 * @param conversationId conversation Id.
	 */
	public Conversation deleteConversation(long conversationId) {
		return ConversationDAO.getInstance().deleteConversation(conversationId);
	}

}
