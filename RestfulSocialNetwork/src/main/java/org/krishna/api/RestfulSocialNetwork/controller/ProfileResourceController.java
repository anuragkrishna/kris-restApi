package org.krishna.api.RestfulSocialNetwork.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.krishna.api.RestfulSocialNetwork.model.Profile;
import org.krishna.api.RestfulSocialNetwork.service.ProfileService;

/**
 * Profile Resource Controller Class.
 * 
 * @author anurkris
 *
 */
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResourceController {

	private ProfileService profileService = null;

	/**
	 * Get Profile service object.
	 * 
	 * @return Profile service object
	 */
	private ProfileService getProfileService() {
		if (profileService != null) {
			return profileService;
		}
		profileService = new ProfileService();
		return profileService;
	}

	/**
	 * Get all Profiles.
	 * 
	 * @return
	 */
	@GET
	public Response getAllProfiles() {
		List<Profile> profiles = getProfileService().getAllProfiles();
		GenericEntity<List<Profile>> list = new GenericEntity<List<Profile>>(profiles) {
		};
		return Response.status(Status.FOUND).entity(list).build();
	}

	/**
	 * Get profile.
	 * 
	 * @param uriInfo
	 *            uriInfo
	 * @param profileName
	 *            profile name
	 * @return
	 */
	@GET
	@Path("/{profileName}")
	public Response getProfile(@Context UriInfo uriInfo, @PathParam("profileName") String profileName) {

		Profile profile = getProfileService().getProfile(profileName);
		return Response.status(Status.FOUND).entity(profile).build();
	}

	/**
	 * Create a Profile.
	 * 
	 * @param uriInfo
	 *            uriInfo context.
	 * @param Profile
	 *            Profile object.
	 * @return
	 */
	@POST
	public Response createProfile(@Context UriInfo uriInfo, Profile Profile) {

		Profile newProfile = getProfileService().createProfile(Profile);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newProfile.getName())).build();

		Response response = Response.created(uri).entity(newProfile).build();
		return response;

	}

	/**
	 * Update Profile name.
	 * 
	 * @param Profile
	 *            Profile object.
	 * @return
	 */
	@PUT
	@Path("/{profileName}")
	public Response updateProfile(Profile profile) {

		Profile newProfile = getProfileService().updateProfile(profile);

		Response response = Response.status(Status.OK).entity(newProfile).build();
		return response;

	}

	/**
	 * Update Profile name.
	 * 
	 * @param profileName
	 *            profile name
	 * @return
	 */
	@DELETE
	@Path("/{profileName}")
	public Response deleteProfile(@PathParam("profileName") String profileName) {

		getProfileService().deleteProfile(profileName);
		return Response.status(Status.OK).build();

	}
}
