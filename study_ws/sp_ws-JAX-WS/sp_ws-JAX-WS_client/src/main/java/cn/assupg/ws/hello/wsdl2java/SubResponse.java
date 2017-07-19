
package cn.assupg.ws.hello.wsdl2java;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subResponse", propOrder = {
    "subResult"
})
public class SubResponse {

    protected int subResult;

    /**
     * Gets the value of the subResult property.
     * 
     */
    public int getSubResult() {
        return subResult;
    }

    /**
     * Sets the value of the subResult property.
     * 
     */
    public void setSubResult(int value) {
        this.subResult = value;
    }

}
