# MundialesFutbol - CLIENTE - CAMPEONATOS MUNDIALES DE FUTBOL 

Cliente que consume Servicio Web. Que permita consultar datos de los campeonatos mundiales de Futbol. Y expone los mismos a través de un Servicio Rest

Uso de Gradle - STS - Eclipse

### Campeones mundiales
Listado de paises campeones de mundiales:

Entrada: 

Salida: 
* Campeonatos ganados
* Participaciones
* Años en que gano
* Sedes de los mundiales ganados

### Campeones por cantidad de campeonatos ganados
Lista de paises campeones de mundiales para una cantidad de campeonatos requerida

Entrada: 
* Cantidad de campeonatos ganados

Salida: 
* Campeonatos ganados
* Años en que gano
* Sedes de los mundiales ganados
		
### Campeón para un año requerido
Campeon mundial de ese año.

Entrada: 
* Año del mundial

Salida:
* Año
* Sede
* Equipo Campeón
* Equipo Sub - Campeón

## Requerimientos.
* Java 1.8 [https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html]
* STS - Eclipse [https://spring.io/tools3/sts/all]
* Pivotal tc Server Developer Edition v4.0
* SoapUI (opcional) [https://www.soapui.org/downloads/soapui.html]
* Gradle Integration 2-0 [https://projects.eclipse.org/projects/tools.buildship]

## Crear de un proyecto Gradle

> Nuevo Proyecto gradle - MundialesFutbol (eclipse), a desplegar en un servidor de Tomcat

### Cliente para consumir Servicios Web [ver Proyecto github MundialesFutbol]

**1. Gradle para generar el cliente**

***
```
apply plugin: 'java'
apply plugin: 'maven'
  
repositories {
  mavenCentral()
}

configurations {
  wsdl2java
}

dependencies {
  compile 'org.apache.cxf:cxf-rt-frontend-jaxws:3.2.2'
  compile 'org.apache.cxf:cxf-rt-transports-http:3.2.2'
  
  wsdl2java 'org.apache.cxf:cxf-tools-wsdlto-frontend-jaxws:3.2.2'
  wsdl2java 'org.apache.cxf:cxf-tools-wsdlto-databinding-jaxb:3.2.2'  
}

def wsdl2java = task generateJavaFromWsdl(type: JavaExec) {
  String wsdl = 'src/main/java/resources/clientecmfservicio.wsdl'
  String genSrcDir = "src/main/java/"

  inputs.file wsdl
  outputs.dir genSrcDir

  classpath configurations.wsdl2java
  main "org.apache.cxf.tools.wsdlto.WSDLToJava"

  args "-p", "http://cliente.wlopera.com/=com.wlopera.cliente.cmf.soap"
  args "-d", genSrcDir
  args "-verbose"
  args "-encoding", "utf-8"
  args wsdl
  
  
  doLast {
    println "[INFO] Generado el cliente"
  }
  
 }
 
compileJava.dependsOn += wsdl2java

sourceSets.main.java.srcDirs = ['src/main/java', 'build/generated-sources/cxf-ws']
```
***

Nota:

Crear paquete donde se generar el codigo según el namespace del WSDL 

http://cliente.wlopera.com/ ==> **com.wlopera.cliente.cmf.soap**

**2. Correr tarea 'install' de gradle para generar el cliente**

![gradle-1](https://user-images.githubusercontent.com/7141537/48035927-16b04580-e134-11e8-808f-81d9ef294e54.png)

Nota: Se puede correr el comango **git install** [uso git]

**Se genera el código con el cliente**

![gradle-2](https://user-images.githubusercontent.com/7141537/48036097-d8675600-e134-11e8-9213-8e8b974f9f8b.png)

**Codigo genrado**

Entre otros

***I.- Clase modelo de dato***

***
```
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
```
***

***II.- Interface***

***
```
package com.wlopera.cliente.cmf.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-10-31T21:38:52.469-05:00
 * Generated source version: 3.2.2
 *
 */
@WebService(targetNamespace = "http://cliente.wlopera.com/", name = "ClienteCMFServicio")
@XmlSeeAlso({ObjectFactory.class})
public interface ClienteCMFServicio {

    @WebMethod
    @RequestWrapper(localName = "getCMFPorAnnio", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetCMFPorAnnio")
    @ResponseWrapper(localName = "getCMFPorAnnioResponse", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetCMFPorAnnioResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.wlopera.cliente.cmf.soap.Campeonato getCMFPorAnnio(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getListaCMFTodos", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetListaCMFTodos")
    @ResponseWrapper(localName = "getListaCMFTodosResponse", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetListaCMFTodosResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.wlopera.cliente.cmf.soap.Campeonato> getListaCMFTodos();

    @WebMethod
    @RequestWrapper(localName = "getListaCMFPorCampeonatoGanado", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetListaCMFPorCampeonatoGanado")
    @ResponseWrapper(localName = "getListaCMFPorCampeonatoGanadoResponse", targetNamespace = "http://cliente.wlopera.com/", className = "com.wlopera.cliente.cmf.soap.GetListaCMFPorCampeonatoGanadoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.wlopera.cliente.cmf.soap.Campeonato> getListaCMFPorCampeonatoGanado(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
```
***

***III.- Clase Cliente con Servicio***

***
```
package com.wlopera.cliente.cmf.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-10-31T21:38:52.504-05:00
 * Generated source version: 3.2.2
 *
 */
@WebServiceClient(name = "ClienteCMFServicioService",
                  wsdlLocation = "file:src/main/java/resources/clientecmfservicio.wsdl",
                  targetNamespace = "http://cliente.wlopera.com/")
public class ClienteCMFServicioService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cliente.wlopera.com/", "ClienteCMFServicioService");
    public final static QName ClienteCMFServicioPort = new QName("http://cliente.wlopera.com/", "ClienteCMFServicioPort");
    static {
        URL url = null;
        try {
            url = new URL("file:src/main/java/resources/clientecmfservicio.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ClienteCMFServicioService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:src/main/java/resources/clientecmfservicio.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ClienteCMFServicioService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ClienteCMFServicioService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClienteCMFServicioService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ClienteCMFServicioService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ClienteCMFServicioService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ClienteCMFServicioService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }
    
    /**
     *
     * @return
     *     returns ClienteCMFServicio
     */
    @WebEndpoint(name = "ClienteCMFServicioPort")
    public ClienteCMFServicio getClienteCMFServicioPort() {
        return super.getPort(ClienteCMFServicioPort, ClienteCMFServicio.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClienteCMFServicio
     */
    @WebEndpoint(name = "ClienteCMFServicioPort")
    public ClienteCMFServicio getClienteCMFServicioPort(WebServiceFeature... features) {
        return super.getPort(ClienteCMFServicioPort, ClienteCMFServicio.class, features);
    }

}
```
***

***I.- Clase modelo de dato***

***
```
```
***

***I.- Clase modelo de dato***

***
```
```
***


