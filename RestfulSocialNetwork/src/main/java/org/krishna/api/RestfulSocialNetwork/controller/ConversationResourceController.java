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

import org.krishna.api.RestfulSocialNetwork.model.Conversation;
import org.krishna.api.RestfulSocialNetwork.service.ConversationService;

/**
 * Conversation Resource Controller Class.
 * @author anurkris
 *
 */
@Path("/conversations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConversationResourceController {

	private ConversationService conversationService = null;

	/**
	 * Get Conversation service object.
	 * 
	 * @return conversation service object
	 */
	private ConversationService getConversationService() {
		if (conversationService != null) {
			return conversationService;
		}
		conversationService = new ConversationService();
		return conversationService;
	}

	/**
	 * Get all conversations.
	 * 
	 * @param uriInfo
	 * @return
	 */
	@GET
	public Response getAllConversations(@Context UriInfo uriInfo) {

		List<Conversation> conversations = getConversationService().getAllConversations();

		GenericEntity<List<Conversation>> list = new GenericEntity<List<Conversation>>(conversations) {
		};
		return Response.status(Status.FOUND).entity(list).build();
	}
	
	/**
	 * Get conversation.
	 * @param uriInfo uriInfo	
	 * @param conversationId conversation id
	 * @return
	 */
	@GET
	@Path("/{conversationId}")
	public Response getConversations(@Context UriInfo uriInfo,@PathParam("conversationId") long conversationId ) {

		Conversation conversation = getConversationService().getConversation(conversationId);
		return Response.status(Status.FOUND).entity(conversation).build();
	}

	/**
	 * Create a conversation.
	 * 
	 * @param uriInfo
	 *            uriInfo context.
	 * @param conversation
	 *            conversation object.
	 * @return
	 */
	@POST
	public Response createConversation(@Context UriInfo uriInfo, Conversation conversation) {

		Conversation newConversation = getConversationService().createConversation(conversation);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newConversation.getId())).build();

		Response response = Response.created(uri).entity(newConversation).build();
		return response;

	}

	/**
	 * Update conversation name.
	 * 
	 * @param conversationId
	 *            conversation Id.
	 * @return
	 */
	@PUT
	@Path("/{conversationId}")
	public Response updateConversationName(@PathParam("conversationId") long conversationId,
			Conversation conversation) {
	
		Conversation newConversation = getConversationService().updateConversationName(conversation);
		Response response = Response.status(Status.OK).entity(newConversation).build();
		return response;

	}
	
	
	/**
	 * Update conversation name.
	 * @param conversationId
	 *            conversation id.
	 * @return
	 */
	@DELETE
	@Path("/{conversationId}")
	public Response deleteConversation(@PathParam("conversationId") long conversationId) {
	
		getConversationService().deleteConversation(conversationId);
		return Response.status(Status.OK).build();

	}
	
	
	@Path("/{conversationId}/messages")
	public MessageResourceController getMessageResourceController()
	{
		return new MessageResourceController();
	}
}
