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
import org.w3c.dom.*;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * The "importNode(importedNode,deep)" method for a
 * Document should import the given importedNode into that Document.
 * The importedNode is of type Entity.
 * Retrieve entity "ent4" from staffNS.xml document.
 * Invoke method importNode(importedNode,deep) on this document with deep as false.
 * Method should return a node of type Entity whose descendant is copied.
 * The returned node should belong to this document whose systemId is "staffNS.dtd"
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class importNode12 extends DOMTestCase {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        Document aNewDoc;
        DocumentType doc1Type;
        NamedNodeMap entityList;
        Entity entity2;
        Entity entity1;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String entityName;
        Node child;
        String childName;
        doc = load("staffNS", true);
        aNewDoc = load("staffNS", true);

        doc1Type = aNewDoc.getDoctype();
        entityList = doc1Type.getEntities();
        entity2 = (Entity) entityList.getNamedItem("ent4");
        entity1 = (Entity) doc.importNode(entity2, true);
        ownerDocument = entity1.getOwnerDocument();
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null, null, null, null, system);
        entityName = entity1.getNodeName();
        assertEquals("entityName", "ent4", entityName);
        child = entity1.getFirstChild();
        assertNotNull("notnull", child);
        childName = child.getNodeName();
        assertEquals("childName", "entElement1", childName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/importNode12";
    }

}
