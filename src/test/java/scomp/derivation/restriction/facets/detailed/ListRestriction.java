/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package scomp.derivation.restriction.facets.detailed;

import org.apache.xmlbeans.XmlErrorCodes;
import org.junit.Test;
import scomp.common.BaseCase;
import xbean.scomp.derivation.facets.list.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 */
public class ListRestriction extends BaseCase {
    @Test
    public void testLengthFacet() throws Throwable {
        LengthEltDocument doc = LengthEltDocument.Factory.newInstance();
        List<String> vals = new ArrayList<>();
        vals.add("lstsmall");

        doc.setLengthElt(vals);
        //this should be too short
        assertFalse(doc.validate(validateOptions));
        showErrors();
        String[] errExpected = new String[]{
            XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH};
        assertTrue(compareErrorCodes(errExpected));

        vals.add("lstsmall");
        doc.setLengthElt(vals);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }
        //this should be too long
        vals.add("lstsmall");
        doc.setLengthElt(vals);
        clearErrors();
        assertFalse(doc.validate(validateOptions));
        showErrors();
        errExpected = new String[]{
            XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH
        };
        assertTrue(compareErrorCodes(errExpected));

    }

    @Test
    public void testMinLengthFacet() throws Throwable {
        String input =
                "<MinLengthElt xmlns=\"http://xbean/scomp/derivation/facets/List\">" +
                "lstsmall lstlarge lstsmall" +
                "</MinLengthElt>";
        MinLengthEltDocument doc = MinLengthEltDocument.Factory.parse(input);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }

        List vals = doc.getMinLengthElt();
        assertEquals(3, vals.size());
        List newvals = new ArrayList(vals);
        newvals.remove(0);
        newvals.remove(1);
        assertEquals(1, newvals.size());

        doc.setMinLengthElt(newvals);
        assertEquals(doc.getMinLengthElt().size(),
                doc.xgetMinLengthElt().getListValue().size());
        assertEquals(1, doc.xgetMinLengthElt().getListValue().size());

        assertEquals("lstlarge",
                (String) doc.xgetMinLengthElt().getListValue().get(0));
        assertFalse(doc.validate(validateOptions));
        showErrors();
        String[] errExpected = new String[]{
            XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH
        };
        assertTrue(compareErrorCodes(errExpected));


    }

    @Test
    public void testMaxLengthFacet() throws Throwable {
        String input =
                "<MaxLengthElt xmlns=\"http://xbean/scomp/derivation/facets/List\">" +
                "lstsmall lstlarge lstsmall" +
                "</MaxLengthElt>";
        MaxLengthEltDocument doc = MaxLengthEltDocument.Factory.parse(input);
        assertFalse(doc.validate(validateOptions));
        showErrors();
        String[] errExpected = new String[]{
            XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH};
        assertTrue(compareErrorCodes(errExpected));

        MaxLengthFacet elt = MaxLengthFacet.Factory.newInstance();
        List<String> vals = new ArrayList<>();
        vals.add("lstsmall");
        vals.add("lstsmall");
        //why is there no xsetListValue method here?
        elt.setListValue(vals);
        doc.xsetMaxLengthElt(elt);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }
    }

    /**
     * Walmsley, p. 215...
     */
    @Test
    public void testEnum() throws Throwable {
        EnumEltDocument doc = EnumEltDocument.Factory.newInstance();
        List<Object> vals = new ArrayList<>();
        vals.add("small");
        vals.add("medium");
        vals.add("large");
        doc.setEnumElt(vals);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }
        vals.clear();
        vals.add(2);
        vals.add(3);
        vals.add(1);
        doc.setEnumElt(vals);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }

        vals.clear();
        vals.add("small");
        vals.add(10);
        doc.setEnumElt(vals);
        assertFalse(doc.validate(validateOptions));
        showErrors();
        String[] errExpected = new String[]{
            XmlErrorCodes.DATATYPE_VALID$UNION
        };
        assertTrue(compareErrorCodes(errExpected));

    }

    @Test
    public void testPattern() throws Throwable {
        PatternEltDocument doc = PatternEltDocument.Factory.newInstance();
        List<Integer> vals = new ArrayList<>();
        vals.add(152);
        vals.add(154);
        vals.add(156);
        vals.add(918);

        vals.add(342);
        doc.setPatternElt(vals);
        try {
            assertTrue(doc.validate(validateOptions));
        } catch (Throwable t) {
            showErrors();
            throw t;
        }
    }
}
