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
 * <p>Classe Java per dtoProvincia complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dtoProvincia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataFineDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idProvinciaDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idRegioneDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nomeProvinciaDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "dtoProvincia", propOrder = {
    "dataFineDto",
    "dataInizioDto",
    "idProvinciaDto",
    "idRegioneDto",
    "nomeProvinciaDto",
    "utenteCDto"
})
public class DtoProvincia {

    protected String dataFineDto;
    protected String dataInizioDto;
    protected Integer idProvinciaDto;
    protected Integer idRegioneDto;
    protected String nomeProvinciaDto;
    protected String utenteCDto;

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
     * Recupera il valore della proprietà idProvinciaDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProvinciaDto() {
        return idProvinciaDto;
    }

    /**
     * Imposta il valore della proprietà idProvinciaDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProvinciaDto(Integer value) {
        this.idProvinciaDto = value;
    }

    /**
     * Recupera il valore della proprietà idRegioneDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdRegioneDto() {
        return idRegioneDto;
    }

    /**
     * Imposta il valore della proprietà idRegioneDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdRegioneDto(Integer value) {
        this.idRegioneDto = value;
    }

    /**
     * Recupera il valore della proprietà nomeProvinciaDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeProvinciaDto() {
        return nomeProvinciaDto;
    }

    /**
     * Imposta il valore della proprietà nomeProvinciaDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeProvinciaDto(String value) {
        this.nomeProvinciaDto = value;
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
