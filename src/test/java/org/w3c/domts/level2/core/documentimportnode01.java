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
import org.w3c.dom.*;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The importNode method imports a node from another document to this document.
 * The returned node has no parent; (parentNode is null). The source node is not
 * altered or removed from the original document but a new copy of the source node
 * is created.
 * Using the method importNode with deep=true, import the attribute, "street" of the second
 * element node, from a list of nodes whose local names are "address" and namespaceURI
 * "http://www.nist.gov" into the same document.  Check the parentNode, nodeName,
 * nodeType and nodeValue of the imported node to verify if it has been imported correctly.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
public class documentimportnode01 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Element element;
        Attr attr;
        NodeList childList;
        Node importedAttr;
        String nodeName;
        int nodeType;
        String nodeValue;

        String sExpected = "Y";//TODO: "Yes" if Entities

        doc = load("staffNS", true);
        childList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element = (Element) childList.item(1);
        attr = element.getAttributeNode("street");
        importedAttr = doc.importNode(attr, false);
        nodeName = importedAttr.getNodeName();
        nodeValue = importedAttr.getNodeValue();
        nodeType = importedAttr.getNodeType();
        assertEquals("documentimportnode01_nodeName", "street", nodeName);
        assertEquals("documentimportnode01_nodeType", 2, nodeType);
        assertEquals("documentimportnode01_nodeValue", sExpected, nodeValue);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode01";
    }

}
