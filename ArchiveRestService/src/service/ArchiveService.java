package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import rs.gov.parlament.propisi.Zakon;

@Path("ArchiveService")
public class ArchiveService {

	@Context
	private ServletContext servletContext;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String response(Zakon zakon) throws JAXBException, IOException {
		File tmpdir = (File) servletContext
				.getAttribute("javax.servlet.context.tempdir");

		if (null != tmpdir) {

			// Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
			JAXBContext context = JAXBContext
					.newInstance("rs.gov.parlament.propisi");

			// Marshaller je objekat zadužen za konverziju iz objektnog u XML
			// model
			Marshaller marshaller = context.createMarshaller();

			// Podešavanje marshaller-a
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			File targetFile = new File(tmpdir, zakon.getID() + ".xml");

			System.out.println("Fajl je u "
					+ targetFile.getCanonicalPath().toString());

			// Umesto System.out-a, može se koristiti FileOutputStream
			marshaller.marshal(zakon, targetFile);

			return "Zakon je prosledjen";
		} else
			return "Zakon nije prosledjen";

	}
}