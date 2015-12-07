package org.krishna.api.collaboration.service;

import java.util.Random;

import org.krishna.api.collaboration.dao.CredentialsDAO;
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
	 * Generate Token.
	 * 
	 * @param credentials user credentials.
	 * 
	 * @return
	 */
	public String generateToken(Credentials credentials) {
		long tokenValue = getRandomLong(10);
		CredentialsDAO.getInstance().insertToken(tokenValue, credentials);
		return String.valueOf(tokenValue);
	}

	/**
	 * Random String Generator.
	 * 
	 * @param length
	 *            Length of Random String
	 * @return Random alphanumeric String of given length
	 */
	private long getRandomLong(int length) {
		long range = 1234567L;
		Random r = new Random();
		long number = (long)(r.nextDouble()*range);
		return number;
	}

	/**
	 * Find User token
	 * 
	 * @param userName
	 *            user name.
	 * @return
	 */
	public Long findUserToken(String userName) {
		Long tokenVal = new Long(CredentialsDAO.getInstance().findUserToken(userName));
		return tokenVal;
	}
}
