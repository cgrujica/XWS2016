package src.sessionbeans;

import java.io.File;
import java.util.List;

import org.w3c.dom.Document;

import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Amdandman;
import src.rs.gov.parlament.propisi.Zakon;

public interface ResourceDaoLocal extends GenericDaoLocal<Zakon, Long>{
    
	public Zakon getZakon();
	public List<Zakon> getZakoni();
	public PrecednikSkupstine getPrec();
	public boolean addZakon(Zakon z, File f);
}
