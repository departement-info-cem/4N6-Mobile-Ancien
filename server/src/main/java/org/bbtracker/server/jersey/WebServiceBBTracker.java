package org.bbtracker.server.jersey;

import com.google.gson.Gson;
import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.exceptions.Existing;
import org.bbtracker.server.service.Service;
import org.bbtracker.server.transfer.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.UUID;

@Path("/")
public class WebServiceBBTracker {

	@Autowired // Spring finds automatically the @Component that fits the interface
	private Service service;

    public static class NoCookie extends Exception{}

	public final static String Cookie = "votvot-id";

	private Gson gson;

	public WebServiceBBTracker() {
		gson = new Gson();
	}

	@POST
	@Path("/signin")
	public Response signin(SigninRequest s) throws BadCredentials {
        System.out.println("WS SOCIAL : SIGNIN request " + s);
        SigninResponse resp = service.signin(s);
        String fakeToken = UUID.randomUUID().toString();
        NewCookie cookiee = new NewCookie(Cookie, fakeToken, "/", null, "id token", 604800, false);
		System.out.println("WS SOCIAL : SIGNIN Success Cookie " + cookiee.toString() + " " +cookiee.getPath());
        return Response.ok(gson.toJson(resp), MediaType.APPLICATION_JSON)
                .cookie(cookiee)
                .build();
	}

	@POST					@Path("/signup")
	public Response signup(SignupRequest s) throws BadCredentials {
		System.out.println("WS SOCIAL : SIGNUP request " + s);
		service.signup(s);
		String fakeToken = UUID.randomUUID().toString();
		// TODO token and storage
		NewCookie cookiee = new NewCookie(Cookie, fakeToken, "/", null, "id token", 604800, false);
		System.out.println("WS SOCIAL : SIGNIN Success Cookie " + cookiee.toString() + " " +cookiee.getPath());
		return Response.ok(gson.toJson(fakeToken),MediaType.APPLICATION_JSON)
				.cookie(cookiee)
				.build();
	}

	@GET					@Path("/signout")
	//@Produces(MediaType.APPLICATION_JSON)
	public Response signout(@CookieParam(Cookie) Cookie cookie) {
		// todo the service signout by erasing the token
		System.out.println("WS SOCIAL : SIGNOUT REQUEST " + cookie);
		// erase the cookie
		if (cookie == null) return Response.ok("No cookie",MediaType.TEXT_PLAIN).build();
		System.out.println("WS SOCIAL : SIGNOUT REQUEST forge new cookie to die " );
		NewCookie toDelete = new NewCookie(Cookie, null, "/", null, null, 0, false);
        Response res = Response.ok(gson.toJson(true),MediaType.TEXT_PLAIN)
				.cookie(toDelete)
				.build();
		System.out.println("WS SOCIAL : SIGNOUT REQUEST forgeD "+toDelete );
		return res;
	}

	@POST @Path("/addbaby")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addBaby(
			AddBabyRequest request, @Context UriInfo uriInfo) throws Existing {
		service.addBaby(request);
		return "pipo";
	}

    @GET
	@Path("/home/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BabyHomeResponse> home(@CookieParam(Cookie) Cookie cookie, @PathParam("id") long id) throws NoCookie {
		System.out.println("WS SOCIAL : HOME REQUEST  with cookie ::: " + cookie);
        return service.home(id);
    }

}
