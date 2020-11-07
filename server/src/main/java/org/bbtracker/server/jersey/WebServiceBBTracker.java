package org.bbtracker.server.jersey;

import com.google.gson.Gson;
import org.bbtracker.server.transfer.AddBabyRequest;
import org.bbtracker.server.transfer.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
	public Response signin(String s) {
        System.out.println("WS SOCIAL : SIGNIN request " + s);
        String fakeToken = UUID.randomUUID().toString();
        NewCookie cookiee = new NewCookie(Cookie, fakeToken, "/", null, "id token", 604800, false);
		System.out.println("WS SOCIAL : SIGNIN Success Cookie " + cookiee.toString() + " " +cookiee.getPath());
        return Response.ok(gson.toJson(fakeToken), MediaType.APPLICATION_JSON)
                .cookie(cookiee)
                .build();
	}

	@POST					@Path("/signup")
	public Response signup(SignupRequest s) {
		System.out.println("WS SOCIAL : SIGNUP request " + s);
		service.signup(s);
		String fakeToken = UUID.randomUUID().toString();
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
			AddBabyRequest request, @Context UriInfo uriInfo) {
		service.addBaby(request);
		return "pipo";
	}

    @GET
	@Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String all(@CookieParam(Cookie) Cookie cookie) throws NoCookie {
		System.out.println("WS SOCIAL : ALL REQUEST  with cookie ::: " + cookie);
        if (cookie == null) throw new NoCookie();
        // build the list
        List<String> res = Arrays.asList("Jo","Mo","To","Yo");
        return res.subList(0,new Random().nextInt(res.size())).toString();
    }

}
