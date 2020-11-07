package org.bbtracker.server.jersey;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by joris on 15-10-15.
 */
@Provider
public class CatchAllMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        return Response.status(Response.Status.BAD_REQUEST).entity(ex.getClass().getSimpleName()).build();
    }

}