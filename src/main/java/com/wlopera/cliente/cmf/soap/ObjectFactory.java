
package com.wlopera.cliente.cmf.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wlopera.cliente.cmf.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCMFPorAnnio_QNAME = new QName("http://cliente.wlopera.com/", "getCMFPorAnnio");
    private final static QName _GetCMFPorAnnioResponse_QNAME = new QName("http://cliente.wlopera.com/", "getCMFPorAnnioResponse");
    private final static QName _GetListaCMFPorCampeonatoGanado_QNAME = new QName("http://cliente.wlopera.com/", "getListaCMFPorCampeonatoGanado");
    private final static QName _GetListaCMFPorCampeonatoGanadoResponse_QNAME = new QName("http://cliente.wlopera.com/", "getListaCMFPorCampeonatoGanadoResponse");
    private final static QName _GetListaCMFTodos_QNAME = new QName("http://cliente.wlopera.com/", "getListaCMFTodos");
    private final static QName _GetListaCMFTodosResponse_QNAME = new QName("http://cliente.wlopera.com/", "getListaCMFTodosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wlopera.cliente.cmf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCMFPorAnnio }
     * 
     */
    public GetCMFPorAnnio createGetCMFPorAnnio() {
        return new GetCMFPorAnnio();
    }

    /**
     * Create an instance of {@link GetCMFPorAnnioResponse }
     * 
     */
    public GetCMFPorAnnioResponse createGetCMFPorAnnioResponse() {
        return new GetCMFPorAnnioResponse();
    }

    /**
     * Create an instance of {@link GetListaCMFPorCampeonatoGanado }
     * 
     */
    public GetListaCMFPorCampeonatoGanado createGetListaCMFPorCampeonatoGanado() {
        return new GetListaCMFPorCampeonatoGanado();
    }

    /**
     * Create an instance of {@link GetListaCMFPorCampeonatoGanadoResponse }
     * 
     */
    public GetListaCMFPorCampeonatoGanadoResponse createGetListaCMFPorCampeonatoGanadoResponse() {
        return new GetListaCMFPorCampeonatoGanadoResponse();
    }

    /**
     * Create an instance of {@link GetListaCMFTodos }
     * 
     */
    public GetListaCMFTodos createGetListaCMFTodos() {
        return new GetListaCMFTodos();
    }

    /**
     * Create an instance of {@link GetListaCMFTodosResponse }
     * 
     */
    public GetListaCMFTodosResponse createGetListaCMFTodosResponse() {
        return new GetListaCMFTodosResponse();
    }

    /**
     * Create an instance of {@link Campeonato }
     * 
     */
    public Campeonato createCampeonato() {
        return new Campeonato();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCMFPorAnnio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCMFPorAnnio }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getCMFPorAnnio")
    public JAXBElement<GetCMFPorAnnio> createGetCMFPorAnnio(GetCMFPorAnnio value) {
        return new JAXBElement<GetCMFPorAnnio>(_GetCMFPorAnnio_QNAME, GetCMFPorAnnio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCMFPorAnnioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCMFPorAnnioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getCMFPorAnnioResponse")
    public JAXBElement<GetCMFPorAnnioResponse> createGetCMFPorAnnioResponse(GetCMFPorAnnioResponse value) {
        return new JAXBElement<GetCMFPorAnnioResponse>(_GetCMFPorAnnioResponse_QNAME, GetCMFPorAnnioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaCMFPorCampeonatoGanado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetListaCMFPorCampeonatoGanado }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getListaCMFPorCampeonatoGanado")
    public JAXBElement<GetListaCMFPorCampeonatoGanado> createGetListaCMFPorCampeonatoGanado(GetListaCMFPorCampeonatoGanado value) {
        return new JAXBElement<GetListaCMFPorCampeonatoGanado>(_GetListaCMFPorCampeonatoGanado_QNAME, GetListaCMFPorCampeonatoGanado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaCMFPorCampeonatoGanadoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetListaCMFPorCampeonatoGanadoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getListaCMFPorCampeonatoGanadoResponse")
    public JAXBElement<GetListaCMFPorCampeonatoGanadoResponse> createGetListaCMFPorCampeonatoGanadoResponse(GetListaCMFPorCampeonatoGanadoResponse value) {
        return new JAXBElement<GetListaCMFPorCampeonatoGanadoResponse>(_GetListaCMFPorCampeonatoGanadoResponse_QNAME, GetListaCMFPorCampeonatoGanadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaCMFTodos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetListaCMFTodos }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getListaCMFTodos")
    public JAXBElement<GetListaCMFTodos> createGetListaCMFTodos(GetListaCMFTodos value) {
        return new JAXBElement<GetListaCMFTodos>(_GetListaCMFTodos_QNAME, GetListaCMFTodos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaCMFTodosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetListaCMFTodosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cliente.wlopera.com/", name = "getListaCMFTodosResponse")
    public JAXBElement<GetListaCMFTodosResponse> createGetListaCMFTodosResponse(GetListaCMFTodosResponse value) {
        return new JAXBElement<GetListaCMFTodosResponse>(_GetListaCMFTodosResponse_QNAME, GetListaCMFTodosResponse.class, null, value);
    }

}
