package org.krishna.api.collaboration.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.krishna.api.collaboration.filters.Secured;
import org.krishna.api.collaboration.model.Message;
import org.krishna.api.collaboration.service.MessageService;

/**
 * Message Resource Controller Class.
 * 
 * @author anurkris
 *
 */
@Secured
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
	public Response getConversations(@Context Request request, @Context UriInfo uriInfo,
			@PathParam("conversationId") long conversationId, @PathParam("messageId") long messageId) {

		Date lastModified = getMessageService().getlastModifiedTimeStamp(messageId);

		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(86400);

		EntityTag etag = new EntityTag(String.valueOf(lastModified.hashCode()));

		ResponseBuilder responseBuilder = request.evaluatePreconditions(etag);

		// If entity tag matches, just send the status not modified
		if (responseBuilder != null) {
			return Response.status(Status.NOT_MODIFIED).tag(etag).cacheControl(cacheControl).build();
		}

		Message message = getMessageService().getMessage(messageId);
		return Response.status(Status.FOUND).tag(etag).cacheControl(cacheControl).entity(message).build();
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
		Date lastModified = newMessage.getLastModified();

		EntityTag etag = new EntityTag(String.valueOf(lastModified.hashCode()));
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();

		Response response = Response.created(uri).tag(etag).entity(newMessage).build();
		return response;

	}

	/**
	 * Update Message.
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
		Date lastModified = newMessage.getLastModified();

		EntityTag etag = new EntityTag(String.valueOf(lastModified.hashCode()));

		Response response = Response.status(Status.OK).tag(etag).entity(newMessage).build();
		return response;

	}

	/**
	 * Delete Message.
	 * 
	 * @param conversationId
	 *            conversation id
	 * @param messageId
	 *            Message Id
	 */
	@DELETE
	@Path("/{messageId}")
	public Response deleteMessage(@PathParam("conversationId") Long conversationId,
			@PathParam("messageId") long messageId) {

		getMessageService().deleteMessage(messageId);
		return Response.status(Status.OK).build();

	}
}
