package org.krishna.api.RestfulSocialNetwork.data;

import java.util.HashMap;
import java.util.Map;

import org.krishna.api.RestfulSocialNetwork.model.Conversation;
import org.krishna.api.RestfulSocialNetwork.model.Profile;

/**
 * Data.
 * 
 * @author anurkris
 *
 */
public class Data {

	public static Map<Long, Conversation> conversationMap = new HashMap<Long, Conversation>();
	public static Map<String, Profile> profileMap = new HashMap<String, Profile>();


}
