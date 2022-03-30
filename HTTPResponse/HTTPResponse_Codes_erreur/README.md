# Successful responses  
## 200 OK  
The request has succeeded. The meaning of the success depends on the HTTP method:  
GET: The resource has been fetched and is transmitted in the message body.  
HEAD: The entity headers are in the message body.  
PUT or POST: The resource describing the result of the action is transmitted in the message body.  
TRACE: The message body contains the request message as received by the server.  
<br />
## 201 Created  
The request has succeeded and a new resource has been created as a result. This is typically the response sent after POST requests, or some PUT requests.  
<br />
## 202 Accepted  
The request has been received but not yet acted upon. It is noncommittal, since there is no way in HTTP to later send an asynchronous response indicating the outcome of the request. It is intended for cases where another process or server handles the request, or for batch processing.  
<br />
<br />
# Redirection messages  
## 300 Multiple Choice  
The request has more than one possible response. The user-agent or user should choose one of them. (There is no standardized way of choosing one of the responses, but HTML links to the possibilities are recommended so the user can pick.)  
<br />
## 301 Moved Permanently  
The URL of the requested resource has been changed permanently. The new URL is given in the response. 
<br />
## 302 Found  
This response code means that the URI of requested resource has been changed temporarily. Further changes in the URI might be made in the future. Therefore, this same URI should be used by the client in future requests.  
<br />
## 307 Temporary Redirect  
The server sends this response to direct the client to get the requested resource at another URI with same method that was used in the prior request. This has the same semantics as the 302 Found HTTP response code, with the exception that the user agent must not change the HTTP method used: If a POST was used in the first request, a POST must be used in the second request.  
<br />
## 308 Permanent Redirect  
This means that the resource is now permanently located at another URI, specified by the Location: HTTP Response header. This has the same semantics as the 301 Moved Permanently HTTP response code, with the exception that the user agent must not change the HTTP method used: If a POST was used in the first request, a POST must be used in the second request.  
<br />
<br />
# Client error responses  
## 400 Bad Request  
The server could not understand the request due to invalid syntax.  
<br />
## 401 Unauthorized  
Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". That is, the client must authenticate itself to get the requested response.  
<br />
## 402 Payment Required  
This response code is reserved for future use. The initial aim for creating this code was using it for digital payment systems, however this status code is used very rarely and no standard convention exists.  
<br />
## 403 Forbidden  
The client does not have access rights to the content; that is, it is unauthorized, so the server is refusing to give the requested resource. Unlike 401, the client's identity is known to the server.  
<br />
## 404 Not Found  
The server can not find the requested resource. In the browser, this means the URL is not recognized. In an API, this can also mean that the endpoint is valid but the resource itself does not exist. Servers may also send this response instead of 403 to hide the existence of a resource from an unauthorized client. This response code is probably the most famous one due to its frequent occurrence on the web.  
<br />
## 405 Method Not Allowed  
The request method is known by the server but has been disabled and cannot be used. For example, an API may forbid DELETE-ing a resource. The two mandatory methods, GET and HEAD, must never be disabled and should not return this error code.  
<br />
## 406 Not Acceptable  
This response is sent when the web server, after performing server-driven content negotiation, doesn't find any content that conforms to the criteria given by the user agent.  
<br />
##  408 Request Timeout  
This response is sent on an idle connection by some servers, even without any previous request by the client. It means that the server would like to shut down this unused connection. This response is used much more since some browsers, like Chrome, Firefox 27+, or IE9, use HTTP pre-connection mechanisms to speed up surfing. Also note that some servers merely shut down the connection without sending this message.  
## 415 Unsupported Media Type  
The media format of the requested data is not supported by the server, so the server is rejecting the request.  
<br />
## 429 Too Many Requests  
The user has sent too many requests in a given amount of time ("rate limiting").  
<br />
<br />
# Server error responses  
## 500 Internal Server Error  
The server has encountered a situation it doesn't know how to handle.  
<br />
## 501 Not Implemented  
The request method is not supported by the server and cannot be handled. The only methods that servers are required to support (and therefore that must not return this code) are GET and HEAD.  
<br />
## 502 Bad Gateway  
This error response means that the server, while working as a gateway to get a response needed to handle the request, got an invalid response.  
<br />
## 503 Service Unavailable  
The server is not ready to handle the request. Common causes are a server that is down for maintenance or that is overloaded. Note that together with this response, a user-friendly page explaining the problem should be sent. This responses should be used for temporary conditions and the Retry-After: HTTP header should, if possible, contain the estimated time before the recovery of the service. The webmaster must also take care about the caching-related headers that are sent along with this response, as these temporary condition responses should usually not be cached.  
<br />
## 505 HTTP Version Not Supported  
The HTTP version used in the request is not supported by the server.
