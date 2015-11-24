package org.krishna.api.RestfulSocialNetwork.filters;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.krishna.api.RestfulSocialNetwork.service.AuthenticationService;

/**
 * Authentication Request FilterF
 * 
 * @author anurkris
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

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

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Cookie authCookie = requestContext.getCookies().get("X-AUTH-TOKEN");
		String username = requestContext.getHeaderString("Username");

		if (authCookie == null) {
			throw new NotAuthorizedException("Authorization must be provided");
		}

		String trimToken = authCookie.getValue().trim();

		if (getAuthenticationService().findToken(trimToken) == null) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());

		}

		if (!getAuthenticationService().findToken(trimToken).getUsername().equals(username)) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());

		}

	}

}
