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
 * <p>Classe Java per dtoVeicoloCittadino complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dtoVeicoloCittadino"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataFineDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCittadinoDto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numTelaioDto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "dtoVeicoloCittadino", propOrder = {
    "dataFineDto",
    "dataInizioDto",
    "idCittadinoDto",
    "numTelaioDto",
    "utenteCDto"
})
public class DtoVeicoloCittadino {

    protected String dataFineDto;
    protected String dataInizioDto;
    protected Integer idCittadinoDto;
    protected String numTelaioDto;
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
     * Recupera il valore della proprietà numTelaioDto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTelaioDto() {
        return numTelaioDto;
    }

    /**
     * Imposta il valore della proprietà numTelaioDto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTelaioDto(String value) {
        this.numTelaioDto = value;
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
