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
 * <p>Classe Java per dtoCittadino complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dtoCittadino"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceFiscaleDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognomeCittadinoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInserimentoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataNascitaDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCittadinoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idComuneNascitaDto" type="{}dtoComune" minOccurs="0"/&gt;
 *         &lt;element name="idStatoCittadinoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nomeCittadinoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="utenteCDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtoCittadino", propOrder = {
    "codiceFiscaleDto",
    "cognomeCittadinoDto",
    "dataInserimentoDto",
    "dataNascitaDto",
    "idCittadinoDto",
    "idComuneNascitaDto",
    "idStatoCittadinoDto",
    "nomeCittadinoDto",
    "note",
    "utenteCDto"
})
public class DtoCittadino {

    protected String codiceFiscaleDto;
    protected String cognomeCittadinoDto;
    protected String dataInserimentoDto;
    protected String dataNascitaDto;
    protected Integer idCittadinoDto;
    protected DtoComune idComuneNascitaDto;
    protected Integer idStatoCittadinoDto;
    protected String nomeCittadinoDto;
    protected String note;
    protected String utenteCDto;

    /**
     * Recupera il valore della proprietà codiceFiscaleDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleDto() {
        return codiceFiscaleDto;
    }

    /**
     * Imposta il valore della proprietà codiceFiscaleDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleDto(String value) {
        this.codiceFiscaleDto = value;
    }

    /**
     * Recupera il valore della proprietà cognomeCittadinoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomeCittadinoDto() {
        return cognomeCittadinoDto;
    }

    /**
     * Imposta il valore della proprietà cognomeCittadinoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomeCittadinoDto(String value) {
        this.cognomeCittadinoDto = value;
    }

    /**
     * Recupera il valore della proprietà dataInserimentoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInserimentoDto() {
        return dataInserimentoDto;
    }

    /**
     * Imposta il valore della proprietà dataInserimentoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInserimentoDto(String value) {
        this.dataInserimentoDto = value;
    }

    /**
     * Recupera il valore della proprietà dataNascitaDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascitaDto() {
        return dataNascitaDto;
    }

    /**
     * Imposta il valore della proprietà dataNascitaDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascitaDto(String value) {
        this.dataNascitaDto = value;
    }

    /**
     * Recupera il valore della proprietà idCittadinoDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCittadinoDto() {
        return idCittadinoDto;
    }

    /**
     * Imposta il valore della proprietà idCittadinoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCittadinoDto(Integer value) {
        this.idCittadinoDto = value;
    }

    /**
     * Recupera il valore della proprietà idComuneNascitaDto.
     * 
     * @return
     *     possible object is
     *     {@link DtoComune }
     *     
     */
    public DtoComune getIdComuneNascitaDto() {
        return idComuneNascitaDto;
    }

    /**
     * Imposta il valore della proprietà idComuneNascitaDto.
     * 
     * @param value
     *     allowed object is
     *     {@link DtoComune }
     *     
     */
    public void setIdComuneNascitaDto(DtoComune value) {
        this.idComuneNascitaDto = value;
    }

    /**
     * Recupera il valore della proprietà idStatoCittadinoDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdStatoCittadinoDto() {
        return idStatoCittadinoDto;
    }

    /**
     * Imposta il valore della proprietà idStatoCittadinoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdStatoCittadinoDto(Integer value) {
        this.idStatoCittadinoDto = value;
    }

    /**
     * Recupera il valore della proprietà nomeCittadinoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCittadinoDto() {
        return nomeCittadinoDto;
    }

    /**
     * Imposta il valore della proprietà nomeCittadinoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCittadinoDto(String value) {
        this.nomeCittadinoDto = value;
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
     * Recupera il valore della proprietà utenteCDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtenteCDto() {
        return utenteCDto;
    }

    /**
     * Imposta il valore della proprietà utenteCDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtenteCDto(String value) {
        this.utenteCDto = value;
    }

}
