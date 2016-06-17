//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.15 at 04:23:41 PM CEST 
//


package http.www_parlament_gov_rs.korisnici;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http//www.parlament.gov.rs/korisnici}odbornik"/&gt;
 *         &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}nonPositiveInteger"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "odbornik",
    "redniBroj"
})
@XmlRootElement(name = "precednik_skupstine")
public class PrecednikSkupstine {

    @XmlElement(required = true)
    protected Odbornik odbornik;
    @XmlElement(name = "redni_broj", required = true)
    @XmlSchemaType(name = "nonPositiveInteger")
    protected BigInteger redniBroj;

    /**
     * Gets the value of the odbornik property.
     * 
     * @return
     *     possible object is
     *     {@link Odbornik }
     *     
     */
    public Odbornik getOdbornik() {
        return odbornik;
    }

    /**
     * Sets the value of the odbornik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Odbornik }
     *     
     */
    public void setOdbornik(Odbornik value) {
        this.odbornik = value;
    }

    /**
     * Gets the value of the redniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRedniBroj() {
        return redniBroj;
    }

    /**
     * Sets the value of the redniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRedniBroj(BigInteger value) {
        this.redniBroj = value;
    }

}
