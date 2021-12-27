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
 * The "setNamedItemNS(arg)" method for a
 * NamedNodeMap should raise INUSE_ATTRIBUTE_ERR DOMException if
 * arg is an Attr that is already an attribute of another Element object.
 * <p>
 * Retrieve an attr node from the third "address" element whose local name
 * is "domestic" and namespaceURI is "http://www.netzero.com".
 * Invoke method setNamedItemNS(arg) on the map of the first "address" element with
 * arg being the attr node from above.  Method should raise
 * INUSE_ATTRIBUTE_ERR DOMException.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
 */
public class setNamedItemNS01 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NodeList elementList;
        Node anotherElement;
        NamedNodeMap anotherMap;
        Node arg;
        Node testAddress;
        NamedNodeMap map;
        Node setNode;
        doc = load("staffNS", true);
        elementList = doc.getElementsByTagName("address");
        anotherElement = elementList.item(2);
        anotherMap = anotherElement.getAttributes();
        arg = anotherMap.getNamedItemNS("http://www.netzero.com", "domestic");
        testAddress = elementList.item(0);
        map = testAddress.getAttributes();

        {
            boolean success = false;
            try {
                setNode = map.setNamedItemNS(arg);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
            }
            assertTrue("throw_INUSE_ATTRIBUTE_ERR", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/setNamedItemNS01";
    }

}
