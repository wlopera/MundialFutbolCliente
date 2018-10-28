
package com.wlopera.cliente.cmf.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para campeonato complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="campeonato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="annio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreCampeon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nonbreSubcampeon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "campeonato", propOrder = {
    "annio",
    "nombreCampeon",
    "nombreSede",
    "nonbreSubcampeon",
    "resultado"
})
public class Campeonato {

    protected int annio;
    protected String nombreCampeon;
    protected String nombreSede;
    protected String nonbreSubcampeon;
    protected String resultado;

    /**
     * Obtiene el valor de la propiedad annio.
     * 
     */
    public int getAnnio() {
        return annio;
    }

    /**
     * Define el valor de la propiedad annio.
     * 
     */
    public void setAnnio(int value) {
        this.annio = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCampeon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCampeon() {
        return nombreCampeon;
    }

    /**
     * Define el valor de la propiedad nombreCampeon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCampeon(String value) {
        this.nombreCampeon = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSede() {
        return nombreSede;
    }

    /**
     * Define el valor de la propiedad nombreSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSede(String value) {
        this.nombreSede = value;
    }

    /**
     * Obtiene el valor de la propiedad nonbreSubcampeon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonbreSubcampeon() {
        return nonbreSubcampeon;
    }

    /**
     * Define el valor de la propiedad nonbreSubcampeon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonbreSubcampeon(String value) {
        this.nonbreSubcampeon = value;
    }

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

}
