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

import static org.junit.Assert.assertEquals;


/**
 * The method setNamedItemNS adds a node using its namespaceURI and localName and
 * raises a WRONG_DOCUMENT_ERR if arg was created from a different document than the
 * one that created this map.
 * Retreieve the second element whose local name is address and its attribute into a named node map.
 * Create a new document and a new attribute node in it.  Call the setNamedItemNS using the first
 * namedNodeMap and the new attribute node attribute of the new document.  This should
 * raise a WRONG_DOCUMENT_ERR.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 */
public class namednodemapsetnameditemns04 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        DOMImplementation domImpl;
        Document docAlt;
        DocumentType docType = null;

        NamedNodeMap attributes;
        NodeList elementList;
        Element element;
        Attr attrAlt;
        Node newNode;
        // String nullNS = null;
        String nullNS = "";


        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("*", "address");
        element = (Element) elementList.item(1);
        attributes = element.getAttributes();
        domImpl = doc.getImplementation();
        docAlt = domImpl.createDocument(nullNS, "newDoc", docType);
        attrAlt = docAlt.createAttributeNS(nullNS, "street");

        {
            boolean success = false;
            try {
                newNode = attributes.setNamedItemNS(attrAlt);
            } catch (DOMException ex) {
                assertEquals(ex.code, DOMException.WRONG_DOCUMENT_ERR);
            }

        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapsetnameditemns04";
    }

}
