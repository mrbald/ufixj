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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element ref="{}messageEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}entityAttribGrp"/>
 *       &lt;attribute name="id" use="required" type="{}id_t" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{}ComponentType_t" />
 *       &lt;attribute name="repeating" type="{}BOOL_t" />
 *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="abbrName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="notReqXML" type="{}BOOL_t" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageEntity"
})
@XmlRootElement(name = "component")
public class Component {

    @XmlElementRef(name = "messageEntity", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends MessageEntityT>> messageEntity;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "type", required = true)
    protected ComponentTypeT type;
    @XmlAttribute(name = "repeating")
    protected Short repeating;
    @XmlAttribute(name = "category")
    protected String category;
    @XmlAttribute(name = "abbrName")
    protected String abbrName;
    @XmlAttribute(name = "notReqXML")
    protected Short notReqXML;
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
     * Gets the value of the messageEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ComponentRef }{@code >}
     * {@link JAXBElement }{@code <}{@link FieldRef }{@code >}
     * {@link JAXBElement }{@code <}{@link RepeatingGroup }{@code >}
     * {@link JAXBElement }{@code <}{@link MessageEntityT }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends MessageEntityT>> getMessageEntity() {
        if (messageEntity == null) {
            messageEntity = new ArrayList<JAXBElement<? extends MessageEntityT>>();
        }
        return this.messageEntity;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentTypeT }
     *     
     */
    public ComponentTypeT getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentTypeT }
     *     
     */
    public void setType(ComponentTypeT value) {
        this.type = value;
    }

    /**
     * Gets the value of the repeating property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRepeating() {
        return repeating;
    }

    /**
     * Sets the value of the repeating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRepeating(Short value) {
        this.repeating = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the abbrName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbrName() {
        return abbrName;
    }

    /**
     * Sets the value of the abbrName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbrName(String value) {
        this.abbrName = value;
    }

    /**
     * Gets the value of the notReqXML property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNotReqXML() {
        return notReqXML;
    }

    /**
     * Sets the value of the notReqXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNotReqXML(Short value) {
        this.notReqXML = value;
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
