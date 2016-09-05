package src.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.eval.EvalResult;
import com.marklogic.client.eval.EvalResultIterator;
import com.marklogic.client.eval.ServerEvaluationCall;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.query.ExtractedResult;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.marklogic.client.query.StructuredQueryBuilder;
import com.marklogic.client.query.StructuredQueryDefinition;
import com.marklogic.client.util.EditableNamespaceContext;
import com.sun.org.apache.bcel.internal.generic.NEW;

import src.com.marklogic.rest.Result;
import src.com.marklogic.rest.Results;
import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Amdandman;
import src.rs.gov.parlament.propisi.Zakon;
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
		
	private static TransformerFactory transformerFactory;

	static {
		transformerFactory = TransformerFactory.newInstance();
	}

	public EntityManagerMarkLogic(String schemaName, String contextPath) throws JAXBException {
		setSchemaName(schemaName);
		setContextPath(contextPath);

		context = JAXBContext.newInstance(contextPath);

		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		unmarshaller = context.createUnmarshaller();

		try {
			marklogic_context = JAXBContext.newInstance(ClassUtils.getClasses(MARKLOGIC_CONTEXT_PATH));
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
		List<T> results = new ArrayList<T>();

		props = ConnUtil.loadProperties();

		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		// A handle to receive the document's content.
		DOMHandle content = new DOMHandle();

		// A metadata handle for metadata retrieval
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();

		String docId = "/example/books.xml";

		xmlManager.read(docId, metadata, content);

		// Retrieving a document node form DOM handle.
		Document doc = content.get();

		// Serializing DOM tree to standard output.
		System.out.println("[INFO] Retrieved content:");
		transform(doc, System.out);

		results.add((T) doc);

		client.release();
		return results;
	}

	/*
	 * Takes both, XQuery and XUpdate statements.
	 */
	public InputStream executeQuery(String xQuery, boolean wrap) throws IOException {
		// TO-DO
		return null;
	}

	public void persist(T entity, Long id) throws JAXBException, IOException {
		// TO-DO
	}

	public void delete(ID resourceId) throws IOException {
		// TO-DO
	}

	public void update(T entity, ID resourceId) throws IOException, JAXBException {
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

	@SuppressWarnings("unchecked")
	public void saveClient()  {

		try {
			props = ConnUtil.loadProperties();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		String docId = "/example/klijent.xml";

		File f = new File("F:\\FAX\\XML-2016\\PROJEKAT\\primer klijenta.xml");

		FileInputStream fi = null;
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create an input stream handle to hold XML content.
		InputStreamHandle handle = new InputStreamHandle(fi);

		// Write the document to the database
		System.out.println("[INFO] Inserting \"" + docId + "\" to \"" + props.database + "\" database.");
		xmlManager.write(docId, handle);

		System.out.println("[INFO] Verify the content at: http://" + props.host + ":8000/v1/documents?database="
				+ props.database + "&uri=" + docId);

		// Release the client
		client.release();
	}

	public void insertInto() throws IOException {
		props = ConnUtil.loadProperties();

		if (client == null) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		String docId = "/example/books.xml";

		File f = new File("F:\\FAX\\XML-2016\\PROJEKAT\\primer zakona.xml");

		FileInputStream fi = new FileInputStream(f);

		// Create an input stream handle to hold XML content.
		InputStreamHandle handle = new InputStreamHandle(fi);

		// Write the document to the database
		System.out.println("[INFO] Inserting \"" + docId + "\" to \"" + props.database + "\" database.");
		xmlManager.write(docId, handle);

		System.out.println("[INFO] Verify the content at: http://" + props.host + ":8000/v1/documents?database="
				+ props.database + "&uri=" + docId);

		// Release the client
		client.release();
	}

	/**
	 * Serializes DOM tree to an arbitrary OutputStream.
	 *
	 * @param node
	 *            a node to be serialized
	 * @param out
	 *            an output stream to write the serialized DOM representation to
	 * 
	 */
	private static void transform(Node node, OutputStream out) {
		try {

			// Kreiranje instance objekta zaduzenog za serijalizaciju DOM modela
			Transformer transformer = transformerFactory.newTransformer();

			// Indentacija serijalizovanog izlaza
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Nad "source" objektom (DOM stablo) vrši se transformacija
			DOMSource source = new DOMSource(node);

			// Rezultujući stream (argument metode)
			StreamResult result = new StreamResult(out);

			// Poziv metode koja vrši opisanu transformaciju
			transformer.transform(source, result);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Zakon findZakon() throws IOException, JAXBException {
		Zakon results = null;

		props = ConnUtil.loadProperties();

		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		// A handle to receive the document's content.
		DOMHandle content = new DOMHandle();

		// A metadata handle for metadata retrieval
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();

		String docId = "/example/zakon.xml";

		xmlManager.read(docId, metadata, content);

		// Retrieving a document node form DOM handle.
		Document doc = content.get();

		// Serializing DOM tree to standard output.
		System.out.println("[INFO] Retrieved content:");
		// transform(doc, System.out);

		Zakon r = (Zakon) unmarshaller.unmarshal(doc);
		results = r;

		client.release();
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Zakon> findZakoni() throws IOException, JAXBException {
		List<Zakon> results = new ArrayList<Zakon>();

		props = ConnUtil.loadProperties();

		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		// Initialize XQuery invoker object
		ServerEvaluationCall invoker = client.newServerEval();

		// Read the file contents into a string object
		String query = "fn:collection(\"/zakon/example\")";

		// Invoke the query
		invoker.xquery(query);

		// Interpret the results
		EvalResultIterator response = invoker.eval();

		System.out.print("[INFO] Response: ");

		if (response.hasNext()) {

			for (EvalResult result : response) {
				System.out.println("\n" + result.getString());
				StringReader st = new StringReader(result.getString());
				results.add((Zakon) unmarshaller.unmarshal(st));
			}
		} else {
			System.out.println("your query returned an empty sequence.");
		}

		client.release();
		return results;
	}

	@SuppressWarnings("unchecked")
	public PrecednikSkupstine findPrec() throws IOException, JAXBException {
		PrecednikSkupstine results = null;

		props = ConnUtil.loadProperties();

		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		// A handle to receive the document's content.
		DOMHandle content = new DOMHandle();

		// A metadata handle for metadata retrieval
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();

		String docId = "/example/books.xml";

		xmlManager.read(docId, metadata, content);

		// Retrieving a document node form DOM handle.
		Document doc = content.get();

		// Serializing DOM tree to standard output.
		System.out.println("[INFO] Retrieved content:");
		// transform(doc, System.out);

		JAXBContext cont = JAXBContext.newInstance("src.http.www_parlament_gov_rs.korisnici");
		Unmarshaller un = cont.createUnmarshaller();

		// Unmarshalling generiše objektni model na osnovu XML fajla //new
		// File("C:\\Users\\Danilo\\Documents\\korisnik.xml"
		results = (PrecednikSkupstine) un.unmarshal(doc);

		client.release();
		return results;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean checkAccount(String username, String password) throws IOException, JAXBException {
		boolean valid = false;
		Zakon results = null;

		props = ConnUtil.loadProperties();

		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}
		
		QueryManager queryMgr = client.newQueryManager();
		SearchHandle handle = new SearchHandle();
		KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
		query.put(queryMgr.newElementLocator(new QName("korisnicko_ime")),username);
		queryMgr.search(query, handle);
		MatchDocumentSummary matches1[] = handle.getMatchResults();
		//Document resultsDocument = handle.get();
		
		SearchHandle handle2 = new SearchHandle();
		KeyValueQueryDefinition query2 = queryMgr.newKeyValueDefinition();
		query2.put(queryMgr.newElementLocator(new QName("lozinka")),password);
		queryMgr.search(query2, handle2);
		MatchDocumentSummary matches2[] = handle2.getMatchResults();
		
		MatchLocation[] user = matches1[0].getMatchLocations();
		MatchLocation[] pass = matches2[0].getMatchLocations();
		for(int i=0;i<user.length;i++)
		{
			for (int y=0;y<pass.length;y++)
			{
				if(user[i].getPath().equals(pass[y].getPath()))
				{
					valid = true;
				}
			}
		}

		// Release the client
		client.release();
		
		
		return valid;
	}
}
