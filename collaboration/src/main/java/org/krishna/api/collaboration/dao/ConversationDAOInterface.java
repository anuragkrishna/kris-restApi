package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.krishna.api.collaboration.model.Conversation;

/**
 * Conversation Data Access Object Interface
 * 
 * @author anurkris
 *
 */
public interface ConversationDAOInterface {

	List<Conversation> findAllConversations();

	Conversation findConversation(long id);

	Conversation insertConversation(Conversation conversation);

	Conversation updateConversationName(Conversation conversation);

	Conversation deleteConversation(long conversationId);

	Date getLastModified(long conversationId);

}
