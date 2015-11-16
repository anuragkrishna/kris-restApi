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

import org.krishna.api.RestfulSocialNetwork.model.Message;
import org.krishna.api.RestfulSocialNetwork.service.MessageService;

/**
 * Message Resource Controller Class.
 * @author anurkris
 *
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResourceController {

	private MessageService MessageService = null;

	/**
	 * Get Message service object.
	 * 
	 * @return Message service object
	 */
	private MessageService getMessageService() {
		if (MessageService != null) {
			return MessageService;
		}
		MessageService = new MessageService();
		return MessageService;
	}

	/**
	 * Get all Messages for a conversation
	 * 
	 * @param uriInfo
	 * @return
	 */
	@GET
	public Response getAllMessages(@PathParam("conversationId") Long conversationId, @Context UriInfo uriInfo) {

		List<Message> Messages = getMessageService().getAllMessages(conversationId);

		GenericEntity<List<Message>> list = new GenericEntity<List<Message>>(Messages) {
		};
		return Response.status(Status.FOUND).entity(list).build();
	}

	/**
	 * Get message.
	 * 
	 * @param uriInfo
	 *            uriInfo
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            message Id.
	 * @return
	 */
	@GET
	@Path("/{messageId}")
	public Response getConversations(@Context UriInfo uriInfo, @PathParam("conversationId") long conversationId,
			@PathParam("messageId") long messageId) {

		Message message = getMessageService().getMessage(conversationId, messageId);
		return Response.status(Status.FOUND).entity(message).build();
	}

	/**
	 * Create a Message.
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param uriInfo
	 *            uriInfo context.
	 * @param Message
	 *            Message object.
	 * @return
	 */
	@POST
	public Response createMessage(@PathParam("conversationId") Long conversationId, @Context UriInfo uriInfo,
			Message Message) {

		Message newMessage = getMessageService().createMessage(conversationId, Message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();

		Response response = Response.created(uri).entity(newMessage).build();
		return response;

	}

	/**
	 * Update Message name.
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            Message Id
	 * @param Message
	 *            Message object.
	 * @return
	 */
	@PUT
	@Path("/{messageId}")
	public Response updateMessage(@PathParam("conversationId") Long conversationId,
			@PathParam("messageId") long MessageId, Message message) {

		Message newMessage = getMessageService().updateMessage(conversationId, message);

		Response response = Response.status(Status.OK).entity(newMessage).build();
		return response;

	}

	/**
	 * Update Message name.
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            Message Id
	 */
	@DELETE
	@Path("/{messageId}")
	public Response deleteMessage(@PathParam("conversationId") Long conversationId,
			@PathParam("MessageId") long MessageId) {

		getMessageService().deleteMessage(conversationId, MessageId);
		return Response.status(Status.OK).build();

	}
}
