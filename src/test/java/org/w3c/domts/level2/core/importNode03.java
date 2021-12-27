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
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Comment.
 * Create a comment node with value being the string "this is a comment" in
 * a different document.  Invoke method importNode(importedNode,deep) on
 * this document.  Method should return a comment node whose value matches
 * the above string. The returned node should belong to this document whose
 * systemId is "staff.dtd"
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode03 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Document aNewDoc;
        Comment comment;
        Node aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String value;
        doc = load("staffNS", true);
        aNewDoc = load("staffNS", true);
        comment = aNewDoc.createComment("this is a comment");
        aNode = doc.importNode(comment, false);
        ownerDocument = aNode.getOwnerDocument();
        docType = null;//ownerDocument.getDoctype();
//      system = docType.getSystemId();
        //    assertURIEquals("systemId", null, null, null, "staffNS.dtd", null, null, null, null, system);
        value = aNode.getNodeValue();
        assertEquals("nodeValue", "this is a comment", value);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode03";
    }

}
