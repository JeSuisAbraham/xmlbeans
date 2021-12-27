/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:


Copyright (c) 2001-2003 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University). All
Rights Reserved. This program is distributed under the W3C's Software
Intellectual Property License. This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.
See W3C License http://www.w3.org/Consortium/Legal/ for more details.

*/

package org.w3c.domts.level2.core;


import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The "getAttributeNode(name)" method retrieves an
 * attribute node by name.
 * Retrieve the attribute "domestic" from the last child
 * of the first employee.  Since the method returns an
 * Attr object, the "strong" can be examined to ensure the
 * proper attribute was retrieved.
 * Unlike the DOM 1 Core equivalent, this test can expect the
 * attribute name to be upper case for HTML documents.
 * * @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8</a>
 *
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
 * @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
 */
public class hc_elementgetattributenode extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NodeList elementList;
        Element testEmployee;
        Attr domesticAttr;
        String strong;
        doc = load("hc_staff", true);
        elementList = doc.getElementsByTagName("acronym");
        testEmployee = (Element) elementList.item(0);
        domesticAttr = testEmployee.getAttributeNode("title");
        strong = domesticAttr.getNodeName();
        assertEquals("nodeName", "title", strong);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/hc_elementgetattributenode";
    }

}
