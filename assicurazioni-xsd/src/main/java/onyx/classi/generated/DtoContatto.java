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
 * <p>Classe Java per dtoContatto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dtoContatto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataInsertContattoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idContattoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idTipoContattoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nomeContattoDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "dtoContatto", propOrder = {
    "dataInsertContattoDto",
    "idContattoDto",
    "idTipoContattoDto",
    "nomeContattoDto",
    "utenteCDto"
})
public class DtoContatto {

    protected String dataInsertContattoDto;
    protected Integer idContattoDto;
    protected Integer idTipoContattoDto;
    protected String nomeContattoDto;
    protected String utenteCDto;

    /**
     * Recupera il valore della proprietà dataInsertContattoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInsertContattoDto() {
        return dataInsertContattoDto;
    }

    /**
     * Imposta il valore della proprietà dataInsertContattoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInsertContattoDto(String value) {
        this.dataInsertContattoDto = value;
    }

    /**
     * Recupera il valore della proprietà idContattoDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContattoDto() {
        return idContattoDto;
    }

    /**
     * Imposta il valore della proprietà idContattoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContattoDto(Integer value) {
        this.idContattoDto = value;
    }

    /**
     * Recupera il valore della proprietà idTipoContattoDto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoContattoDto() {
        return idTipoContattoDto;
    }

    /**
     * Imposta il valore della proprietà idTipoContattoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoContattoDto(Integer value) {
        this.idTipoContattoDto = value;
    }

    /**
     * Recupera il valore della proprietà nomeContattoDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeContattoDto() {
        return nomeContattoDto;
    }

    /**
     * Imposta il valore della proprietà nomeContattoDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeContattoDto(String value) {
        this.nomeContattoDto = value;
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
