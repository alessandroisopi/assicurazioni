//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 12:19:43 PM CEST 
//


package onyx.classi.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tipoTransitoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="tipoTransitoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dsTipoTransito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "tipoTransitoDto", propOrder = {
    "dsTipoTransito",
    "dtFine",
    "dtInizio",
    "id",
    "utenteC"
})
public class TipoTransitoDto {

    protected String dsTipoTransito;
    protected String dtFine;
    protected String dtInizio;
    protected Integer id;
    protected String utenteC;

    /**
     * Recupera il valore della proprietà dsTipoTransito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsTipoTransito() {
        return dsTipoTransito;
    }

    /**
     * Imposta il valore della proprietà dsTipoTransito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsTipoTransito(String value) {
        this.dsTipoTransito = value;
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
     * Recupera il valore della proprietà id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
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
