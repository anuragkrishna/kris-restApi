package org.krishna.api.RestfulSocialNetwork.dao;

import org.krishna.api.RestfulSocialNetwork.data.Data;
import org.krishna.api.RestfulSocialNetwork.model.Credentials;

/**
 * User credential Data Access Object Class.f
 * 
 * @author anurkris
 *
 */
public class CredentialsDAO implements CredentialsDAOInterface {

	private static CredentialsDAO credentialsDAO;

	private CredentialsDAO() {
	}

	/**
	 * Get conversationDAO object.
	 * 
	 * @return
	 */
	public static CredentialsDAO getInstance() {
		if (credentialsDAO != null) {
			return credentialsDAO;
		}
		credentialsDAO = new CredentialsDAO();
		return credentialsDAO;

	}

	/**
	 * Insert user credential.
	 * 
	 * @param credential
	 *            user credential.
	 * @return
	 */
	public boolean insertCredential(Credentials credential) {
		if (Data.credentialsMap.get(credential.getUsername()) != null) {
			return false;
		}
		Data.credentialsMap.put(credential.getUsername(), credential);
		return true;
	}

	/**
	 * Find user credential.
	 * 
	 * @param username
	 *            user name
	 * @return
	 */
	public Credentials findCredential(String username) {
		return Data.credentialsMap.get(username);
	}

	/**
	 * Update user credential.
	 * 
	 * @param credential
	 *            user credential
	 * @return
	 */
	public boolean updateCredential(Credentials credential) {

		if (Data.credentialsMap.get(credential.getUsername()) != null) {
			Data.credentialsMap.put(credential.getUsername(), credential);
			return true;
		}
		return false;
	}

	/**
	 * Remove user credentials
	 * 
	 * @param credential
	 *            user credential
	 * @return
	 */
	public boolean deleteCredential(Credentials credential) {

		if (Data.credentialsMap.get(credential.getUsername()) != null) {
			Data.credentialsMap.remove(credential.getUsername());
			return true;
		}
		return false;
	}
}
