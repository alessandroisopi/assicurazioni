//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 12:57:24 PM CEST 
//


package onyx.classi.generated;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per esitoRevisioneDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="esitoRevisioneDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idEsitoRevisione" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dsEsitoRevisione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtInizio" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="dtFine" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esitoRevisioneDTO", propOrder = {
    "idEsitoRevisione",
    "dsEsitoRevisione",
    "dtInizio",
    "dtFine"
})
public class EsitoRevisioneDTO {

    protected int idEsitoRevisione;
    protected String dsEsitoRevisione;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtInizio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtFine;

    /**
     * Recupera il valore della proprietà idEsitoRevisione.
     * 
     */
    public int getIdEsitoRevisione() {
        return idEsitoRevisione;
    }

    /**
     * Imposta il valore della proprietà idEsitoRevisione.
     * 
     */
    public void setIdEsitoRevisione(int value) {
        this.idEsitoRevisione = value;
    }

    /**
     * Recupera il valore della proprietà dsEsitoRevisione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsEsitoRevisione() {
        return dsEsitoRevisione;
    }

    /**
     * Imposta il valore della proprietà dsEsitoRevisione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsEsitoRevisione(String value) {
        this.dsEsitoRevisione = value;
    }

    /**
     * Recupera il valore della proprietà dtInizio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtInizio() {
        return dtInizio;
    }

    /**
     * Imposta il valore della proprietà dtInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtInizio(XMLGregorianCalendar value) {
        this.dtInizio = value;
    }

    /**
     * Recupera il valore della proprietà dtFine.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtFine() {
        return dtFine;
    }

    /**
     * Imposta il valore della proprietà dtFine.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtFine(XMLGregorianCalendar value) {
        this.dtFine = value;
    }

}
