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

**Codigo generado**

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

***Interface para exponer los Servicios Web del Cliente [API expone los servicios del cliente - LEGADO]***

***
```
package com.wlopera.cliente.cmf.api;

import java.util.List;

import com.wlopera.cliente.cmf.soap.Campeonato;

public interface MundialFutbolClienteApi {

	/**
	 * Consultar la lista de paises ganadores de una cantidad especifica de
	 * mundiales de futbol
	 * 
	 * @param numeroCMFGanados Cantidad de campeonatos ganados
	 * 
	 * @return Listado de paises que solo han ganado esa cantidad exacta de
	 *         campeonatos
	 */
	List<Campeonato> getListaCMFPorCampeonatoGanado(String numeroCMFGanados);

	/**
	 * Consulta todos los paises ganadores de campeones mundiales de futbol
	 * 
	 * @return Listado de paises gnadores de mundiales
	 */
	List<Campeonato> getListaCMFTodos();

	/**
	 * Consultar el pais ganador del mundial de un annio requerido
	 * 
	 * @param year Annio del mundial
	 * 
	 * @return Pais que gano el campeonato ese annio
	 */
	Campeonato getCMFPorAnnio(String annio);
}
```
***

***Implementación de los Servicios Web del Cliente [exponer servicios del cliente]***

***
```package com.wlopera.cliente.cmf.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.wlopera.cliente.cmf.soap.Campeonato;
import com.wlopera.cliente.cmf.soap.ClienteCMFServicio;

public class MundialFutbolClienteImpl implements MundialFutbolClienteApi {

	private static ClienteCMFServicio instance = null;

	// retorna la instancia singleton creada
	public static ClienteCMFServicio getInstance() {

		if (null == instance) {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

			// Agregar el endpoint del WSDL
			factory.setAddress("http://localhost:8080/MundialesFutbol/services/ClienteCMFServicioPort");

			// Uso de clase autogenerada por Apache CXF wsdl2java
			factory.setServiceClass(ClienteCMFServicio.class);

			instance = (ClienteCMFServicio) factory.create();
		}
		return instance;
	}

	@Override
	public List<Campeonato> getListaCMFPorCampeonatoGanado(String numeroCMFGanados) {
		List<Campeonato> campeones = new ArrayList<>();
		try {
			campeones = getInstance().getListaCMFPorCampeonatoGanado(numeroCMFGanados);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeones;
	}

	@Override
	public List<Campeonato> getListaCMFTodos() {
		List<Campeonato> campeones = new ArrayList<>();
		try {
			campeones = getInstance().getListaCMFTodos();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeones;
	}

	@Override
	public Campeonato getCMFPorAnnio(String annio) {
		Campeonato campeonato = new Campeonato();
		try {
			campeonato = getInstance().getCMFPorAnnio(annio);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return campeonato;
	}

	public static void main(String[] arg) {
		MundialFutbolClienteImpl cmf = new MundialFutbolClienteImpl();
		List<Campeonato> campeones = cmf.getListaCMFTodos();
		for (Campeonato campeon : campeones) {
			System.out.println(campeon.getAnnio() + " -- " + campeon.getNombreCampeon() + " -- "
					+ campeon.getNonbreSubcampeon() + " -- " + campeon.getResultado());
		}
	}
}
```
***

**2. Api para exponer los servicios**

