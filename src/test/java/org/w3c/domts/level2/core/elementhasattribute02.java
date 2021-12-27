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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertTrue;


/**
 * The method hasAttribute returns true when an attribute with a given name is specified
 * on this element or has a default value, false otherwise
 * Invoke the hasAttribute method to on an element with default attributes and verify if it
 * returns true.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
 */
public class elementhasattribute02 extends DOMTestCase {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        Element element;
        boolean state;
        NodeList elementList;
        doc = load("staffNS", false);
        elementList = doc.getElementsByTagName("emp:employee");
        element = (Element) elementList.item(0);
        state = element.hasAttribute("defaultAttr");
        assertTrue("elementhasattribute02", state);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/elementhasattribute02";
    }

}
