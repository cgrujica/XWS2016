//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.15 at 04:21:55 PM CEST 
//


package src.rs.gov.parlament.propisi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.gov.parlament.propisi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClanNaslov_QNAME = new QName("http://www.parlament.gov.rs/propisi", "naslov");
    private final static QName _ClanSadrzaj_QNAME = new QName("http://www.parlament.gov.rs/propisi", "sadrzaj");
    private final static QName _ClanSadrzajStav_QNAME = new QName("http://www.parlament.gov.rs/propisi", "stav");
    private final static QName _ClanSadrzajStavTacka_QNAME = new QName("http://www.parlament.gov.rs/propisi", "tacka");
    private final static QName _ClanSadrzajStavTackaPodtacka_QNAME = new QName("http://www.parlament.gov.rs/propisi", "podtacka");
    private final static QName _ClanSadrzajStavTackaPodtackaAlinea_QNAME = new QName("http://www.parlament.gov.rs/propisi", "alinea");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.gov.parlament.propisi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Zakon }
     * 
     */
    public Zakon createZakon() {
        return new Zakon();
    }

    /**
     * Create an instance of {@link Clan }
     * 
     */
    public Clan createClan() {
        return new Clan();
    }

    /**
     * Create an instance of {@link Clan.Sadrzaj }
     * 
     */
    public Clan.Sadrzaj createClanSadrzaj() {
        return new Clan.Sadrzaj();
    }

    /**
     * Create an instance of {@link Clan.Sadrzaj.Stav }
     * 
     */
    public Clan.Sadrzaj.Stav createClanSadrzajStav() {
        return new Clan.Sadrzaj.Stav();
    }

    /**
     * Create an instance of {@link Clan.Sadrzaj.Stav.Tacka }
     * 
     */
    public Clan.Sadrzaj.Stav.Tacka createClanSadrzajStavTacka() {
        return new Clan.Sadrzaj.Stav.Tacka();
    }

    /**
     * Create an instance of {@link Clan.Sadrzaj.Stav.Tacka.Podtacka }
     * 
     */
    public Clan.Sadrzaj.Stav.Tacka.Podtacka createClanSadrzajStavTackaPodtacka() {
        return new Clan.Sadrzaj.Stav.Tacka.Podtacka();
    }

    /**
     * Create an instance of {@link Zakon.Deo }
     * 
     */
    public Zakon.Deo createZakonDeo() {
        return new Zakon.Deo();
    }

    /**
     * Create an instance of {@link Zakon.Deo.Glava }
     * 
     */
    public Zakon.Deo.Glava createZakonDeoGlava() {
        return new Zakon.Deo.Glava();
    }

    /**
     * Create an instance of {@link Zakon.Deo.Glava.Odeljak }
     * 
     */
    public Zakon.Deo.Glava.Odeljak createZakonDeoGlavaOdeljak() {
        return new Zakon.Deo.Glava.Odeljak();
    }

    /**
     * Create an instance of {@link Amdandman }
     * 
     */
    public Amdandman createAmdandman() {
        return new Amdandman();
    }

    /**
     * Create an instance of {@link Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea }
     * 
     */
    public Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea createClanSadrzajStavTackaPodtackaAlinea() {
        return new Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea();
    }

    /**
     * Create an instance of {@link Zakon.Deo.Glava.Odeljak.Pododeljak }
     * 
     */
    public Zakon.Deo.Glava.Odeljak.Pododeljak createZakonDeoGlavaOdeljakPododeljak() {
        return new Zakon.Deo.Glava.Odeljak.Pododeljak();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "naslov", scope = Clan.class)
    public JAXBElement<String> createClanNaslov(String value) {
        return new JAXBElement<String>(_ClanNaslov_QNAME, String.class, Clan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Sadrzaj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "sadrzaj", scope = Clan.class)
    public JAXBElement<Clan.Sadrzaj> createClanSadrzaj(Clan.Sadrzaj value) {
        return new JAXBElement<Clan.Sadrzaj>(_ClanSadrzaj_QNAME, Clan.Sadrzaj.class, Clan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Sadrzaj.Stav }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "stav", scope = Clan.Sadrzaj.class)
    public JAXBElement<Clan.Sadrzaj.Stav> createClanSadrzajStav(Clan.Sadrzaj.Stav value) {
        return new JAXBElement<Clan.Sadrzaj.Stav>(_ClanSadrzajStav_QNAME, Clan.Sadrzaj.Stav.class, Clan.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Sadrzaj.Stav.Tacka }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "tacka", scope = Clan.Sadrzaj.Stav.class)
    public JAXBElement<Clan.Sadrzaj.Stav.Tacka> createClanSadrzajStavTacka(Clan.Sadrzaj.Stav.Tacka value) {
        return new JAXBElement<Clan.Sadrzaj.Stav.Tacka>(_ClanSadrzajStavTacka_QNAME, Clan.Sadrzaj.Stav.Tacka.class, Clan.Sadrzaj.Stav.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Sadrzaj.Stav.Tacka.Podtacka }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "podtacka", scope = Clan.Sadrzaj.Stav.Tacka.class)
    public JAXBElement<Clan.Sadrzaj.Stav.Tacka.Podtacka> createClanSadrzajStavTackaPodtacka(Clan.Sadrzaj.Stav.Tacka.Podtacka value) {
        return new JAXBElement<Clan.Sadrzaj.Stav.Tacka.Podtacka>(_ClanSadrzajStavTackaPodtacka_QNAME, Clan.Sadrzaj.Stav.Tacka.Podtacka.class, Clan.Sadrzaj.Stav.Tacka.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.parlament.gov.rs/propisi", name = "alinea", scope = Clan.Sadrzaj.Stav.Tacka.Podtacka.class)
    public JAXBElement<Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea> createClanSadrzajStavTackaPodtackaAlinea(Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea value) {
        return new JAXBElement<Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea>(_ClanSadrzajStavTackaPodtackaAlinea_QNAME, Clan.Sadrzaj.Stav.Tacka.Podtacka.Alinea.class, Clan.Sadrzaj.Stav.Tacka.Podtacka.class, value);
    }

}
