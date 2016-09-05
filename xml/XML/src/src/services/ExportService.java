package src.services;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

public class ExportService {

	private ServletContext servletContext;
	
	private FopFactory fopFactory;

	private TransformerFactory transformerFactory;

	private Zakon z;
	
	public ExportService(ServletContext sc, Zakon z) throws SAXException, IOException {

		this.z = z;
		servletContext = sc;
		
		// Initialize FOP factory object
		fopFactory = FopFactory.newInstance(getFile("fop.xconf"));

		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	public void export() throws Exception {
		// Point to the XSL-FO file
		File xsltFile = getFile("zakon_template.xsl");

		// Create transformation source
		StreamSource transformSource = new StreamSource(xsltFile);

		File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
	    File output = new File(tmpdir, "zakon.xml");
	    
	    JAXBContext context = JAXBContext.newInstance("src.rs.gov.parlament.propisi");
		
	    // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
     	Marshaller marshaller = context.createMarshaller();
	 		
	 	// Podešavanje marshaller-a
	 	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 		
	 	// Umesto System.out-a, može se koristiti FileOutputStream
	 	marshaller.marshal(z, output);
		
		// Initialize the transformation subject
		StreamSource source = new StreamSource(output);

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();

		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory
				.newTransformer(transformSource);

		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent,
				outStream);

		// Resulting SAX events
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);

		// Generate PDF file
		File pdfFile = new File(tmpdir, z.getID() + ".pdf");

		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				pdfFile));
		out.write(outStream.toByteArray());

		System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath()
				+ "\" generated successfully.");
		out.close();

		System.out.println("[INFO] End.");
	}
	
	/**
	 * Read a resource for an example.
	 * 
	 * @param fileName
	 *            the name of the resource
	 * @return an input stream for the resource
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
