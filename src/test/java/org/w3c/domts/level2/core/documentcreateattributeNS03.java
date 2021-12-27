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
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertTrue;


/**
 * The method createAttributeNS raises an INVALID_CHARACTER_ERR if the specified
 * qualified name contains an illegal character
 * <p>
 * Invoke the createAttributeNS method on this Document object with a valid value for
 * namespaceURI, and qualifiedNames that contain illegal characters.  Check if the an
 * INVALID_CHARACTER_ERR was thrown.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
 */
public class documentcreateattributeNS03 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Attr attribute;
        String namespaceURI = "http://www.w3.org/DOM/Test/Level2";
        String qualifiedName;
        java.util.List qualifiedNames = new java.util.ArrayList();
        qualifiedNames.add("/");
        qualifiedNames.add("//");
        qualifiedNames.add("\\");
        qualifiedNames.add(";");
        qualifiedNames.add("&");
        qualifiedNames.add("*");
        qualifiedNames.add("]]");
        qualifiedNames.add(">");
        qualifiedNames.add("<");

        doc = load("staffNS", false);
        for (int indexd312e67 = 0; indexd312e67 < qualifiedNames.size(); indexd312e67++) {
            qualifiedName = (String) qualifiedNames.get(indexd312e67);

            {
                boolean success = false;
                try {
                    attribute = doc.createAttributeNS(namespaceURI, qualifiedName);
                } catch (DOMException ex) {
                    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
                }
                assertTrue("documentcreateattributeNS03", success);
            }
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentcreateattributeNS03";
    }

}
