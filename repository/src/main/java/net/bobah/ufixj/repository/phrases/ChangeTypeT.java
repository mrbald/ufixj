//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.05 at 12:57:11 PM CEST 
//


package net.bobah.ufixj.repository.phrases;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeType_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="changeType_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Editorial"/>
 *     &lt;enumeration value="Definitional"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "changeType_t")
@XmlEnum
public enum ChangeTypeT {

    @XmlEnumValue("Editorial")
    EDITORIAL("Editorial"),
    @XmlEnumValue("Definitional")
    DEFINITIONAL("Definitional");
    private final String value;

    ChangeTypeT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChangeTypeT fromValue(String v) {
        for (ChangeTypeT c: ChangeTypeT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
