package src.sessionbeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import src.database.EntityManagerMarkLogic;
import src.rs.gov.parlament.propisi.Identifiable;
import src.util.ClassUtils;


public abstract class GenericDao<T, ID extends Serializable> implements GenericDaoLocal<T, ID> {
    //extends Identifiable
	
	protected String contextPath;
	
	protected JAXBContext context;
	
	protected EntityManagerMarkLogic<T, ID> em;
	
	public GenericDao(String contextPath, String schemaName) {
		
		try {
			context = JAXBContext.newInstance(contextPath);
			em = new EntityManagerMarkLogic<T, ID>(schemaName, contextPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T persist(T entity) throws JAXBException, IOException {
		//TO-DO
		return null;
	}
	
	public T findById(ID id) throws IOException, JAXBException {
		//TO-DO
		return null;
	}

	public InputStream findBy(String xQuery, boolean wrap) throws IOException {
		//TO-DO
		return null;
	}
	
	public List<T> findAll() throws IOException, JAXBException {
		List<T> result;
		result = em.findAll();
		return result;
	}
	
	public void remove(ID id) throws IOException {
		//TO-DO
	}

	public T merge(T entity, ID id) throws IOException, JAXBException {
		//TO-DO
		return null;
	}
}
