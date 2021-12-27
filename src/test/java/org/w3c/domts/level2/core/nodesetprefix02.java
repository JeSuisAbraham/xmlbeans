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
 * The method setPrefix sets the namespace prefix of this node.  Note that setting this attribute,
 * when permitted, changes the nodeName attribute, which holds the qualified name, as well as the
 * tagName and name attributes of the Element and Attr interfaces, when applicable.
 * Create a new attribute node and add it to an element node with an existing attribute having
 * the same localName as this attribute but different namespaceURI.  Change the prefix of the
 * newly created attribute using setPrefix.  Check if the new attribute nodeName has changed
 * and the existing attribute is the same.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
 */
public class nodesetprefix02 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Element element;
        Attr attribute;
        Attr newAttribute;
        Node setNode;
        NodeList elementList;
        String attrName;
        String newAttrName;
        doc = load("staffNS", true);
        elementList = doc.getElementsByTagName("address");
        element = (Element) elementList.item(1);
        newAttribute = doc.createAttributeNS("http://www.w3.org/DOM/Test", "test:address");
        setNode = element.setAttributeNodeNS(newAttribute);
        newAttribute.setPrefix("dom");
        attribute = element.getAttributeNodeNS("http://www.usa.com", "domestic");
        attrName = attribute.getNodeName();
        newAttrName = newAttribute.getNodeName();
        assertEquals("nodesetprefix02_attrName", "dmstc:domestic", attrName);
        assertEquals("nodesetprefix02_newAttrName", "dom:address", newAttrName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/nodesetprefix02";
    }

}
