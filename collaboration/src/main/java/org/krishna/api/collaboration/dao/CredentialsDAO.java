package org.krishna.api.collaboration.dao;

import org.hibernate.Session;
import org.krishna.api.collaboration.model.Credentials;
import org.krishna.api.collaboration.model.Token;
import org.krishna.api.collaboration.util.HibernateUtil;

/**
 * User credential Data Access Object Class.f
 * 
 * @author anurkris
 *
 */
public class CredentialsDAO implements CredentialsDAOInterface {

	private static CredentialsDAO credentialsDAO;
	private Session session = null;

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
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(credential);
		session.getTransaction().commit();
		session.close();
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
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Credentials credentials = session.get(Credentials.class, username);
		session.getTransaction().commit();
		session.close();
		return credentials;
	}

	/**
	 * Update user credential.
	 * 
	 * @param credentials
	 *            user credentials
	 * @return
	 */
	public boolean updateCredential(Credentials credentials) {
		
		boolean retVal = false;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Credentials dCredentials = session.get(Credentials.class, credentials.getUsername());
		if(dCredentials!=null)
		{
			dCredentials.setPassword(credentials.getPassword());
			retVal = true;
		}
		session.getTransaction().commit();
		session.close();
		return retVal;
	}

	/**
	 * Remove user credentials
	 * 
	 * @param credential
	 *            user credential
	 * @return
	 */
	public boolean deleteCredential(Credentials credentials) {

		boolean retVal = false;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Credentials dCredentials = session.get(Credentials.class, credentials.getUsername());
		if(dCredentials!=null)
		{
			session.delete(dCredentials);
			retVal = true;
		}
		session.getTransaction().commit();
		session.close();
		return retVal;
	}
	
	
	/**
	 * Insert Token
	 * 
	 * @param tokenVal
	 *            Token value
	 * @param userName
	 *            user name.
	 * @return
	 */
	public boolean insertToken(long tokenVal, Credentials credentials) {
		Token token = new Token();
		credentials.setToken(token);
		token.setTokenVal(tokenVal);
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(token);
		session.update(credentials);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * Find Token
	 * 
	 * @param val
	 *            token value
	 * @return
	 */
	public long findUserToken(String userName) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Credentials credentials = session.get(Credentials.class, userName);
		Token token = credentials.getToken();
		session.getTransaction().commit();
		session.close();
		System.out.println(token);
		return token.getTokenVal();
	}

}
