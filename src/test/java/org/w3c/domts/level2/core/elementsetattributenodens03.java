/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2003 World Wide Web Consortium,
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
 * The method setAttributeNodeNS adds a new attribute and raises the
 * INUSE_ATTRIBUTE_ERR exception if the newAttr is already an attribute of
 * another Element object.
 * Retreive an attribute node of an existing element node.  Attempt to add it to an another
 * element node.  Check if the INUSE_ATTRIBUTE_ERR exception is thrown.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
 */
public class elementsetattributenodens03 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Element element1;
        Element element2;
        Attr attribute;
        Attr newAttribute;
        NodeList elementList;
        String nullNS = null;

        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element1 = (Element) elementList.item(1);
        attribute = element1.getAttributeNodeNS(nullNS, "street");
        element2 = (Element) elementList.item(2);

        {
            boolean success = false;
            try {
                newAttribute = element2.setAttributeNodeNS(attribute);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
            }
            assertTrue("elementsetattributenodens03", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/elementsetattributenodens03";
    }

}
