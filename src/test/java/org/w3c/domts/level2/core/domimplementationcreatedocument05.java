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
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertTrue;


/**
 * The createDocument method should throw a NAMESPACE_ERR if the qualifiedName has
 * a prefix that is xml and the namespaceURI is different from
 * http://www..w3.org/XML/1998/namespace.
 * <p>
 * Call the createDocument on this DOMImplementation with namespaceURI that is
 * http://www.w3.org/xml/1998/namespace and a qualifiedName that has the prefix xml
 * Check if the NAMESPACE_ERR is thrown.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
 */
public class domimplementationcreatedocument05 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        DOMImplementation domImpl;
        Document newDoc;
        String namespaceURI = "http://www.w3.org/xml/1998/namespace";
        String qualifiedName = "xml:root";
        DocumentType docType = null;

        doc = load("staffNS", false);
        domImpl = doc.getImplementation();

        {
            boolean success = false;
            try {
                newDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("domimplementationcreatedocument05, NS  http://www.w3.org/xml/1998/namespace and a qualifiedName that has the prefix xml", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/domimplementationcreatedocument05";
    }

}
