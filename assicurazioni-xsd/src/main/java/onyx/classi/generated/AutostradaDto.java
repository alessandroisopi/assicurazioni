//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 09:54:03 AM CEST 
//


package onyx.classi.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per autostradaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="autostradaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dsAutostrada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAutostrada" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autostradaDto", propOrder = {
    "codiceFiscale",
    "dsAutostrada",
    "dtFine",
    "dtInizio",
    "idAutostrada"
})
public class AutostradaDto {

    protected String codiceFiscale;
    protected String dsAutostrada;
    protected String dtFine;
    protected String dtInizio;
    protected int idAutostrada;

    /**
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà dsAutostrada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsAutostrada() {
        return dsAutostrada;
    }

    /**
     * Imposta il valore della proprietà dsAutostrada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsAutostrada(String value) {
        this.dsAutostrada = value;
    }

    /**
     * Recupera il valore della proprietà dtFine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFine() {
        return dtFine;
    }

    /**
     * Imposta il valore della proprietà dtFine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFine(String value) {
        this.dtFine = value;
    }

    /**
     * Recupera il valore della proprietà dtInizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInizio() {
        return dtInizio;
    }

    /**
     * Imposta il valore della proprietà dtInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInizio(String value) {
        this.dtInizio = value;
    }

    /**
     * Recupera il valore della proprietà idAutostrada.
     * 
     */
    public int getIdAutostrada() {
        return idAutostrada;
    }

    /**
     * Imposta il valore della proprietà idAutostrada.
     * 
     */
    public void setIdAutostrada(int value) {
        this.idAutostrada = value;
    }

}
