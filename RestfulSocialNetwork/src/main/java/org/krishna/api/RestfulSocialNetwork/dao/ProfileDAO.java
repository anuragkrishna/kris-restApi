package org.krishna.api.RestfulSocialNetwork.dao;

import java.util.ArrayList;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.data.Data;
import org.krishna.api.RestfulSocialNetwork.model.Profile;

/**
 * Profile Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class ProfileDAO implements ProfileDAOInterface {

	private static ProfileDAO ProfileDAO;

	private ProfileDAO() {
	}

	/**
	 * Get ProfileDAO object.
	 * 
	 * @return
	 */
	public static ProfileDAO getInstance() {
		if (ProfileDAO != null) {
			return ProfileDAO;
		}
		ProfileDAO = new ProfileDAO();
		return ProfileDAO;

	}

	/**
	 * Find all profiles.
	 */
	@Override
	public List<Profile> findAllProfiles() {
		return new ArrayList<Profile>(Data.profileMap.values());
	}

	/**
	 * Find a profile.
	 * 
	 * @param profileName
	 *            Profile name.
	 */
	@Override
	public Profile findProfile(String profileName) {
		return Data.profileMap.get(profileName);

	}

	/**
	 * Insert a profile.
	 * 
	 * @param profile
	 *            Profile Object.
	 */
	@Override
	public Profile insertProfile(Profile profile) {
		if (Data.profileMap.get(profile.getName()) != null) {
			return null;
		}

		Data.profileMap.put(profile.getName(), profile);
		return profile;
	}

	/**
	 * Update a profile
	 * 
	 * @param profile
	 *            profile object.
	 */
	@Override
	public Profile updateProfile(Profile profile) {
		Data.profileMap.put(profile.getName(), profile);
		return profile;
	}

	/**
	 * Delete Profile in conversation.
	 * 
	 * @param profileName
	 *            Profile N.
	 */
	@Override
	public Profile deleteProfile(String profileName) {
		Profile profile = Data.profileMap.get(profileName);
		Data.profileMap.remove(profileName);
		return profile;
	}

}
