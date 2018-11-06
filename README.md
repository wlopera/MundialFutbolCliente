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

![data](https://user-images.githubusercontent.com/7141537/48036849-131ebd80-e138-11e8-85cd-a0647090b40f.png)

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

**2. Api de negocio para exponer los servicios**

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

***Dozer XML - Mapeo de datos [champion-mapping.xml]***

***
```
<?xml version="1.0" encoding="UTF-8"?>
<mappings xmlns="http://dozer.sourceforge.net" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://dozer.sourceforge.net http://dozer.sourceforge.net/schema/beanmapping.xsd">

	<mapping map-id="champion">
		<class-a>com.wlopera.cliente.cmf.soap.Campeonato</class-a>
		<class-b>com.wlopera.api.ChampionDTO</class-b>
		<field>
			<a>annio</a>
			<b>year</b>
		</field>
		<field>
			<a>nombreCampeon</a>
			<b>championName</b>
		</field>
		<field>
			<a>nombreSede</a>
			<b>headquarter</b>
		</field>	
		<field>
			<a>nonbreSubcampeon</a>
			<b>subChampionName</b>
		</field>		 			
		<field>
			<a>resultado</a>
			<b>result</b>
		</field>		 			
	</mapping>
</mappings>
```
***

Nota: uso patrón Singleton para generar un solo objeto para consumo de servicios

**2. Rest para exponer los servicios**

![data](https://user-images.githubusercontent.com/7141537/48037158-3bf38280-e139-11e8-9d9f-0eaceff3cd39.png)

***Wraper para envio de mensajes de respuesta - datos***

***
```
package com.wlopera.cliente.cmf.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.wlopera.api.ChampionDTO;

@JsonRootName("ClientWrapper")
public class ChampionWrapper implements Serializable {

	private static final long serialVersionUID = -6453185814072830906L;

	private List<ChampionDTO> champions;
	
	public List<ChampionDTO> getChampions() {
		return champions;
	}

	public void setChampions(List<ChampionDTO> champions) {
		this.champions = champions;
	}

	@Override
	public String toString() {
		return "ChampionWrapper [champions=" + champions + "]";
	}
	
}
```
***

***Wrapper de datos ***

***
```
package com.wlopera.cliente.cmf.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("ClientWrapper")
public class DataWrapper implements Serializable {

	private static final long serialVersionUID = 7831642959650748773L;

	private List<String> qtys;
	private List<String> years;
	
	public List<String> getQtys() {
		return qtys;
	}

	public void setQtys(List<String> qtys) {
		this.qtys = qtys;
	}

	public List<String> getYears() {
		return years;
	}

	public void setYears(List<String> years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "DataWrapper [qtys=" + qtys + ", years=" + years + "]";
	}
	
}
```
***

***Clase Util con datos requeridos***

***
```
package com.wlopera.cliente.cmf.rest;

import java.util.ArrayList;
import java.util.List;

public class ChampionUtil {

	/**
	 * Annios de los torneos
	 * 
	 * @author Willian Lopera
	 * 
	 * @return Lista de annios de los torneos
	 */
	public static final List<String> getYears() {
		List<String> years = new ArrayList<>();
		
		years.add("1930");
		years.add("1934");
		years.add("1938");
		years.add("1950");
		years.add("1954");
		years.add("1958");
		years.add("1962");
		years.add("1966");
		years.add("1970");
		years.add("1974");
		years.add("1978");
		years.add("1982");
		years.add("1986");
		years.add("1990");
		years.add("1994");
		years.add("1998");
		years.add("2002");
		years.add("2006");
		years.add("2010");
		years.add("2014");
		years.add("2018");
		
		return years;
	}

	/**
	 * Cantidad exacta de torneos ganados por un pais
	 * 
	 * @author Willian Lopera
	 * 
	 * @return Lista de cantidad exacta de torneos ganados
	 */
	public static final List<String> getChampionsWinQty() {
		List<String> qty = new ArrayList<>();
		
		qty.add("1");
		qty.add("2");
		qty.add("3");
		qty.add("4");
		qty.add("5");
		
		return qty;
	}
}
```
***

***Controlador***

***
```
package com.wlopera.cliente.cmf.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.wlopera.api.ChampionDTO;
import com.wlopera.api.SoccerWorldChampionshipApi;

@Controller
public class ChampionController {

	protected SoccerWorldChampionshipApi swcsApi;

	@Autowired
	protected RestTemplate restTemplate;

	public ChampionController(SoccerWorldChampionshipApi swcsApi) {
		this.swcsApi = swcsApi;
	}

	/**
	 * Go to home.
	 * 
	 * Probar servicio rest activo => netstat -ano | find "8585"
	 * 
	 * @return
	 */
	// http://localhost:8585/
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	/**
	 * Servicio Rest Data listado de annios jugados y cantidad de torneos ganados
	 * 
	 * @return Listado de datos
	 */
	// http://localhost:8585/champion/allChampions
	@RequestMapping(value = "/champion/data")
	@ResponseBody
	public DataWrapper getData() {

		System.out.println("Inicio consulta servicio rest getData");
		DataWrapper wrapper = new DataWrapper();

		wrapper.setYears(ChampionUtil.getYears());
		wrapper.setQtys(ChampionUtil.getChampionsWinQty());
		
		return wrapper;

	}

	/**
	 * Servicio Rest listado de todos los campeonatos
	 * 
	 * @return Listado de campeonatos
	 */
	// http://localhost:8585/champion/allChampions
	@RequestMapping(value = "/champion/allChampions")
	@ResponseBody
	public ChampionWrapper getAllChampions() {

		System.out.println("Inicio consulta servicio rest ChampionWrapper");
		ChampionWrapper wrapper = new ChampionWrapper();

		wrapper.setChampions(swcsApi.getListChampionsWin());
		return wrapper;

	}

	/**
	 * Servicio Rest campeon por annio
	 * 
	 * @return Campeon para un annio requerido
	 */
	// http://localhost:8585/champion/championByYear/1986
	@GetMapping(value = "/champion/championByYear/{year}")
	@ResponseBody
	public ChampionWrapper getChampionByYear(@PathVariable("year") String year) {

		System.out.println("Inicio consulta servicio rest getChampionByYear para el año: " + year);
		ChampionWrapper wrapper = new ChampionWrapper();

		List<ChampionDTO> champions = new ArrayList<>();
		champions.add(swcsApi.getChampionByYear(year));

		wrapper.setChampions(champions);
		
		System.out.println("getChampionByYear: " + wrapper.getChampions().toString());
		return wrapper;

	}

	/**
	 * Servicio Rest listado de todos los campeones ganadores para una catidad
	 * exacta de campeonatos
	 * 
	 * @return Listado de campeonatos
	 */
	// http://localhost:8585/champion/championsByWins/2
	@GetMapping(value = "/champion/championsByWins/{numberWins}")
	@ResponseBody
	public ChampionWrapper getChampionsByWins(@PathVariable("numberWins") String numberWins) {

		System.out.println("Inicio consulta servicio rest getChampionsByWins para partidos ganados: " + numberWins);
		ChampionWrapper wrapper = new ChampionWrapper();

		wrapper.setChampions(swcsApi.getListChampionsWinByQty(numberWins));
		
		System.out.println("getChampionsByWins: " + wrapper.getChampions().toString());
		return wrapper;

	}
}
```
***

***Aplicación para levantar servicio REST [uso SpringBootApplication]***

***
```
package com.wlopera.cliente.cmf.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.wlopera.api.SoccerWorldChampionshipApi;
import com.wlopera.api.SoccerWorldChampionshipImpl;

@SpringBootApplication // Indica que se trata de una aplicación Spring Boot
@ComponentScan(useDefaultFilters = false) // La configuración predeterminada de escáner de componentes heredada de
											// Spring Boot busca clases @Component y,
											// en este caso, intenta crearlo. Sin embargo, quiero crearlo yo mismo,
											// así que deshabilito el escáner
public class ClientChampionRest {

	public static void main(String[] args) {
		SpringApplication.run(ClientChampionRest.class, args);
	}

	@LoadBalanced // Asegúrese de inyectar la plantilla de carga correcta
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public SoccerWorldChampionshipApi getSoccerWorldChampionshipApi() {
		return new SoccerWorldChampionshipImpl();
	}

	@Bean
	public ChampionController getChampionController() {
		return new ChampionController(getSoccerWorldChampionshipApi());
	}
}
```
***

***Archivo para configurar el servidor y uso de JS/CSS/HTML [Aplication.yml]***

***
```
# Spring properties
spring:
  freemarker:
    enabled: false     # Ignore Eureka dashboard FreeMarker templates
  thymeleaf:
    cache: false       # Allow Thymeleaf templates to be reloaded at runtime
    prefix: classpath:/templates/    # Trailing / mandatory
                       # Template location for this application only

# Map the error path to error template (for Thymeleaf)
error:
  path=/error

# HTTP Server
server:
  port: 8585   # HTTP (Tomcat) port
```
***

### AngularJS

![data](https://user-images.githubusercontent.com/7141537/48037510-92ad8c00-e13a-11e8-9a99-aab84e266a0a.png)

***Liberias modulo/controlador***

***
```
// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
var MyApp = angular.module("MyApp", []);

MyApp.controller("MyController",["$scope", "service", function($scope, service){
    	
    	$scope.showData = false; 	// Variable para mostrar resultados
    	$scope.champions = {};     	// Campeones encontrados en la consulta
    	
    	$scope.qtys = {};
    	$scope.years = {};

    	// Consultar todos los campeonatos - protocolo HTTP
    	$scope.getAllChampions = function(){
    	  getHttp("/champion/allChampions");
    	};
    	
    	// Consultar campeon para un año requerido - protocolo HTTP
    	$scope.getChampionByYear = function(){
    		getHttp("/champion/championByYear/" + $scope.param);
    	};
    	
    	// Consultar campeones ganadores por cantidad de ganados - protocolo HTTP
    	$scope.getChampionsByWins = function(){
    	  getHttp("/champion/championsByWins/" + $scope.param);       
    	};
    	
    	function getHttp(uri) {
	    	service.getHttp(uri)
	    	.then(function(response) {
	    		console.log(response);
	    		$scope.showData = true;
	    	    $scope.champions = response.data.champions;
	        }).catch(function(err) {
	        	$scope.showData = false;
	            console.error("Error del servicio consulta http: ", err);
	        });
    	};

    	function getData(uri) {
	    	service.getHttp(uri)
	    	.then(function(response) {
	    		$scope.qtys = response.data.qtys;
	    		$scope.years = response.data.years;
	    		console.log(response);
	        }).catch(function(err) {
	            console.error("Error del servicio consulta http: ", err);
	        });
    	};

    	getHttp("/champion/allChampions");
    	getData("/champion/data");
    	
    	$scope.hideTable = function() {
    		$scope.param = "";
    		$scope.showData = false;
    	}
    	
    }]);
```
***

***Liberias servicios***

***
```
MyApp.factory('service', ['$http', function($http) {
	
	function getHttp(uri) {
		return $http.get(uri)      	// URI de llamada	 
	};

	return {
		getHttp : getHttp
	};
	
}]);
```
***

***HTML***

***
```
<!DOCTYPE html>
<html ng-app="MyApp">
<head>
<meta charset="UTF-8"></meta>

<!-- Libreria CCS bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>

<!-- Libreria CCS propia del aplicativo -->
<link rel="stylesheet" href="../../css/style.css"></link>

<!-- Libreria Jquery - requerida por boopstrap -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Libreria bootstrap -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Libreria angularJS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>

<!-- Libreria propia del aplicativo -->
<script src="../../js/app.js"></script>
<script src="../../js/service.js"></script>

<title>Campeones Mundiales</title>
</head>
<body ng-controller="MyController">
	<h1>Campeonatos Mundiales de Futbol</h1>
	<hr></hr>
	    <div class="row">
        <div class="col-sm-3">
            <a href="#" class="nav-tabs-dropdown btn btn-block btn-primary">Campeonatos</a>
            <ul id="nav-tabs-wrapper" class="nav nav-tabs nav-pills nav-stacked well">
              <li ng-click="getAllChampions()" class="active"><a href="#vtab1" data-toggle="tab">Todos</a></li>
              <li ng-click="hideTable()"><a href="#vtab2" data-toggle="tab">Por año</a></li>
              <li ng-click="hideTable()"><a href="#vtab3" data-toggle="tab">Por cantidad de ganados</a></li>
            </ul>
        </div>
        <div class="col-sm-6">
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="vtab1">
                    <pre>
	                    <table class="table table-striped" ng-show="showData">
						            <thead>
						              <tr>
						                <th>AÑO</th>
						                <th>SEDE</th>						                
						                <th>CAMPEÓN</th>
						                <th>RESULTADO</th>
						                <th>SUB-CAMPEÓN</th>
						              </tr>
						            </thead>
						            <tbody>
						              <tr ng-repeat = "champion in champions">
						                 <td>{{champion.year}}</td>
							               <td>{{champion.headquarter}}</td>
							               <td>{{champion.championName}}</td>
							               <td>{{champion.result}}</td>
							               <td>{{champion.subChampionName}}</td>
						              </tr>
						            </tbody>
						          </table>
                    </pre>                    
                </div>
                <div role="tabpanel" class="tab-pane fade" id="vtab2">
	                <div>
             				Año del campeonato: 
             				<select ng-model="param" ng-options="year for year in years"></select>
             				<button ng-click="getChampionByYear()">Consulta</button>
             			</div>	                		
	                <pre>
                      <table class="table table-striped" ng-show="showData">
						            <thead>
						              <tr>
						                <th>AÑO</th>
						                <th>SEDE</th>						                
						                <th>CAMPEÓN</th>
						                <th>RESULTADO</th>
						                <th>SUB-CAMPEÓN</th>
						              </tr>
						            </thead>
						            <tbody>
						              <tr ng-repeat = "champion in champions">
						                 <td>{{champion.year}}</td>
							               <td>{{champion.headquarter}}</td>
							               <td>{{champion.championName}}</td>
							               <td>{{champion.result}}</td>
							               <td>{{champion.subChampionName}}</td>
						              </tr>
						            </tbody>
						          </table>
					          </div>	                			
                 </pre>
							  <div role="tabpanel" class="tab-pane fade in" id="vtab3">
							    <div>
             				Cantidad de torneos ganados: 
             				<select ng-model="param" ng-options="qty for qty in qtys"></select>             				
             				<button ng-click="getChampionsByWins()">Consulta</button>
             			</div>	                			               
                	<pre>
	                    <table class="table table-striped" ng-show="showData">
						            <thead>
						              <tr>
						                <th>AÑO</th>
						                <th>SEDE</th>						                
						                <th>CAMPEÓN</th>
						                <th>RESULTADO</th>
						                <th>SUB-CAMPEÓN</th>
						              </tr>
						            </thead>
						            <tbody>
						              <tr ng-repeat = "champion in champions">
						                 <td>{{champion.year}}</td>
							               <td>{{champion.headquarter}}</td>
							               <td>{{champion.championName}}</td>
							               <td>{{champion.result}}</td>
							               <td>{{champion.subChampionName}}</td>
						              </tr>
						            </tbody>
						          </table>
                    </pre>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>
```
***

Nota: uso de Patrón MVC

## Probar Aplicación

**1. Levantar Servicios WEB**

![salida-1](https://user-images.githubusercontent.com/7141537/48014372-83a3eb00-e0f4-11e8-9020-04c3893c8cb9.png)

**Probar Conexión**

![wsdl-sal](https://user-images.githubusercontent.com/7141537/48014218-30319d00-e0f4-11e8-8c6c-a6b4f41cf3e6.png)

![wsdl-sal-a](https://user-images.githubusercontent.com/7141537/48014216-2f990680-e0f4-11e8-8fa1-de93c949ca58.png)


**2. Levantar Servicios REST**

![data](https://user-images.githubusercontent.com/7141537/48037691-85dd6800-e13b-11e8-89c2-011fdc7c84cc.png)

**3. Levantar navegador [http://localhost:8585/]**

### Consulta de todos los campeonatos

![sin titulo](https://user-images.githubusercontent.com/7141537/48037808-04d2a080-e13c-11e8-87ff-f654a35f4567.png)

### Consulta de campeonato ganado para un año requerido

![data](https://user-images.githubusercontent.com/7141537/48037852-2e8bc780-e13c-11e8-96ad-68c075ba76ba.png)

![data](https://user-images.githubusercontent.com/7141537/48037893-4d8a5980-e13c-11e8-9d97-bcf24aa667ad.png)

### Consulta de todos los campeonatos ganados por un país por cantidad de ganados

![data](https://user-images.githubusercontent.com/7141537/48037913-6d218200-e13c-11e8-80fe-32739934732d.png)

![data](https://user-images.githubusercontent.com/7141537/48037936-80345200-e13c-11e8-986c-fa4febc41852.png)





