package org.bbtracker;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/employees")
public class EmployeeResource {
 
//    @Autowired
    private Service employeeRepository;
 
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String getEmployee(@PathParam("id") int id) {
        return "yo " + id;
    }


}