# kris-restApi 
A restful api for social network. 
Structure:
	Conversations with messages
	User Profiles.	

	
Authentication:

It uses token based authentication:
 - User signs up for the service
 - User signs in. Server authenticates and sends a token in a cookie.
 - User sends this token along with user name. Request filter authenticates it and passes the request to the resource controller or aborts the request.

Example:
POST - localhost:8080/RestfulSocialNetwork/webapi/authentication
	   Request: 	Headers - username = <username>
							  password = <password> 	

GET - localhost:8080/RestfulSocialNetwork/webapi/authentication
	   Request:		Headers - username = <username>
							  password = <password> 
	   Response: Cookie(Name="X-AUTH-TOKEN", Value=<RandonmToken>) - Use this to access resources (Looking for JWT ?)


Caching:

The API provides support for client side caching using conditional GET.
Example:

 	1. Create a Resource - say a conversation
		Request :   Method - POST - localhost:8080/RestfulSocialNetwork/webapi/conversations/
					Body   - {
								"name":"myConversation",
								"author":"anurag"
							}	
					Header - username=<username>
					Cookie - The one generated during authentication
		
		Response - 201 Created along with the entity tag.(ETag)

	2. Get the resource:
		Request : Method - GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/
				  Header - username = <username>
				  If-None-Match = <ETag>
				 
		Response : If Etag matches, 304 Not Modified. (Use data from local cache)
				   Else: 302 Found
						{
						  "author": "anurag",
						  "id": 1,
						  "lastModified": "2015-11-24T09:44:35.267+05:30",
						  "messages": {
							"entry": []
						  },
						  "name": "myConversation"
						}
						
						
CRUD Operations:

Conversations:
GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/

POST - localhost:8080/RestfulSocialNetwork/webapi/conversations/
		Sample Request - {
							"name":"SampleConversation",
							"author":"anurag"
						}
GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}

PUT - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}
		Sample Request - {
							"id"=<id>
							"name":"ChangedSampleConversation",
							"author":"anurag"
						}
DELETE - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}	


Messages:
GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages

POST - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/
		Sample Request - {
							"message":"Is this you ?",
							"author":"anurag"
							}
		Sample Response - {
							  "author": "anurag",
							  "id": 1,
							  "lastModified": "2015-11-24T10:04:03.866+05:30",
							  "message": "Is this you ?"
							}				
GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}
		Sample Response - {
							  "author": "anurag",
							  "id": 1,
							  "lastModified": "2015-11-24T10:04:03.866+05:30",
							  "message": "Is this you ?"
							}			
PUT - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}
		Sample Request - {
							"id" : "1",
							"message":"Yes it is me ?",
							"author":"anurag"
							}
		Sample Response - {
							  "author": "anurag",
							  "id": 1,
							  "lastModified": "2015-11-24T10:04:03.866+05:30",
							  "message": "Yes it is me ?"
							}		
DELETE - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}

Profile:
GET - localhost:8080/RestfulSocialNetwork/webapi/profiles/
POST - localhost:8080/RestfulSocialNetwork/webapi/profiles/
		Sample Request - {
							"name":"anurag",
							"age":"26"
						}
		Sample Response - {
							  "age": "26",
							  "lastModified": "2015-11-24T10:08:24.742+05:30",
							  "name": "anurag"
							}				
GET - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}
		Sample Response - {
							  "age": "26",
							  "lastModified": "2015-11-24T10:08:24.742+05:30",
							  "name": "anurag"
							}		
PUT - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}
		Sample Request - {
							"name":"anurag",
							"age":"45"
						}
		Sample Response - {
							  "age": "45",
							  "lastModified": "2015-11-24T10:08:24.742+05:30",
							  "name": "anurag"
							}				
DELETE - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}					