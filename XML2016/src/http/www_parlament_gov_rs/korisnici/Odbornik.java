//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.15 at 04:23:41 PM CEST 
//


package http.www_parlament_gov_rs.korisnici;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{http//www.parlament.gov.rs/korisnici}gradjanin"/&gt;
 *         &lt;element name="broj_mesta" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
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
    "gradjanin",
    "brojMesta"
})
@XmlRootElement(name = "odbornik")
public class Odbornik {

    @XmlElement(required = true)
    protected Gradjanin gradjanin;
    @XmlElement(name = "broj_mesta", required = true)
    protected Object brojMesta;

    /**
     * Gets the value of the gradjanin property.
     * 
     * @return
     *     possible object is
     *     {@link Gradjanin }
     *     
     */
    public Gradjanin getGradjanin() {
        return gradjanin;
    }

    /**
     * Sets the value of the gradjanin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gradjanin }
     *     
     */
    public void setGradjanin(Gradjanin value) {
        this.gradjanin = value;
    }

    /**
     * Gets the value of the brojMesta property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBrojMesta() {
        return brojMesta;
    }

    /**
     * Sets the value of the brojMesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBrojMesta(Object value) {
        this.brojMesta = value;
    }

}
