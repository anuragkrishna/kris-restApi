package org.krishna.api.collaboration.data;

import java.util.HashMap;
import java.util.Map;

import org.krishna.api.collaboration.model.Conversation;
import org.krishna.api.collaboration.model.Credentials;
import org.krishna.api.collaboration.model.Profile;

/**
 * Data.
 * 
 * @author anurkris
 *
 */
public class Data {

	public static Map<Long, Conversation> conversationMap = new HashMap<Long, Conversation>();
	public static Map<String, Profile> profileMap = new HashMap<String, Profile>();
	public static Map<String, Credentials> credentialsMap = new HashMap<String, Credentials>();
	public static Map<String, Credentials> tokenMap = new HashMap<String, Credentials>();

}
