package src.services;

import java.math.BigInteger;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import src.sessionbeans.SessionDao;

@Path("session")
public class SessionService {
	
    //@EJB
    private SessionDao session;
	
    @PUT
    @Path("/{id}/{z}/{p}/{u}")
    public String changeStatus(@PathParam("id") int id, 
    		                   @PathParam("z") int z,
    		                   @PathParam("p") int p,
    		                   @PathParam("u") int u) {
    	session = new SessionDao("src.rs.gov.parlament.propisi");
    	session.countResults(id, z, p, u);
    	
    	return "True";
    }
}
