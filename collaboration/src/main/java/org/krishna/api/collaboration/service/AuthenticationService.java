package org.krishna.api.collaboration.service;

import java.util.Random;

import org.krishna.api.collaboration.dao.CredentialsDAO;
import org.krishna.api.collaboration.dao.TokenDAO;
import org.krishna.api.collaboration.model.Credentials;

public class AuthenticationService {

	/**
	 * Verify if user name and password are correct.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password.
	 * @return
	 */
	public boolean authenticate(String username, String password) {
		Credentials credential = CredentialsDAO.getInstance().findCredential(username);
		if (password != null && credential != null && password.equals(credential.getPassword())) {
			return true;
		}
		return false;
	}

	/**
	 * Add new user credentials.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password.
	 * @return
	 */
	public boolean addCredentials(String username, String password) {
		if (username != null && password != null) {
			return CredentialsDAO.getInstance().insertCredential(new Credentials(username, password));
		}
		return false;
	}

	/**
	 * Update user credentials.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password.
	 * @return
	 */
	public boolean updateCredentials(String username, String password) {
		if (username != null && password != null) {
			return CredentialsDAO.getInstance().updateCredential((new Credentials(username, password)));
		}
		return false;
	}

	/**
	 * Delete user credentials.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password.
	 * @return
	 */
	public boolean deleteCredentials(String username, String password) {
		if (username != null && password != null) {
			return CredentialsDAO.getInstance().deleteCredential((new Credentials(username, password)));
		}
		return false;
	}

	/**
	 * Delete user credentials.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password.
	 * @return
	 */
	public String generateToken(Credentials credentials) {
		String tokenVal = getRandomString(10);
		TokenDAO.getInstance().insertToken(tokenVal, credentials);
		return tokenVal;
	}

	/**
	 * Random String Generator.
	 * 
	 * @param length
	 *            Length of Random String
	 * @return Random alphanumeric String of given length
	 */
	private String getRandomString(int length) {
		Random rnd = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rnd.nextInt(characters.length()));
		}
		return new String(text);
	}

	/**
	 * Find Token in data map.
	 * 
	 * @param tokenVal
	 *            token value
	 * @return
	 */
	public Credentials findToken(String tokenVal) {
		return TokenDAO.getInstance().findToken(tokenVal);
	}
}
