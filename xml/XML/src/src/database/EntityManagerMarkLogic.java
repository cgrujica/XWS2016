package src.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

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
	
	public EntityManagerMarkLogic(String schemaName, String contextPath) throws JAXBException {
		setSchemaName(schemaName);
		setContextPath(contextPath);
		
		context = JAXBContext.newInstance(contextPath);
		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		unmarshaller = context.createUnmarshaller();
		
		marklogic_context = JAXBContext.newInstance(MARKLOGIC_CONTEXT_PATH);
		marklogic_unmarshaller = marklogic_context.createUnmarshaller();
	}
	
	@SuppressWarnings("unchecked")
	public T find(ID resourceId) throws IOException, JAXBException {
		//TO-DO
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws IOException, JAXBException {
		//TO-DO
		return null;
	}
	
	/*
	 * Takes both, XQuery and XUpdate statements.
	 */
	public InputStream executeQuery(String xQuery, boolean wrap) throws IOException {
		//TO-DO
		return null;
	}
	
	public void persist(T entity, Long id) throws JAXBException, IOException {
        //TO-DO
	}
	
	public void delete(ID resourceId) throws IOException {
		//TO-DO
	}
	
	public void update(T entity, ID resourceId) throws IOException, JAXBException {
		//TO-DO
	}

	/**
	 * Implements some sort of identity strategy, since it isn't natively supported by XMLDB.
	 * @return the next id value.
	 * @throws IOException
	 */
	public Long getIdentity() throws IOException {
        //TO-DO
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
