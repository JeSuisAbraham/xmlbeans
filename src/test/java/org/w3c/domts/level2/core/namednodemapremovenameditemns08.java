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

import static org.junit.Assert.assertTrue;


/**
 * The method removeNamedItemNS removes a node using its namespaceURI and localName and
 * raises a NOT_FOUND_ERR if there is no node with the specified namespaceURI and
 * localName in this map
 * Retreive an attribute node from a namednodemap.  Remove the attribute node from the document
 * object.  Since NamedNodeMaps are live it should also automatically get removed from
 * the node map.  And so if an attempt is made to remove it using removeAttributeNS, this should
 * raise a NOT_FOUND_ERR.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
 */
public class namednodemapremovenameditemns08 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NamedNodeMap attributes;
        Element element;
        Attr attribute;
        NodeList elementList;
        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element = (Element) elementList.item(1);
        attributes = element.getAttributes();
        element.removeAttributeNS("http://www.nist.gov", "domestic");

        {
            boolean success = false;
            try {
                attribute = (Attr) attributes.removeNamedItemNS("http://www.nist.gov", "domestic");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NOT_FOUND_ERR);
            }
            assertTrue("namednodemapremovenameditemns08", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapremovenameditemns08";
    }

}
