package src.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;

import src.com.marklogic.rest.Result;
import src.com.marklogic.rest.Results;
import src.util.ClassUtils;
import src.util.ConnUtil;
import src.util.ConnUtil.ConnectionProperties;

public class EntityManagerMarkLogic<T, ID extends Serializable> {

	public static final String REST_URL = "http://147.91.177.194:8000";

	public static final String MARKLOGIC_CONTEXT_PATH = "com.marklogic.rest";

	private String schemaName;

	private String contextPath;

	private Marshaller marshaller;

	private Unmarshaller unmarshaller, marklogic_unmarshaller;

	private JAXBContext context, marklogic_context;

	private URL url;

	private HttpURLConnection conn;

	private static DatabaseClient client;

	ConnectionProperties props;

	public EntityManagerMarkLogic(String schemaName, String contextPath)
			throws JAXBException {
		setSchemaName(schemaName);
		setContextPath(contextPath);

		try {
			context = JAXBContext.newInstance(ClassUtils
					.getClasses(contextPath));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		unmarshaller = context.createUnmarshaller();

		try {
			marklogic_context = JAXBContext.newInstance(ClassUtils
					.getClasses(MARKLOGIC_CONTEXT_PATH));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marklogic_unmarshaller = marklogic_context.createUnmarshaller();
	}

	@SuppressWarnings("unchecked")
	public T find(ID resourceId) throws IOException, JAXBException {
		// TO-DO
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws IOException, JAXBException {
		Results wrappedResults = null;
		List<T> results = new ArrayList<T>();

		props = ConnUtil.loadProperties();

		if (client == null) {
			client = DatabaseClientFactory.newClient(props.host, props.port,
					props.user, props.password, props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port,
					props.database, props.user, props.password, props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		String docId = "/example/books.xml";
		String testDocId = "/example/test/books.xml";

		File f = new File("C:\\Users\\Danilo\\Documents\\primer zakona.xml");

		FileInputStream fi = new FileInputStream(f);

		// Create an input stream handle to hold XML content.
		InputStreamHandle handle = new InputStreamHandle(fi);

		// Write the document to the database
		System.out.println("[INFO] Inserting \"" + docId + "\" to \""
				+ props.database + "\" database.");
		xmlManager.write(docId, handle);

		System.out.println("[INFO] Verify the content at: http://" + props.host
				+ ":8000/v1/documents?database=" + props.database + "&uri="
				+ docId);

		// Release the client
		client.release();
		return results;
	}

	/*
	 * Takes both, XQuery and XUpdate statements.
	 */
	public InputStream executeQuery(String xQuery, boolean wrap)
			throws IOException {
		// TO-DO
		return null;
	}

	public void persist(T entity, Long id) throws JAXBException, IOException {
		// TO-DO
	}

	public void delete(ID resourceId) throws IOException {
		// TO-DO
	}

	public void update(T entity, ID resourceId) throws IOException,
			JAXBException {
		// TO-DO
	}

	/**
	 * Implements some sort of identity strategy, since it isn't natively
	 * supported by XMLDB.
	 * 
	 * @return the next id value.
	 * @throws IOException
	 */
	public Long getIdentity() throws IOException {
		// TO-DO
		return null;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public Marshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public JAXBContext getContext() {
		return context;
	}

	public void setContext(JAXBContext context) {
		this.context = context;
	}
}
