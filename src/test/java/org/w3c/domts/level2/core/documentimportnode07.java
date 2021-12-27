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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertTrue;


/**
 * The importNode method imports a node from another document to this document.
 * A NOT_SUPPORTED_ERR is raised if the type of node being imported is
 * not supported
 * Using the method importNode with deep=true, try to import this Document's
 * DocumentType object. Since DocumentType nodes cannot be imported, a
 * NOT_SUPPORTED_ERR should be raised.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */


/**
 * @ ignore true
 */
public class documentimportnode07 extends DOMTestCase {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        Node imported;
        DocumentType docType;
        doc = load("staffNS", true);
        docType = doc.getDoctype();

        {
            boolean success = false;
            try {
                imported = doc.importNode(docType, true);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
            }
            assertTrue("documentimportnode07", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode07";
    }

}
