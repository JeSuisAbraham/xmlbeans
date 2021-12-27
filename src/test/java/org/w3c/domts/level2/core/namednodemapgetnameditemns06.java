/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;


import org.junit.Test;
import org.w3c.dom.*;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * Retreive the second address element node having localName=adrress.  Retreive the attributes
 * of this element into 2 nodemaps.  Create a new attribute node and add it to this element.
 * Since NamedNodeMaps are live each one should get updated, using the getNamedItemNS retreive
 * the newly created attribute from each node map.
 * Verify if the attr node has been retreived successfully by checking its nodeName atttribute.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
 */
public class namednodemapgetnameditemns06 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NamedNodeMap attributesMap1;
        NamedNodeMap attributesMap2;
        Element element;
        Attr attribute;
        Attr newAttr1;
        Attr newAttribute;
        NodeList elementList;
        String attrName;
        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("*", "address");
        element = (Element) elementList.item(1);
        attributesMap1 = element.getAttributes();
        attributesMap2 = element.getAttributes();
        newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "street");
        newAttribute = element.setAttributeNodeNS(newAttr1);
        attribute = (Attr) attributesMap1.getNamedItemNS("http://www.w3.org/DOM/L1", "street");
        attrName = attribute.getNodeName();
        assertEquals("namednodemapgetnameditemnsMap106", "street", attrName);
        attribute = (Attr) attributesMap2.getNamedItemNS("http://www.w3.org/DOM/L1", "street");
        attrName = attribute.getNodeName();
        assertEquals("namednodemapgetnameditemnsMap206", "street", attrName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapgetnameditemns06";
    }

}
