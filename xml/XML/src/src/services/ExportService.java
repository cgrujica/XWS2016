package src.services;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.xml.sax.SAXException;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import src.rs.gov.parlament.propisi.Zakon;
import src.util.ConnUtil;

@Path("export")
public class ExportService {

	@javax.ws.rs.core.Context
	private ServletContext servletContext;
	
	private FopFactory fopFactory;

	private TransformerFactory transformerFactory;

	public ExportService() {
	}

	@Path("/pdf")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String exportAsPDF(Zakon z) throws SAXException, IOException {
		
		fopFactory = FopFactory.newInstance(getFile("fop.xconf"));
		transformerFactory = new TransformerFactoryImpl();
		// Point to the XSL-FO file
		File xsltFile = null;
		try {
			xsltFile = getFile("zakon_template_pdf.xsl");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create transformation source
		StreamSource transformSource = new StreamSource(xsltFile);

		File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
	    File output = new File(tmpdir, z.getID() + "toPDF.xml");
	    
	    JAXBContext context;
		try {
			context = JAXBContext.newInstance("src.rs.gov.parlament.propisi");
			// Marshaller je objekat zadužen za konverziju iz objektnog u XML model
	     	Marshaller marshaller = context.createMarshaller();
		 		
		 	// Podešavanje marshaller-a
		 	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		 		
		 	// Umesto System.out-a, može se koristiti FileOutputStream
		 	marshaller.marshal(z, output);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		// Initialize the transformation subject
		StreamSource source = new StreamSource(output);

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();

		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer;
		try {
			xslFoTransformer = transformerFactory
					.newTransformer(transformSource);
			// Construct FOP instance with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent,
					outStream);

			// Resulting SAX events
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			xslFoTransformer.transform(source, res);
		} catch (FOPException | TransformerException e) {
			e.printStackTrace();
		}
		
		// Generate PDF file
		File pdfFile = new File(tmpdir, z.getID() + ".pdf");

		OutputStream out;
		try {
			out = new BufferedOutputStream(new FileOutputStream(
					pdfFile));
			out.write(outStream.toByteArray());

			System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath()
					+ "\" generated successfully.");
			out.close();

			System.out.println("[INFO] End.");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return "Zakon je eksportovan u PDF";
	}
	
	@Path("/xhtml")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String exportAsXHTML(Zakon z) throws SAXException, IOException {
		
		// Point to the XSL-FO file
		File xsltFile = null;
		try {
			xsltFile = getFile("zakon_template_xhtml.xsl");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
	    File output = new File(tmpdir, z.getID() + "XHTML.xml");
	    
	    JAXBContext context;
		try {
			context = JAXBContext.newInstance("src.rs.gov.parlament.propisi");
			// Marshaller je objekat zadužen za konverziju iz objektnog u XML model
	     	Marshaller marshaller = context.createMarshaller();
		 		
		 	// Podešavanje marshaller-a
		 	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		 	
		 	marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
		 		    "<?xml-stylesheet type=\"text/xsl\" href=\"zakon_template_xhtml.xsl\" ?>");
		 	
		 	// Umesto System.out-a, mode se koristiti FileOutputStream
		 	marshaller.marshal(z, output);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return "Zakon je eksportovan u XHTML";
	}
	
	/**
	 * Read a resource for an example.
	 * 
	 * @param fileName
	 *            the name of the resource
	 * @throws IOException
	 */
	public File getFile(String fileName) throws IOException {
		
		InputStream input = ConnUtil.class.getClassLoader().getResourceAsStream(fileName);
		
		File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
		File file = new File(tmpdir, fileName);
		OutputStream outputStream = new FileOutputStream(file);
		IOUtils.copy(input, outputStream);
		outputStream.close();
		return file;
	}
}
