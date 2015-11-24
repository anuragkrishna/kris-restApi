package org.krishna.api.collaboration.dao;

import org.krishna.api.collaboration.model.Credentials;

public interface CredentialsDAOInterface {

	Credentials findCredential(String username);

	boolean insertCredential(Credentials credential);

	boolean updateCredential(Credentials credential);

	boolean deleteCredential(Credentials credential);
}
