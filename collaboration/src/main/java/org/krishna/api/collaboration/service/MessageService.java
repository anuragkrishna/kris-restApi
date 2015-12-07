package org.krishna.api.collaboration.service;

import java.util.Date;
import java.util.List;

import org.krishna.api.collaboration.dao.MessageDAO;
import org.krishna.api.collaboration.model.Message;

/**
 * Message Service Class.
 * 
 * @author anurkris
 *
 */
public class MessageService {

	/**
	 * Get all Messages
	 * 
	 * @return list of Messages
	 */
	public List<Message> getAllMessages(long conversationId) {
		return MessageDAO.getInstance().findAllMessages(conversationId);
	}

	/**
	 * Get Message
	 * 
	 * @param messageId
	 *            message id
	 * @return the message
	 */
	public Message getMessage(long messageId) {
		return MessageDAO.getInstance().findMessage(messageId);
	}

	/**
	 * Add Message
	 * 
	 * @param conversationId
	 *            conversation id.
	 * @param message
	 *            message object.
	 */
	public Message createMessage(Long conversationId, Message message) {
		message.setConversationId(conversationId);
		return MessageDAO.getInstance().insertMessage(message);
	}

	/**
	 * Update Message Name
	 * 
	 * @param conversationId
	 *            conversation id.
	 * @param message
	 *            message object.
	 */
	public Message updateMessage(Long conversationId, Message message) {
		message.setConversationId(conversationId);
		return MessageDAO.getInstance().updateMessage(message);
	}

	/**
	 * Delete Message.
	 * 
	 * @param messageId
	 *            message id
	 */
	public Message deleteMessage(long messageId) {
		return MessageDAO.getInstance().deleteMessage(messageId);
	}

	/**
	 * Get last modified time stamp.
	 * 
	 * @param messageId
	 *            message id
	 */
	public Date getlastModifiedTimeStamp(long messageId) {
		return MessageDAO.getInstance().getLastModified(messageId);
	}
}
