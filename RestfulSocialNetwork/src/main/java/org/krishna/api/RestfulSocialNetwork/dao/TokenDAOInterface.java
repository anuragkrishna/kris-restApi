package org.krishna.api.RestfulSocialNetwork.dao;

import org.krishna.api.RestfulSocialNetwork.model.Credentials;

/**
 * Token DAO Interface.
 * 
 * @author anurkris
 *
 */
public interface TokenDAOInterface {

	Credentials findToken(String tokenVal);

	boolean insertToken(String tokenVal, Credentials credentials);

	Credentials deleteToken(String tokenVal);
}
