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
 * <p>Classe Java per transitoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="transitoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dsTarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtTransito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idCase" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tipoTransito" type="{}tipoTransitoDto" minOccurs="0"/&gt;
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
@XmlType(name = "transitoDto", propOrder = {
    "dsTarga",
    "dtTransito",
    "id",
    "idCase",
    "tipoTransito",
    "utenteC"
})
public class TransitoDto {

    protected String dsTarga;
    protected String dtTransito;
    protected int id;
    protected int idCase;
    protected TipoTransitoDto tipoTransito;
    protected String utenteC;

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
     * Recupera il valore della proprietà dtTransito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtTransito() {
        return dtTransito;
    }

    /**
     * Imposta il valore della proprietà dtTransito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtTransito(String value) {
        this.dtTransito = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà idCase.
     * 
     */
    public int getIdCase() {
        return idCase;
    }

    /**
     * Imposta il valore della proprietà idCase.
     * 
     */
    public void setIdCase(int value) {
        this.idCase = value;
    }

    /**
     * Recupera il valore della proprietà tipoTransito.
     * 
     * @return
     *     possible object is
     *     {@link TipoTransitoDto }
     *     
     */
    public TipoTransitoDto getTipoTransito() {
        return tipoTransito;
    }

    /**
     * Imposta il valore della proprietà tipoTransito.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTransitoDto }
     *     
     */
    public void setTipoTransito(TipoTransitoDto value) {
        this.tipoTransito = value;
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
