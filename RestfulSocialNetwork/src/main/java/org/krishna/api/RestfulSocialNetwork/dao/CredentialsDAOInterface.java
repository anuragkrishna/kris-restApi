package org.krishna.api.RestfulSocialNetwork.dao;

import org.krishna.api.RestfulSocialNetwork.model.Credentials;

public interface CredentialsDAOInterface {

	Credentials findCredential(String username);

	boolean insertCredential(Credentials credential);

	boolean updateCredential(Credentials credential);

	boolean deleteCredential(Credentials credential);
}
