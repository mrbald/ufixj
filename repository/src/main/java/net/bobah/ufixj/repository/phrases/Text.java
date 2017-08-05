//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.05 at 12:57:11 PM CEST 
//


package net.bobah.ufixj.repository.phrases;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3c.dom.Element;


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
 *         &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}entityAttribGrp"/>
 *       &lt;attribute name="langId" type="{}language_t" />
 *       &lt;attribute name="purpose" type="{}purpose_t" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "text")
public class Text {

    @XmlMixed
    @XmlAnyElement
    protected List<Object> content;
    @XmlAttribute(name = "langId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String langId;
    @XmlAttribute(name = "purpose")
    protected PurposeT purpose;
    @XmlAttribute(name = "id")
    protected BigInteger id;
    @XmlAttribute(name = "deprecated")
    protected String deprecated;
    @XmlAttribute(name = "whenAdded")
    protected String whenAdded;
    @XmlAttribute(name = "lastModified")
    protected String lastModified;
    @XmlAttribute(name = "changeType")
    protected ChangeTypeT changeType;
    @XmlAttribute(name = "custom")
    protected Short custom;
    @XmlAttribute(name = "supported")
    protected Short supported;
    @XmlAttribute(name = "textId")
    protected String textId;
    @XmlAttribute(name = "discussionId")
    protected String discussionId;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the langId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangId() {
        return langId;
    }

    /**
     * Sets the value of the langId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangId(String value) {
        this.langId = value;
    }

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link PurposeT }
     *     
     */
    public PurposeT getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurposeT }
     *     
     */
    public void setPurpose(PurposeT value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
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
     * Gets the value of the whenAdded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhenAdded() {
        return whenAdded;
    }

    /**
     * Sets the value of the whenAdded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhenAdded(String value) {
        this.whenAdded = value;
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
     * Gets the value of the discussionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscussionId() {
        return discussionId;
    }

    /**
     * Sets the value of the discussionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscussionId(String value) {
        this.discussionId = value;
    }

}
