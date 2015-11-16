package org.krishna.api.RestfulSocialNetwork.dao;

import java.util.ArrayList;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.data.Data;
import org.krishna.api.RestfulSocialNetwork.model.Conversation;
import org.krishna.api.RestfulSocialNetwork.model.Message;

/**
 * Message Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class MessageDAO implements MessageDAOInterface {

	private static MessageDAO MessageDAO;

	private MessageDAO() {
	}

	/**
	 * Get MessageDAO object.
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
	 * @param conversationId conversation id.
	 */
	@Override
	public List<Message> findAllMessages(long conversationId) {
		return new ArrayList<Message>(Data.conversationMap.get(new Long(conversationId)).getMessages().values());
	}

	/**
	 * Find a message.
	 * @param conversationId conversation id.
	 * @param messageId Message Id.
	 */
	@Override
	public Message findMessage(long conversationId, long messageId) {
		return Data.conversationMap.get(new Long(conversationId)).getMessages().get(new Long(messageId));

	}

	/**
	 * Insert a message.
	 * @param conversationId conversation Id
	 * @param message Message Object.
	 */
	@Override
	public Message insertMessage(long conversationId, Message message) {
		Conversation conversation = Data.conversationMap.get(new Long(conversationId));
		long id = conversation.getMessages().size() + 1;
		message.setId(id);
		conversation.getMessages().put(id, message);
		return message;
	}

	/**
	 * Update a  message
	 * @param conversationId conversation Id
	 * @param message message object.
	 */
	@Override
	public Message updateMessage(long conversationId, Message message) {
		Conversation conversation = Data.conversationMap.get(new Long(conversationId));
		conversation.getMessages().put(message.getId(), message);
		return message;
	}

	/**
	 * Delete Message in conversation.
	 * @param conversationId conversation id
	 * @param messageId Message Id.
	 */
	@Override
	public Message deleteMessage(long conversationId, long messageId) {
		Conversation conversation = Data.conversationMap.get(new Long(conversationId));
		Message toRemoveMessage = conversation.getMessages().get(new Long(messageId));
		conversation.getMessages().remove(new Long(messageId));
		return toRemoveMessage;
	}

}