![data](https://user-images.githubusercontent.com/7141537/48036506-b8d12d00-e136-11e8-9de7-351b6d45b1fb.png)

***Modelo de negocio***

***
```
package com.wlopera.api;

import java.io.Serializable;

public class ChampionDTO implements Serializable {

	private static final long serialVersionUID = -2527025805502767454L;

	private int year;
	private String championName;
	private String headquarter;
	private String subChampionName;
	private String result;

	public ChampionDTO() {}
	
	public ChampionDTO(int year, String championName, String headquarter, String subChampionName, String result) {
		this.year = year;
		this.championName = championName;
		this.headquarter = headquarter;
		this.subChampionName = subChampionName;
		this.result = result;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	public String getSubChampionName() {
		return subChampionName;
	}

	public void setSubChampionName(String subChampionName) {
		this.subChampionName = subChampionName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Champion [year=" + year + ", championName=" + championName + ", headquarter=" + headquarter
				+ ", subChampionName=" + subChampionName + ", result=" + result + "]";
	}

}
```
***

***Interface API***

***
```
package com.wlopera.api;

import java.util.List;

public interface SoccerWorldChampionshipApi {

	/**
	 * Consultar la lista de paises ganadores de una cantidad especifica de
	 * mundiales de futbol
	 * 
	 * @param numeroCMFGanados Cantidad de campeonatos ganados
	 * 
	 * @return Listado de paises que solo han ganado esa cantidad exacta de
	 *         campeonatos
	 */
	List<ChampionDTO> getListChampionsWinByQty(String qty);

	/**
	 * Consulta todos los paises ganadores de campeones mundiales de futbol
	 * 
	 * @return Listado de paises gnadores de mundiales
	 */
	List<ChampionDTO> getListChampionsWin();

	/**
	 * Consultar el pais ganador del mundial de un annio requerido
	 * 
	 * @param year Annio del mundial
	 * 
	 * @return Pais que gano el campeonato ese annio
	 */
	ChampionDTO getChampionByYear(String year);
}
```
***

***Implementación del API***

***
```
package com.wlopera.api;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.wlopera.cliente.cmf.api.MundialFutbolClienteImpl;
import com.wlopera.cliente.cmf.soap.Campeonato;

public class SoccerWorldChampionshipImpl implements SoccerWorldChampionshipApi {

	private static MundialFutbolClienteImpl instance = null;

	// retorna la instancia singleton creada
	public static MundialFutbolClienteImpl getInstance() {

		if (null == instance) {

			instance = new MundialFutbolClienteImpl();
		}
		return instance;
	}

	@Override
	public List<ChampionDTO> getListChampionsWinByQty(String qty) {

		List<Campeonato> campeonatos = getInstance().getListaCMFPorCampeonatoGanado(qty);
		
		List<ChampionDTO> champions = new ArrayList<>();
		
		for (Campeonato campeonato : campeonatos) {
			champions.add(getChampionByDozer(campeonato));			
		}
		System.out.println(champions.toString());
		return champions;
	}

	@Override
	public List<ChampionDTO> getListChampionsWin() {

		List<Campeonato> campeonatos = getInstance().getListaCMFTodos();

		List<ChampionDTO> champions = new ArrayList<>();
		
		for (Campeonato campeonato : campeonatos) {
			champions.add(getChampionByDozer(campeonato));			
		}
		System.out.println(champions.toString());
		return champions;
	}

	@Override
	public ChampionDTO getChampionByYear(String year) {

		ChampionDTO champion = getChampionByDozer(getInstance().getCMFPorAnnio(year));
	
		System.out.println(champion.toString());
		
		return champion;
	}

	private ChampionDTO getChampionByDozer(Campeonato campeonato) {

		List<String> list = new ArrayList<>();

		list.add("champion-mapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.setMappingFiles(list);

		ChampionDTO champion = new ChampionDTO();

		mapper.map(campeonato, champion, "champion");

		return champion;
	}
	
	public static void main(String[] args) {
		SoccerWorldChampionshipImpl cmf = new SoccerWorldChampionshipImpl();
		
		System.out.println("Campeon 1986: ");
		cmf.getChampionByYear("1986");
		
		System.out.println("Campeones ");
		cmf.getListChampionsWin();
		
		System.out.println("Campeones en 2 torneos ");
		cmf.getListChampionsWinByQty("2");
		
	}
	
}
```
***

Nota: uso patrón Singleton para generar un solo objeto para consumo de servicios

**2. Rest para exponer los servicios**


***Interface API***

***
```

```
***


