package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.krishna.api.collaboration.model.Profile;

/**
 * Profile Data Access Object Interface.
 * 
 * @author anurkris
 *
 */
public interface ProfileDAOInterface {

	List<Profile> findAllProfiles();

	Profile findProfile(String ProfileName);

	Profile insertProfile(Profile profile);

	Profile updateProfile(Profile profile);

	Profile deleteProfile(String profileName);

	Date getLastModified(String profileName);

}
