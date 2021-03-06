//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.05 at 12:56:32 PM CEST 
//


package net.bobah.ufixj.repository.repo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Example" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}XML" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}entityAttribGrp"/>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="baseType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "example",
    "xml"
})
@XmlRootElement(name = "datatype")
public class Datatype {

    @XmlElement(name = "Example")
    protected List<Object> example;
    @XmlElement(name = "XML")
    protected XML xml;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "baseType")
    protected String baseType;
    @XmlAttribute(name = "added")
    protected String added;
    @XmlAttribute(name = "addedEP")
    protected BigInteger addedEP;
    @XmlAttribute(name = "changeType")
    protected ChangeTypeT changeType;
    @XmlAttribute(name = "custom")
    protected Short custom;
    @XmlAttribute(name = "deprecated")
    protected String deprecated;
    @XmlAttribute(name = "deprecatedEP")
    protected BigInteger deprecatedEP;
    @XmlAttribute(name = "elaborationTextId")
    protected String elaborationTextId;
    @XmlAttribute(name = "issue")
    protected String issue;
    @XmlAttribute(name = "lastModified")
    protected String lastModified;
    @XmlAttribute(name = "replaced")
    protected String replaced;
    @XmlAttribute(name = "replacedEP")
    protected BigInteger replacedEP;
    @XmlAttribute(name = "supported")
    protected Short supported;
    @XmlAttribute(name = "textId")
    protected String textId;
    @XmlAttribute(name = "updated")
    protected String updated;
    @XmlAttribute(name = "updatedEP")
    protected BigInteger updatedEP;

    /**
     * Gets the value of the example property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the example property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExample().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getExample() {
        if (example == null) {
            example = new ArrayList<Object>();
        }
        return this.example;
    }

    /**
     * Gets the value of the xml property.
     * 
     * @return
     *     possible object is
     *     {@link XML }
     *     
     */
    public XML getXML() {
        return xml;
    }

    /**
     * Sets the value of the xml property.
     * 
     * @param value
     *     allowed object is
     *     {@link XML }
     *     
     */
    public void setXML(XML value) {
        this.xml = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the baseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseType() {
        return baseType;
    }

    /**
     * Sets the value of the baseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseType(String value) {
        this.baseType = value;
    }

    /**
     * Gets the value of the added property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdded() {
        return added;
    }

    /**
     * Sets the value of the added property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdded(String value) {
        this.added = value;
    }

    /**
     * Gets the value of the addedEP property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddedEP() {
        return addedEP;
    }

    /**
     * Sets the value of the addedEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddedEP(BigInteger value) {
        this.addedEP = value;
    }

    /**
     * Gets the value of the changeType property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeTypeT }
     *     
     */
    public ChangeTypeT getChangeType() {
        return changeType;
    }

    /**
     * Sets the value of the changeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeTypeT }
     *     
     */
    public void setChangeType(ChangeTypeT value) {
        this.changeType = value;
    }

    /**
     * Gets the value of the custom property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCustom() {
        return custom;
    }

    /**
     * Sets the value of the custom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCustom(Short value) {
        this.custom = value;
    }

    /**
     * Gets the value of the deprecated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeprecated() {
        return deprecated;
    }

    /**
     * Sets the value of the deprecated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeprecated(String value) {
        this.deprecated = value;
    }

    /**
     * Gets the value of the deprecatedEP property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeprecatedEP() {
        return deprecatedEP;
    }

    /**
     * Sets the value of the deprecatedEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeprecatedEP(BigInteger value) {
        this.deprecatedEP = value;
    }

    /**
     * Gets the value of the elaborationTextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElaborationTextId() {
        return elaborationTextId;
    }

    /**
     * Sets the value of the elaborationTextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElaborationTextId(String value) {
        this.elaborationTextId = value;
    }

    /**
     * Gets the value of the issue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Sets the value of the issue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssue(String value) {
        this.issue = value;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModified(String value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the replaced property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplaced() {
        return replaced;
    }

    /**
     * Sets the value of the replaced property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplaced(String value) {
        this.replaced = value;
    }

    /**
     * Gets the value of the replacedEP property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReplacedEP() {
        return replacedEP;
    }

    /**
     * Sets the value of the replacedEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReplacedEP(BigInteger value) {
        this.replacedEP = value;
    }

    /**
     * Gets the value of the supported property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSupported() {
        return supported;
    }

    /**
     * Sets the value of the supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSupported(Short value) {
        this.supported = value;
    }

    /**
     * Gets the value of the textId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextId() {
        return textId;
    }

    /**
     * Sets the value of the textId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextId(String value) {
        this.textId = value;
    }

    /**
     * Gets the value of the updated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdated(String value) {
        this.updated = value;
    }

    /**
     * Gets the value of the updatedEP property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUpdatedEP() {
        return updatedEP;
    }

    /**
     * Sets the value of the updatedEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUpdatedEP(BigInteger value) {
        this.updatedEP = value;
    }

}
