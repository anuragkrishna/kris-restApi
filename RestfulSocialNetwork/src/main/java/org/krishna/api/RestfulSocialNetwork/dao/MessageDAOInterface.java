package org.krishna.api.RestfulSocialNetwork.dao;

import java.util.Date;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.model.Message;

/**
 * Message Data Access Object Interface.
 * 
 * @author anurkris
 *
 */
public interface MessageDAOInterface {

	List<Message> findAllMessages(long conversationId);

	Message findMessage(long conversationId, long messageId);

	Message insertMessage(long conversationId, Message Message);

	Message updateMessage(long conversationId, Message Message);

	Message deleteMessage(long conversationId, long MessageId);

	Date getLastModified(long conversationId, long MessageId);

}
