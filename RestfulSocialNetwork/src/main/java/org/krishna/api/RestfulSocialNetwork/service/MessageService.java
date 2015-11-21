package org.krishna.api.RestfulSocialNetwork.service;

import java.util.Date;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.dao.MessageDAO;
import org.krishna.api.RestfulSocialNetwork.model.Message;

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
	 * @param conversationId
	 *            conversation id.
	 * @param messageId
	 *            message id
	 * @return the message
	 */
	public Message getMessage(long conversationId, long messageId) {
		return MessageDAO.getInstance().findMessage(conversationId, messageId);
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
		return MessageDAO.getInstance().insertMessage(conversationId, message);
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
		return MessageDAO.getInstance().updateMessage(conversationId, message);
	}

	/**
	 * Delete Message.
	 * 
	 * @param conversationId
	 *            conversation id.
	 * @param messageId
	 *            message id
	 */
	public Message deleteMessage(Long conversationId, long messageId) {
		return MessageDAO.getInstance().deleteMessage(conversationId, messageId);
	}

	/**
	 * Get last modified time stamp.
	 * 
	 * @param conversationId
	 *            conversation id.
	 * @param messageId
	 *            message id
	 */
	public Date getlastModifiedTimeStamp(Long conversationId, long messageId) {
		return MessageDAO.getInstance().getLastModified(conversationId, messageId);
	}
}
