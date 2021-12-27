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


import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertNull;


/**
 * The "getOwnerElement()" will return the Element node this attribute is attached to or
 * null if this attribute is not in use.
 * <p>
 * Import an attribute node to another document.  If an Attr node is imported, its
 * ownerElement attribute should be set to null.  Verify if the ownerElement has been set
 * to null.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
 */
public class attrgetownerelement04 extends DOMTestCase {

    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        Document docImp;
        Node ownerElement;
        Element element;
        Attr attr;
        Attr attrImp;
        doc = load("staffNS", false);
        docImp = load("staff", false);
        element = doc.getElementById("CANADA");
        attr = element.getAttributeNodeNS("http://www.nist.gov", "zone");
        attrImp = (Attr) docImp.importNode(attr, true);
        ownerElement = attrImp.getOwnerElement();
        assertNull("attrgetownerelement04", ownerElement);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/attrgetownerelement04";
    }

}
