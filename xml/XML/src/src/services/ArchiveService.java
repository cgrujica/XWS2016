package src.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

import src.rs.gov.parlament.propisi.Zakon;

//ne treba Path anotacija, klasa se koristi lokalno
public class ArchiveService {
	
	public ArchiveService() {
	}
	
	@Context
	private ServletContext servletContext;
	
	public boolean archive(Zakon z) throws HttpException, IOException, JAXBException {
  		
		// Get target URL
	    String strURL = "http://localhost:8080/ArchiveRESTService/rest/ArchiveService";

	    File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
	    File output = new File(tmpdir, "export.xml");
	    
	    JAXBContext context = JAXBContext.newInstance("rs.gov.parlament.propisi");
		
	    // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
     	Marshaller marshaller = context.createMarshaller();
	 		
	 	// Podešavanje marshaller-a
	 	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 		
	 	// Umesto System.out-a, može se koristiti FileOutputStream
	 	marshaller.marshal(z, output);
	    
	    // Prepare HTTP post
	    PostMethod post = new PostMethod(strURL);

	    post.setRequestEntity(new InputStreamRequestEntity(
	            new FileInputStream(output), output.length()));

	    post.setRequestHeader(
	            "Content-type", "application/xml; charset=ISO-8859-1");

	    // Get HTTP client
	    HttpClient httpclient = new HttpClient();

	    int result = -1;
	    
	    // Execute request
	    try {

	        result = httpclient.executeMethod(post);

	        // Display status code
	        System.out.println("Response status code: " + result);

	        // Display response
	        System.out.println("Response body: ");
	        System.out.println(post.getResponseBodyAsString());

	    } finally {
	        // Release current connection to the connection pool 
	        // once you are done
	        post.releaseConnection();
	    }

	    if(result == 200) {
	    	return true;
	    } else return false;
	}
}