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

	1. POST - localhost:8080/RestfulSocialNetwork/webapi/authentication
	   	Request: 	Headers - username = <username>
					  password = <password> 	

	2. GET - localhost:8080/RestfulSocialNetwork/webapi/authentication
		  Request:		Headers - username = <username>
						  password = <password> 
		  Response: Cookie(Name="X-AUTH-TOKEN", Value=<RandonmToken>)  												Use this to access resources (Looking for JWT ?)


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

	1. GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/

	2. POST - localhost:8080/RestfulSocialNetwork/webapi/conversations/
		   Request - {
					"name":"SampleConversation",
					"author":"anurag"
				}
	3. GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}

	4. PUT - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}
		  Request - {
					"id"=<id>
					"name":"ChangedSampleConversation",
					"author":"anurag"
				}

	5. DELETE - localhost:8080/RestfulSocialNetwork/webapi/conversations/{id}	


Messages:
	1. GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages

	2. POST - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/
		 Request - {
					"message":"Is this you ?",
					"author":"anurag"
				}
		Response - {
  				      	"author": "anurag",
					"id": 1,
					"lastModified": "2015-11-24T10:04:03.866+05:30",
					"message": "Is this you ?"
				}				
	3. GET - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}
		Response - {
					"author": "anurag",
					"id": 1,
					"lastModified": "2015-11-24T10:04:03.866+05:30",
					"message": "Is this you ?"
				}			
	4. PUT - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}
		Request - {
					"id" : "1",
					"message":"Yes it is me ?",
					"author":"anurag"
				}
		Response - {
					"author": "anurag",
					"id": 1,
					"lastModified": "2015-11-24T10:04:03.866+05:30",
					"message": "Yes it is me ?"
				}		
	5. DELETE - localhost:8080/RestfulSocialNetwork/webapi/conversations/{conversationId}/messages/{messageId}

Profile:

	1. GET - localhost:8080/RestfulSocialNetwork/webapi/profiles/
	
	2. POST - localhost:8080/RestfulSocialNetwork/webapi/profiles/
		Request - {
					"name":"anurag",
					"age":"26"
				}
		Response - {
					"age": "26",
					"lastModified": "2015-11-24T10:08:24.742+05:30",
					"name": "anurag"
				}				
	3. GET - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}
		Response - {
					"age": "26",
					"lastModified": "2015-11-24T10:08:24.742+05:30",
					"name": "anurag"
				}		
	4. PUT - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}
		Request - {
					"name":"anurag",
					"age":"45"
				}
		Response - {
					"age": "45",
					"lastModified": "2015-11-24T10:08:24.742+05:30",
					"name": "anurag"
				}	

	5. DELETE - localhost:8080/RestfulSocialNetwork/webapi/profiles/{profileName}					
