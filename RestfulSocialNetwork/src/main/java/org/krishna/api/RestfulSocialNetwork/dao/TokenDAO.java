package org.krishna.api.RestfulSocialNetwork.dao;

import org.krishna.api.RestfulSocialNetwork.data.Data;
import org.krishna.api.RestfulSocialNetwork.model.Credentials;

/**
 * Token Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class TokenDAO {

	private static TokenDAO tokenDAO;

	private TokenDAO() {
	}

	/**
	 * Get ProfileDAO object.
	 * 
	 * @return
	 */
	public static TokenDAO getInstance() {
		if (tokenDAO != null) {
			return tokenDAO;
		}
		tokenDAO = new TokenDAO();
		return tokenDAO;

	}

	/**
	 * Insert Token
	 * 
	 * @param val
	 *            token value
	 * @param credential
	 *            credential to which token is assigned.
	 * @return
	 */
	public boolean insertToken(String val, Credentials credential) {
		if (Data.tokenMap.get(val) != null) {
			return false;
		}

		Data.tokenMap.put(val, credential);
		return true;
	}

	/**
	 * Find Token
	 * 
	 * @param val
	 *            token value
	 * @return
	 */
	public Credentials findToken(String val) {
		return Data.tokenMap.get(val);
	}

	/**
	 * Delete Token
	 * 
	 * @param val
	 *            token value
	 * @return
	 */
	public Credentials deleteToken(String val) {
		if (Data.tokenMap.get(val) != null) {
			Credentials credential = Data.tokenMap.get(val);
			Data.tokenMap.remove(val);
			return credential;
		}
		return null;
	}
}
