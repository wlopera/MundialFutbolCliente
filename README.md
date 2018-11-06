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

Crear paquete donde se generar el codigo seg+un el namespace del WSDL 

http://cliente.wlopera.com/ ==> **com.wlopera.cliente.cmf.soap**

**2. Correr tarea 'install' de gradle para generar el cliente**

![gradle-1](https://user-images.githubusercontent.com/7141537/48035927-16b04580-e134-11e8-808f-81d9ef294e54.png)

Nota: Se puede correr el comango **git install** [uso git]



**1. Entidad**

Clase que permite definir el modelo de datos; requeridos por el Servicio Web.

***
```
```
***


