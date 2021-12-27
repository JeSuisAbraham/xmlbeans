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
import org.w3c.dom.Node;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertNull;


/**
 * The "getLocalName()" method for a Node
 * returns the local part of the qualified name of this node,
 * and for nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE
 * and nodes created with a DOM Level 1 method, this is null.
 * <p>
 * Create an new Element with the createElement() method.
 * Invoke the "getLocalName()" method on the newly created element
 * node will cause "null" to be returned.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
 */
public class localName02 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Node createdNode;
        String localName;
        doc = load("staffNS", false);
        createdNode = doc.createElement("test:employee");
        localName = createdNode.getLocalName();
        assertNull("throw_Null," +
                   "Expected: nodeName attribute set to tagName, and localName, " +
                   "prefix, and namespaceURI set to null", localName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/localName02";
    }

}
