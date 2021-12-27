/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2003 World Wide Web Consortium,
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

import static org.junit.Assert.fail;


/**
 * Retreive an entity and notation node and remove the first notation from the
 * entity node map and first entity node from the notation map.  Since both these
 * maps are readonly, a NO_MODIFICATION_ALLOWED_ERR should be raised.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=407">http://www.w3.org/Bugs/Public/show_bug.cgi?id=407</a>
 * @see <a href="http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html">http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html</a>
 */

public class namednodemapremovenameditemns05 extends DOMTestCase {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        DocumentType docType;
        NamedNodeMap entities;
        NamedNodeMap notations;
        Node removedNode;
        String nullNS = null;

        doc = load("staffNS", true);
        docType = doc.getDoctype();
        entities = docType.getEntities();
        notations = docType.getNotations();

        try {
            removedNode = entities.removeNamedItemNS(nullNS, "ent1");
            fail("entity_throw_DOMException");

        } catch (DOMException ex) {
            switch (ex.code) {
                case 8:
                    break;
                case 7:
                    break;
                default:
                    throw ex;
            }
        }

        try {
            removedNode = notations.removeNamedItemNS(nullNS, "notation1");
            fail("notation_throw_DOMException");

        } catch (DOMException ex) {
            switch (ex.code) {
                case 8:
                    break;
                case 7:
                    break;
                default:
                    throw ex;
            }
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapremovenameditemns05";
    }

}
