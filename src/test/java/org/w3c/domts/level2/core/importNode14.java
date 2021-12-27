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
import org.w3c.dom.ProcessingInstruction;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Processing Instruction.
 * Create a processing instruction with target as "target1" and data as "data1"
 * in a different document. Invoke method importNode(importedNode,deep) on this document.
 * Method should return a processing instruction whose target and data match the given
 * parameters. The returned PI should belong to this document whose systemId is "staff.dtd".
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode14 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Document aNewDoc;
        ProcessingInstruction pi;
        ProcessingInstruction aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String target;
        String data;
        java.util.List result = new java.util.ArrayList();

        doc = load("staffNS", true);
        aNewDoc = load("staffNS", true);
        pi = aNewDoc.createProcessingInstruction("target1", "data1");
        aNode = (ProcessingInstruction) doc.importNode(pi, false);
        ownerDocument = aNode.getOwnerDocument();
        //$NOTE:add this if ever implemented
      /*
	docType = ownerDocument.getDoctype();
	system = docType.getSystemId();
	assertURIEquals("systemId", null, null, null, "staffNS.dtd", null, null, null, null, system);
      */
        target = aNode.getTarget();
        assertEquals("piTarget", "target1", target);
        data = aNode.getData();
        assertEquals("piData", "data1", data);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode14";
    }

}
