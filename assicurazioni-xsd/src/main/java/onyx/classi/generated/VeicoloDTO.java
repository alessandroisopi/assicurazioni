//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2025.09.25 alle 09:54:03 AM CEST 
//


package onyx.classi.generated;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per veicoloDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="veicoloDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idVeicolo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dtInserimento" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="telaio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idMarca" type="{}marcaDTO"/&gt;
 *         &lt;element name="idModello" type="{}modelloDTO"/&gt;
 *         &lt;element name="tipoVeicoloDTO" type="{}tipoVeicoloDTO"/&gt;
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
@XmlType(name = "veicoloDTO", propOrder = {
    "idVeicolo",
    "dtInserimento",
    "telaio",
    "idMarca",
    "idModello",
    "tipoVeicoloDTO",
    "utenteC"
})
public class VeicoloDTO {

    protected int idVeicolo;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtInserimento;
    @XmlElement(required = true)
    protected String telaio;
    @XmlElement(required = true)
    protected MarcaDTO idMarca;
    @XmlElement(required = true)
    protected ModelloDTO idModello;
    @XmlElement(required = true)
    protected TipoVeicoloDTO tipoVeicoloDTO;
    protected String utenteC;

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
     * Recupera il valore della proprietà dtInserimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtInserimento() {
        return dtInserimento;
    }

    /**
     * Imposta il valore della proprietà dtInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtInserimento(XMLGregorianCalendar value) {
        this.dtInserimento = value;
    }

    /**
     * Recupera il valore della proprietà telaio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelaio() {
        return telaio;
    }

    /**
     * Imposta il valore della proprietà telaio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelaio(String value) {
        this.telaio = value;
    }

    /**
     * Recupera il valore della proprietà idMarca.
     * 
     * @return
     *     possible object is
     *     {@link MarcaDTO }
     *     
     */
    public MarcaDTO getIdMarca() {
        return idMarca;
    }

    /**
     * Imposta il valore della proprietà idMarca.
     * 
     * @param value
     *     allowed object is
     *     {@link MarcaDTO }
     *     
     */
    public void setIdMarca(MarcaDTO value) {
        this.idMarca = value;
    }

    /**
     * Recupera il valore della proprietà idModello.
     * 
     * @return
     *     possible object is
     *     {@link ModelloDTO }
     *     
     */
    public ModelloDTO getIdModello() {
        return idModello;
    }

    /**
     * Imposta il valore della proprietà idModello.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelloDTO }
     *     
     */
    public void setIdModello(ModelloDTO value) {
        this.idModello = value;
    }

    /**
     * Recupera il valore della proprietà tipoVeicoloDTO.
     * 
     * @return
     *     possible object is
     *     {@link TipoVeicoloDTO }
     *     
     */
    public TipoVeicoloDTO getTipoVeicoloDTO() {
        return tipoVeicoloDTO;
    }

    /**
     * Imposta il valore della proprietà tipoVeicoloDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoVeicoloDTO }
     *     
     */
    public void setTipoVeicoloDTO(TipoVeicoloDTO value) {
        this.tipoVeicoloDTO = value;
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
