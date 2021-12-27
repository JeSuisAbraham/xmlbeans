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
 * The method getNamedItemNS retrieves a node specified by local name and namespace URI.
 * Using the method getNamedItemNS, retreive an attribute node having namespaceURI=http://www.nist.gov
 * and localName=domestic, from a NamedNodeMap of attribute nodes, for the second element
 * whose namespaceURI=http://www.nist.gov and localName=address.  Verify if the attr node
 * has been retreived successfully by checking its nodeName atttribute.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
 */
public class namednodemapgetnameditemns02 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NamedNodeMap attributes;
        Node element;
        Attr attribute;
        NodeList elementList;
        String attrName;
        doc = load("staffNS", false);
        elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element = elementList.item(1);
        attributes = element.getAttributes();
        attribute = (Attr) attributes.getNamedItemNS("http://www.nist.gov", "domestic");
        attrName = attribute.getNodeName();
        assertEquals("namednodemapgetnameditemns02", "emp:domestic", attrName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapgetnameditemns02";
    }

}
