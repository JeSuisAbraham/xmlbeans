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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The "createElementNS(namespaceURI,qualifiedName)" method for a
 * Document should return a new Element object given that all parameters
 * are valid and correctly formed.
 * <p>
 * Invoke method createElementNS(namespaceURI,qualifiedName on this document
 * with namespaceURI as "http://www.nist.gov" and qualifiedName as "gov:faculty".
 * Method should return a new Element object whose name is "gov:faculty".
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815</a>
 */
public class createElementNS05 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        String namespaceURI = "http://www.nist.gov";
        String qualifiedName = "gov:faculty";
        Document doc;
        Element newElement;
        String elementName;
        doc = load("staffNS", false);
        newElement = doc.createElementNS(namespaceURI, qualifiedName);
        elementName = newElement.getTagName();
        assertEquals("throw_Equals", qualifiedName, elementName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/createElementNS05";
    }

}
