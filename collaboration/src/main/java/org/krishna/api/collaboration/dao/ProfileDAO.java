package org.krishna.api.collaboration.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.krishna.api.collaboration.model.Profile;
import org.krishna.api.collaboration.util.HibernateUtil;

/**
 * Profile Data Access Object Class.
 * 
 * @author anurkris
 *
 */
public class ProfileDAO implements ProfileDAOInterface {

	private static ProfileDAO profileDAO;
	private Session session = null;

	private ProfileDAO() {
	}

	/**
	 * Get ProfileDAO object.
	 * 
	 * @return
	 */
	public static ProfileDAO getInstance() {
		if (profileDAO != null) {
			return profileDAO;
		}
		profileDAO = new ProfileDAO();
		return profileDAO;

	}

	/**
	 * Find all profiles.
	 */
	@Override
	public List<Profile> findAllProfiles() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Profile");
		List<Profile> list = (List<Profile>)query.list();
		session.getTransaction().commit();		
		session.close();
		return list;
	}

	/**
	 * Find a profile.
	 * 
	 * @param profileName
	 *            Profile name.
	 */
	@Override
	public Profile findProfile(String profileName) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Profile profile = session.get(Profile.class, profileName);
		session.getTransaction().commit();
		session.close();
		return profile;

	}

	/**
	 * Insert a profile.
	 * 
	 * @param profile
	 *            Profile Object.
	 */
	@Override
	public Profile insertProfile(Profile profile) {
		profile.setLastModified(new Date());
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(profile);
		session.getTransaction().commit();
		session.close();
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
		profile.setLastModified(new Date());
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Profile dProfile = session.get(Profile.class, profile.getName());
		dProfile.setAge(profile.getAge());
		session.getTransaction().commit();
		session.close();		
		return dProfile;
	}

	/**
	 * Delete Profile in conversation.
	 * 
	 * @param profileName
	 *            Profile N.
	 */
	@Override
	public Profile deleteProfile(String profileName) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Profile dProfile = session.get(Profile.class,profileName);
		session.delete(dProfile);
		session.getTransaction().commit();
		session.close();		
		return dProfile;
	}

	/**
	 * Get Last modified
	 * 
	 * @param profileName
	 *            Profile N.
	 */
	@Override
	public Date getLastModified(String profileName) {
		Date lastModified = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		lastModified = session.get(Profile.class, profileName).getLastModified();
		session.getTransaction().commit();
		session.close();
		return lastModified;
	}

}
