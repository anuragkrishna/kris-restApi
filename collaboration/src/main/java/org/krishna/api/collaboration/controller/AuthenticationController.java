package org.krishna.api.collaboration.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.krishna.api.collaboration.model.Credentials;
import org.krishna.api.collaboration.service.AuthenticationService;

@Path("/authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationController {

	private AuthenticationService authenticationService = null;

	/**
	 * Get Authentication service object.
	 * 
	 * @return authentication service object
	 */
	private AuthenticationService getAuthenticationService() {
		if (authenticationService != null) {
			return authenticationService;
		}
		authenticationService = new AuthenticationService();
		return authenticationService;
	}

	/**
	 * Authenticate user credentials and generate token.
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password
	 * @return
	 */
	@GET
	public Response signIn(@HeaderParam("Username") String username, @HeaderParam("Password") String password) {

		String tokenVal = null;
		if (getAuthenticationService().authenticate(username, password)) {

			tokenVal = getAuthenticationService().generateToken(new Credentials(username, password));
			return Response.status(Status.OK).cookie(new NewCookie("X-AUTH-TOKEN", tokenVal)).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();
	}

	/**
	 * Add new user credentials
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password
	 * @return
	 */
	@POST
	public Response signUp(@HeaderParam("Username") String username, @HeaderParam("Password") String password) {
		if (getAuthenticationService().addCredentials(username, password)) {
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
}
