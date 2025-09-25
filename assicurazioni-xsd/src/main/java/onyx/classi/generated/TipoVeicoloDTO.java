//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 12:19:43 PM CEST 
//


package onyx.classi.generated;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tipoVeicoloDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="tipoVeicoloDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTipoVeicolo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dsTipoVeicolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtInizio" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="dtFine" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="utenteC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoVeicoloDTO", propOrder = {
    "idTipoVeicolo",
    "dsTipoVeicolo",
    "dtInizio",
    "dtFine",
    "utenteC"
})
public class TipoVeicoloDTO {

    protected int idTipoVeicolo;
    protected String dsTipoVeicolo;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtInizio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtFine;
    protected String utenteC;

    /**
     * Recupera il valore della proprietà idTipoVeicolo.
     * 
     */
    public int getIdTipoVeicolo() {
        return idTipoVeicolo;
    }

    /**
     * Imposta il valore della proprietà idTipoVeicolo.
     * 
     */
    public void setIdTipoVeicolo(int value) {
        this.idTipoVeicolo = value;
    }

    /**
     * Recupera il valore della proprietà dsTipoVeicolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsTipoVeicolo() {
        return dsTipoVeicolo;
    }

    /**
     * Imposta il valore della proprietà dsTipoVeicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsTipoVeicolo(String value) {
        this.dsTipoVeicolo = value;
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

    /**
     * Recupera il valore della proprietà utenteC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtenteC() {
        return utenteC;
    }

    /**
     * Imposta il valore della proprietà utenteC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtenteC(String value) {
        this.utenteC = value;
    }

}
