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
 * <p>Classe Java per immatricolatoDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="immatricolatoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idImmatricolazione" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dsTarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idVeicolo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dtInsert" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="dtInizio" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="dtFine" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="proprietario" type="{}proprietarioDTO" minOccurs="0"/&gt;
 *         &lt;element name="veicolo" type="{}veicoloDTO" minOccurs="0"/&gt;
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
@XmlType(name = "immatricolatoDTO", propOrder = {
    "idImmatricolazione",
    "dsTarga",
    "idVeicolo",
    "dtInsert",
    "dtInizio",
    "dtFine",
    "proprietario",
    "veicolo",
    "utenteC"
})
public class ImmatricolatoDTO {

    protected int idImmatricolazione;
    protected String dsTarga;
    protected int idVeicolo;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtInsert;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtInizio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtFine;
    protected ProprietarioDTO proprietario;
    protected VeicoloDTO veicolo;
    protected String utenteC;

    /**
     * Recupera il valore della proprietà idImmatricolazione.
     * 
     */
    public int getIdImmatricolazione() {
        return idImmatricolazione;
    }

    /**
     * Imposta il valore della proprietà idImmatricolazione.
     * 
     */
    public void setIdImmatricolazione(int value) {
        this.idImmatricolazione = value;
    }

    /**
     * Recupera il valore della proprietà dsTarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsTarga() {
        return dsTarga;
    }

    /**
     * Imposta il valore della proprietà dsTarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsTarga(String value) {
        this.dsTarga = value;
    }

    /**
     * Recupera il valore della proprietà idVeicolo.
     * 
     */
    public int getIdVeicolo() {
        return idVeicolo;
    }

    /**
     * Imposta il valore della proprietà idVeicolo.
     * 
     */
    public void setIdVeicolo(int value) {
        this.idVeicolo = value;
    }

    /**
     * Recupera il valore della proprietà dtInsert.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtInsert() {
        return dtInsert;
    }

    /**
     * Imposta il valore della proprietà dtInsert.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtInsert(XMLGregorianCalendar value) {
        this.dtInsert = value;
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
     * Recupera il valore della proprietà proprietario.
     * 
     * @return
     *     possible object is
     *     {@link ProprietarioDTO }
     *     
     */
    public ProprietarioDTO getProprietario() {
        return proprietario;
    }

    /**
     * Imposta il valore della proprietà proprietario.
     * 
     * @param value
     *     allowed object is
     *     {@link ProprietarioDTO }
     *     
     */
    public void setProprietario(ProprietarioDTO value) {
        this.proprietario = value;
    }

    /**
     * Recupera il valore della proprietà veicolo.
     * 
     * @return
     *     possible object is
     *     {@link VeicoloDTO }
     *     
     */
    public VeicoloDTO getVeicolo() {
        return veicolo;
    }

    /**
     * Imposta il valore della proprietà veicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link VeicoloDTO }
     *     
     */
    public void setVeicolo(VeicoloDTO value) {
        this.veicolo = value;
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
