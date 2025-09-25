//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 12:57:24 PM CEST 
//


package onyx.classi.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per caselloDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="caselloDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="autostrada" type="{}autostradaDto" minOccurs="0"/&gt;
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dsCasello" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtInserimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCasello" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="km" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoCasello" type="{}statoCaselloDto" minOccurs="0"/&gt;
 *         &lt;element name="tipoCasello" type="{}tipoCaselloDto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "caselloDto", propOrder = {
    "autostrada",
    "codiceFiscale",
    "dsCasello",
    "dtInserimento",
    "idCasello",
    "km",
    "note",
    "statoCasello",
    "tipoCasello"
})
public class CaselloDto {

    protected AutostradaDto autostrada;
    protected String codiceFiscale;
    protected String dsCasello;
    protected String dtInserimento;
    protected int idCasello;
    protected Float km;
    protected String note;
    protected StatoCaselloDto statoCasello;
    protected TipoCaselloDto tipoCasello;

    /**
     * Recupera il valore della proprietà autostrada.
     * 
     * @return
     *     possible object is
     *     {@link AutostradaDto }
     *     
     */
    public AutostradaDto getAutostrada() {
        return autostrada;
    }

    /**
     * Imposta il valore della proprietà autostrada.
     * 
     * @param value
     *     allowed object is
     *     {@link AutostradaDto }
     *     
     */
    public void setAutostrada(AutostradaDto value) {
        this.autostrada = value;
    }

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
     * Recupera il valore della proprietà dsCasello.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsCasello() {
        return dsCasello;
    }

    /**
     * Imposta il valore della proprietà dsCasello.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsCasello(String value) {
        this.dsCasello = value;
    }

    /**
     * Recupera il valore della proprietà dtInserimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInserimento() {
        return dtInserimento;
    }

    /**
     * Imposta il valore della proprietà dtInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInserimento(String value) {
        this.dtInserimento = value;
    }

    /**
     * Recupera il valore della proprietà idCasello.
     * 
     */
    public int getIdCasello() {
        return idCasello;
    }

    /**
     * Imposta il valore della proprietà idCasello.
     * 
     */
    public void setIdCasello(int value) {
        this.idCasello = value;
    }

    /**
     * Recupera il valore della proprietà km.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getKm() {
        return km;
    }

    /**
     * Imposta il valore della proprietà km.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setKm(Float value) {
        this.km = value;
    }

    /**
     * Recupera il valore della proprietà note.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Imposta il valore della proprietà note.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Recupera il valore della proprietà statoCasello.
     * 
     * @return
     *     possible object is
     *     {@link StatoCaselloDto }
     *     
     */
    public StatoCaselloDto getStatoCasello() {
        return statoCasello;
    }

    /**
     * Imposta il valore della proprietà statoCasello.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoCaselloDto }
     *     
     */
    public void setStatoCasello(StatoCaselloDto value) {
        this.statoCasello = value;
    }

    /**
     * Recupera il valore della proprietà tipoCasello.
     * 
     * @return
     *     possible object is
     *     {@link TipoCaselloDto }
     *     
     */
    public TipoCaselloDto getTipoCasello() {
        return tipoCasello;
    }

    /**
     * Imposta il valore della proprietà tipoCasello.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCaselloDto }
     *     
     */
    public void setTipoCasello(TipoCaselloDto value) {
        this.tipoCasello = value;
    }

}
