package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import rs.gov.parlament.propisi.Zakon;

@Path("ArchiveService")
public class ArchiveService {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String response(Zakon z) {
  		
       if(z != null) {
			return "Zakon je prosledjen";
		} else
			return "Zakon nije prosledjen";

	}
}