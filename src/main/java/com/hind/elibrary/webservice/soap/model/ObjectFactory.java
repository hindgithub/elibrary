//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.18 at 10:49:04 PM CET 
//


package com.hind.elibrary.webservice.soap.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hind.elibrary.webservice.soap.model package. 
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

    private final static QName _BookRequest_QNAME = new QName("http://hind.com/elibrary/webservice/soap/model", "BookRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hind.elibrary.webservice.soap.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookResponse }
     * 
     */
    public BookResponse createBookResponse() {
        return new BookResponse();
    }

    /**
     * Create an instance of {@link BookType }
     * 
     */
    public BookType createBookType() {
        return new BookType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hind.com/elibrary/webservice/soap/model", name = "BookRequest")
    public JAXBElement<Object> createBookRequest(Object value) {
        return new JAXBElement<Object>(_BookRequest_QNAME, Object.class, null, value);
    }

}
