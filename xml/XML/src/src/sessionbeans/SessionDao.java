package src.sessionbeans;

import java.io.IOException;
import java.math.BigInteger;

import src.rs.gov.parlament.propisi.Zakon;

public class SessionDao extends GenericDao<Zakon, Long> implements SessionDaoLocal{

	public static final String schemaName = "Zakon";
	
	public SessionDao(String contextPath) {
		super(contextPath, schemaName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void countResults(int id, int z, int p, int u) {
		if(z > (z+p+u)/2) { //ako je broj glasova za veci od polovine glasova
			try {
				em.updateZakon(id);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				em.deleteZakon(id);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	
}
