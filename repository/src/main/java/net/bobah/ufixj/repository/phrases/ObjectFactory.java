//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.05 at 12:57:11 PM CEST 
//


package net.bobah.ufixj.repository.phrases;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.bobah.ufixj.repository.phrases package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.bobah.ufixj.repository.phrases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Phrase }
     * 
     */
    public Phrase createPhrase() {
        return new Phrase();
    }

    /**
     * Create an instance of {@link Text }
     * 
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link Phrases }
     * 
     */
    public Phrases createPhrases() {
        return new Phrases();
    }

    /**
     * Create an instance of {@link DatatypeXMLT }
     * 
     */
    public DatatypeXMLT createDatatypeXMLT() {
        return new DatatypeXMLT();
    }

}
