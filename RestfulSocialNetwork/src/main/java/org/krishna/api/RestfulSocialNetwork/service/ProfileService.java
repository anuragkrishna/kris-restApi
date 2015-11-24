package org.krishna.api.RestfulSocialNetwork.service;

import java.util.Date;
import java.util.List;

import org.krishna.api.RestfulSocialNetwork.dao.ProfileDAO;
import org.krishna.api.RestfulSocialNetwork.model.Profile;

/**
 * Profile Service
 * 
 * @author anurkris
 *
 */
public class ProfileService {

	/**
	 * Get all Profile
	 * 
	 * @return list of profiles
	 */
	public List<Profile> getAllProfiles() {
		return ProfileDAO.getInstance().findAllProfiles();
	}

	/**
	 * Get Message
	 * 
	 * @param profileName
	 *            profile name.
	 * @return the profile
	 */
	public Profile getProfile(String profileName) {
		return ProfileDAO.getInstance().findProfile(profileName);
	}

	/**
	 * Add Profile
	 * 
	 * @param profile
	 *            profile.
	 * @return the profile
	 */
	public Profile createProfile(Profile profile) {
		return ProfileDAO.getInstance().insertProfile(profile);
	}

	/**
	 * Update Profile.
	 * 
	 * @param profile
	 *            profile object.
	 * @return the profile
	 */
	public Profile updateProfile(Profile profile) {
		return ProfileDAO.getInstance().updateProfile(profile);
	}

	/**
	 * Delete Profile.
	 * 
	 * @param profileName
	 *            profile name.
	 * @return the profile
	 */
	public Profile deleteProfile(String profileName) {
		return ProfileDAO.getInstance().deleteProfile(profileName);
	}

	/**
	 * O Get last modified time stamp.
	 * 
	 * @param profileName
	 *            profile name.
	 */
	public Date getlastModifiedTimeStamp(String profileName) {
		return ProfileDAO.getInstance().getLastModified(profileName);
	}
}
