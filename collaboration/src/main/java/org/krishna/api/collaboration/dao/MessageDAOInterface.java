package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.krishna.api.collaboration.model.Message;

/**
 * Message Data Access Object Interface.
 * 
 * @author anurkris
 *
 */
public interface MessageDAOInterface {

	List<Message> findAllMessages(long conversationId);

	Message findMessage(long messageId);

	Message insertMessage(Message Message);

	Message updateMessage(Message Message);

	Message deleteMessage(long MessageId);

	Date getLastModified(long MessageId);

}
