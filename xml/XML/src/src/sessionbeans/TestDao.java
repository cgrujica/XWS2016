package src.sessionbeans;

import java.io.IOException;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import src.rs.gov.parlament.propisi.Zakon;

@Stateless
@Local(TestDaoLocal.class)
public class TestDao extends GenericDao<Zakon, Long> implements TestDaoLocal{

	public static final String contextPath = "src.http.www_parlament_gov_rs.korisnici";
	
	public static final String schemaName = "klijent";
	
	public TestDao() {
		super(contextPath, schemaName);
	}

	@Override
	public String test() {
		
		try {
			em.insertInto();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test";
	}	
}
