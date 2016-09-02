package src.sessionbeans;

import src.rs.gov.parlament.propisi.Zakon;

public interface TestDaoLocal extends GenericDaoLocal<Zakon, Long>{
	
	public String test();
}
