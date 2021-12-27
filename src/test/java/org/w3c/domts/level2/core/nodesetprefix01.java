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
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.domts.DOMTestCase;

import static org.junit.Assert.assertEquals;


/**
 * The method setPrefix sets the namespace prefix of this node.  Note that setting this attribute,
 * when permitted, changes the nodeName attribute, which holds the qualified name, as well as the
 * tagName and name attributes of the Element and Attr interfaces, when applicable.
 * Create a new element node with a namespace prefix.  Add it to a new DocumentFragment Node without
 * a prefix.  Call setPrefix on the elemen node.  Check if the prefix was set correctly on the element.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
 */
public class nodesetprefix01 extends DOMTestCase {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        DocumentFragment docFragment;
        Element element;
        String elementTagName;
        String elementNodeName;
        Node appendedChild;
        doc = load("staff", true);
        docFragment = doc.createDocumentFragment();
        element = doc.createElementNS("http://www.w3.org/DOM/Test", "emp:address");
        appendedChild = docFragment.appendChild(element);
        element.setPrefix("dmstc");
        elementTagName = element.getTagName();
        elementNodeName = element.getNodeName();
        assertEquals("nodesetprefix01_tagname", "dmstc:address", elementTagName);
        assertEquals("nodesetprefix01_nodeName", "dmstc:address", elementNodeName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/nodesetprefix01";
    }

}
