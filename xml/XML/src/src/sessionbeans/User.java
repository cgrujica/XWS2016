package src.sessionbeans;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import src.http.www_parlament_gov_rs.korisnici.Odbornik;
import src.http.www_parlament_gov_rs.korisnici.PrecednikSkupstine;
import src.rs.gov.parlament.propisi.Identifiable;

@XmlRootElement(name = "user")
public class User extends Identifiable implements Serializable {

	private static final long serialVersionUID = 1L;
	private int private_id;
	private String korisnicko_ime;
	private String lozinka;
	private	String ime;
	private	String prezime;
	private String telefon;
	private String email;
	private String uloga;
	private BigInteger id;

	
	
	public User() {
	}


	@XmlElement
	public void setId(int id) {
		this.private_id = id;
	}

	


	
	@XmlElement
	@Override
	public void setId(BigInteger value) {
		id = value;

	}

	@Override
	public BigInteger getId() {
		// TODO Auto-generated method stub
		return id;
	}


	public int getPrivate_id() {
		return private_id;
	}

	@XmlElement
	public void setPrivate_id(int private_id) {
		this.private_id = private_id;
	}


	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}


	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUloga() {
		return uloga;
	}


	public void setUloga(String uloga) {
		this.uloga = uloga;
	}


	public User(int private_id, String korisnicko_ime, String lozinka,
			String ime, String prezime, String telefon, String email,
			String uloga, BigInteger id) {
		super();
		this.private_id = private_id;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.uloga = uloga;
		this.id = id;
	}
	
	public User(Odbornik o){
		ime = o.getGradjanin().getIme();
		prezime = o.getGradjanin().getPrezime();
		korisnicko_ime = o.getGradjanin().getKorisnickoIme();
		lozinka = o.getGradjanin().getLozinka();
		uloga = "odbornik";
	}
	
	public User(PrecednikSkupstine o){
		ime = o.getOdbornik().getGradjanin().getIme();
		prezime = o.getOdbornik().getGradjanin().getPrezime();
		korisnicko_ime = o.getOdbornik().getGradjanin().getKorisnickoIme();
		lozinka = o.getOdbornik().getGradjanin().getLozinka();
		uloga = "precednik";
	}
	
}