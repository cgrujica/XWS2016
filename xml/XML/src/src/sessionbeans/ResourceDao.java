package src.sessionbeans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;

import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Amdandman;
import src.rs.gov.parlament.propisi.Zakon;

@Stateless
@Local(ResourceDaoLocal.class)
public class ResourceDao extends GenericDao<Zakon, Long> implements ResourceDaoLocal{

    public static final String schemaName = "Zakon";
	
	public ResourceDao(String contextPath) {
		super(contextPath, schemaName);
	}
	
	@Override
	public Zakon getZakon() {
		Zakon docs = new Zakon();
		try {
			 docs = em.findZakon();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
		return docs;
	}
	
	@Override
	public PrecednikSkupstine getPrec() {
		PrecednikSkupstine docs = new PrecednikSkupstine();
		try {
			 docs = em.findPrec();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
		return docs;
	}

	@Override
	public List<Zakon> getZakoni(String kolekcija) {
		List<Zakon> docs = new ArrayList<Zakon>();
		try {
			 docs = em.findZakoni(kolekcija);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
		return docs;
	}
	
	@Override
	public boolean addZakon(Zakon z, File f) {
		try {
			return em.addZakon(z, f);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
