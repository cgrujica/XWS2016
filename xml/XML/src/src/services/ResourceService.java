package src.services;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Amdandman;
import src.rs.gov.parlament.propisi.Zakon;
import src.sessionbeans.ResourceDao;
import src.sessionbeans.ResourceDaoLocal;

@Path("/resurs")
public class ResourceService {

	@Context
	private ServletContext servletContext;
	
	//@EJB
	private ResourceDaoLocal resource;
	
	@GET
	@Path("/zakonij")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Zakon> getAllZakoniJson() {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		List<Zakon> docs = resource.getZakoni("all"); 
		
		return docs;
	}
	
	@GET
	@Path("/zakonipendingx")
    @Produces(MediaType.APPLICATION_XML)
	public List<Zakon> getPendingZakoniXml() {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		List<Zakon> docs = resource.getZakoni("pending"); 
		
		return docs;
	}
	
	@GET
	@Path("/zakonicompletedx")
    @Produces(MediaType.APPLICATION_XML)
	public List<Zakon> getCompletedZakoniXml() {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		List<Zakon> docs = resource.getZakoni("completed"); 
		
		return docs;
	}
	
	@GET
	@Path("/zakonix")
    @Produces(MediaType.APPLICATION_XML)
	public List<Zakon> getAllZakoniXml() {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		List<Zakon> docs = resource.getZakoni("all"); 
		
		return docs;
	}
	
	@GET
	@Path("/korisnici")
	@Produces(MediaType.APPLICATION_XML)
	public PrecednikSkupstine getPrec() throws JAXBException {
		resource = new ResourceDao("src.http.www_parlament_gov_rs.korisnici");
		PrecednikSkupstine docs = resource.getPrec();
		
		return docs;
	}
	
	@POST
	@Path("/addZakon")
	@Consumes(MediaType.APPLICATION_XML)
	public String addZakon(Zakon z) {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		
		File file = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
		boolean result = resource.addZakon(z, file);
		
		if(result == true) return "True";
		else return "False";
	}
	
	@GET
	@Path("/zakonij")
    @Produces(MediaType.APPLICATION_JSON)
	public Zakon getZakonByID(String id) {
		resource = new ResourceDao("src.rs.gov.parlament.propisi");
		Zakon zakon = resource.getZakonByID(id);
		return zakon;
	}
}
