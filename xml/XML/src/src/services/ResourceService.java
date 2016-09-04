package src.services;

import java.io.File;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Amdandman;
import src.rs.gov.parlament.propisi.Zakon;
import src.sessionbeans.ResourceDao;
import src.sessionbeans.ResourceDaoLocal;

@Path("resurs")
public class ResourceService {

	//@EJB
	private ResourceDaoLocal resource;
	
	@GET
	@Path("zakoni")
    @Produces(MediaType.APPLICATION_XML)
	public Zakon getAllAm() {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		Zakon docs = resource.getZakon(); 
		
		return docs;
	}
	
	@GET
	@Path("korisnici")
	@Produces(MediaType.APPLICATION_XML)
	public PrecednikSkupstine getPrec() throws JAXBException {
		resource = new ResourceDao("src.http.www_parlament_gov_rs.korisnici");
		PrecednikSkupstine docs = resource.getPrec();
		
		return docs;
	}
}
