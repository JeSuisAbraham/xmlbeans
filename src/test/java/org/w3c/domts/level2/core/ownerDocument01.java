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
import org.w3c.dom.DocumentType;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertNull;


/**
 * The "getOwnerDocument()" method returns null if the target
 * node itself is a DocumentType which is not used with any document yet.
 * <p>
 * Invoke the "getOwnerDocument()" method on the master
 * document.   The DocumentType returned should be null.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc">http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc</a>
 */
public class ownerDocument01 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        DocumentType ownerDocument;
        doc = load("staff", false);
        ownerDocument = (DocumentType) doc.getOwnerDocument();
        assertNull("throw_Null", ownerDocument);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/ownerDocument01";
    }

}
