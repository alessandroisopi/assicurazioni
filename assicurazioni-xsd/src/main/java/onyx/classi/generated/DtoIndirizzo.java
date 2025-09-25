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
 * <p>Classe Java per dtoIndirizzo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dtoIndirizzo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="capDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataFineDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idComuneDto" type="{}dtoComune" minOccurs="0"/&gt;
 *         &lt;element name="idIndirizzoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nomeViaDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroCivicoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "dtoIndirizzo", propOrder = {
    "capDto",
    "dataFineDto",
    "dataInizioDto",
    "idComuneDto",
    "idIndirizzoDto",
    "nomeViaDto",
    "numeroCivicoDto",
    "utenteCDto"
})
public class DtoIndirizzo {

    protected String capDto;
    protected String dataFineDto;
    protected String dataInizioDto;
    protected DtoComune idComuneDto;
    protected Integer idIndirizzoDto;
    protected String nomeViaDto;
    protected String numeroCivicoDto;
    protected String utenteCDto;

    /**
     * Recupera il valore della proprietà capDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapDto() {
        return capDto;
    }

    /**
     * Imposta il valore della proprietà capDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapDto(String value) {
        this.capDto = value;
    }

    /**
     * Recupera il valore della proprietà dataFineDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineDto() {
        return dataFineDto;
    }

    /**
     * Imposta il valore della proprietà dataFineDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineDto(String value) {
        this.dataFineDto = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioDto() {
        return dataInizioDto;
    }

    /**
     * Imposta il valore della proprietà dataInizioDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioDto(String value) {
        this.dataInizioDto = value;
    }

    /**
     * Recupera il valore della proprietà idComuneDto.
     * 
     * @return
     *     possible object is
     *     {@link DtoComune }
     *     
     */
    public DtoComune getIdComuneDto() {
        return idComuneDto;
    }

    /**
     * Imposta il valore della proprietà idComuneDto.
     * 
     * @param value
     *     allowed object is
     *     {@link DtoComune }
     *     
     */
    public void setIdComuneDto(DtoComune value) {
        this.idComuneDto = value;
    }

    /**
     * Recupera il valore della proprietà idIndirizzoDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdIndirizzoDto() {
        return idIndirizzoDto;
    }

    /**
     * Imposta il valore della proprietà idIndirizzoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdIndirizzoDto(Integer value) {
        this.idIndirizzoDto = value;
    }

    /**
     * Recupera il valore della proprietà nomeViaDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeViaDto() {
        return nomeViaDto;
    }

    /**
     * Imposta il valore della proprietà nomeViaDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeViaDto(String value) {
        this.nomeViaDto = value;
    }

    /**
     * Recupera il valore della proprietà numeroCivicoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCivicoDto() {
        return numeroCivicoDto;
    }

    /**
     * Imposta il valore della proprietà numeroCivicoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCivicoDto(String value) {
        this.numeroCivicoDto = value;
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
