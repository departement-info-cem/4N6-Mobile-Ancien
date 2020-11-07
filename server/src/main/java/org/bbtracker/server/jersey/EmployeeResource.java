package org.bbtracker.server.jersey;

//import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {
 
//    @Autowired
    //private Service employeeRepository;
 
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String getEmployee(@PathParam("id") int id) {
        return "yo " + id;
    }


}