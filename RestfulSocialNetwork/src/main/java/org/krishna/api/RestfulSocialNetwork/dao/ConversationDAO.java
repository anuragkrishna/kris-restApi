package org.krishna.api.RestfulSocialNetwork.dao;

import java.util.ArrayList;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.data.Data;
import org.krishna.api.RestfulSocialNetwork.model.Conversation;

/**
 * Conversation Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class ConversationDAO implements ConversationDAOInterface {

	private static ConversationDAO conversationDAO;

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
		return new ArrayList<Conversation>(Data.conversationMap.values());
	}

	/**
	 * Find a conversation based on id
	 * 
	 * @param id
	 *            conversation id.
	 */
	@Override
	public Conversation findConversation(long id) {
		return Data.conversationMap.get(new Long(id));

	}

	/**
	 * Insert Conversation.
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation insertConversation(Conversation conversation) {

		conversation.setId(Data.conversationMap.size() + 1);
		Data.conversationMap.put(new Long(conversation.getId()), conversation);
		return conversation;

	}

	/**
	 * Update Conversation
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation updateConversationName(Conversation conversation) {

		Conversation conv = Data.conversationMap.get(new Long(conversation.getId()));
		conv.setName(conversation.getName());
		return conv;
	}

	/**
	 * Delete conversation.
	 * 
	 * @param conversation
	 *            conversation object.
	 */
	@Override
	public Conversation deleteConversation(long conversationId) {

		Conversation conversation = Data.conversationMap.remove(new Long(conversationId));
		return conversation;

	}

}
