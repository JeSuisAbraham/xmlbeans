/*
* The Apache Software License, Version 1.1
*
*
* Copyright (c) 2003 The Apache Software Foundation.  All rights 
* reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
*
* 1. Redistributions of source code must retain the above copyright
*    notice, this list of conditions and the following disclaimer. 
*
* 2. Redistributions in binary form must reproduce the above copyright
*    notice, this list of conditions and the following disclaimer in
*    the documentation and/or other materials provided with the
*    distribution.
*
* 3. The end-user documentation included with the redistribution,
*    if any, must include the following acknowledgment:  
*       "This product includes software developed by the
*        Apache Software Foundation (http://www.apache.org/)."
*    Alternately, this acknowledgment may appear in the software itself,
*    if and wherever such third-party acknowledgments normally appear.
*
* 4. The names "Apache" and "Apache Software Foundation" must 
*    not be used to endorse or promote products derived from this
*    software without prior written permission. For written 
*    permission, please contact apache@apache.org.
*
* 5. Products derived from this software may not be called "Apache 
*    XMLBeans", nor may "Apache" appear in their name, without prior 
*    written permission of the Apache Software Foundation.
*
* THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
* OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
* ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
* SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
* LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
* USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
* OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
* SUCH DAMAGE.
* ====================================================================
*
* This software consists of voluntary contributions made by many
* individuals on behalf of the Apache Software Foundation and was
* originally based on software copyright (c) 2000-2003 BEA Systems 
* Inc., <http://www.bea.com/>. For more information on the Apache Software
* Foundation, please see <http://www.apache.org/>.
*/

package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.QNameHelper;

public abstract class JavaStringHolderEx extends JavaStringHolder
{
    private SchemaType _schemaType;

    public SchemaType schemaType()
        { return _schemaType; }

    public JavaStringHolderEx(SchemaType type, boolean complex)
        { _schemaType = type; initComplexType(complex, false); }

    protected int get_wscanon_rule()
    {
        return schemaType().getWhiteSpaceRule();
    }

    protected void set_text(String s)
    {
        if (_validateOnSet())
            validateLexical(s, _schemaType, _voorVc);
                 
        super.set_text(s);
    }

    protected boolean is_defaultable_ws(String v) {
        try {
            validateLexical(v, _schemaType, _voorVc);
            return false;
        }
        catch (XmlValueOutOfRangeException e) {
            return true;
        }
    }

    public static void validateLexical(String v, SchemaType sType, ValidationContext context)
    {
        // check against pattern
        if (!sType.matchPatternFacet(v))
        {
            context.invalid( "String: '" + v + "' does not match pattern for " + QNameHelper.readable(sType));
            return;
        }

        // check against length
        XmlObject len = sType.getFacet(SchemaType.FACET_LENGTH);
        if (len != null)
        {
            int m = ((XmlObjectBase)len).bigIntegerValue().intValue();
            if (v.length() != m)
            {
                context.invalid(
                    "String length (" + v.length() + ") does not match " +
                        "length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }

        // check against min length
        XmlObject min = sType.getFacet(SchemaType.FACET_MIN_LENGTH);
        if (min != null)
        {
            int m = ((XmlObjectBase)min).bigIntegerValue().intValue();
            if (v.length() < m)
            {
                context.invalid(
                    "String length (" + v.length() + ") is less than " +
                        "min length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }

        // check against min length
        XmlObject max = sType.getFacet(SchemaType.FACET_MAX_LENGTH);
        if (max != null)
        {
            int m = ((XmlObjectBase)max).bigIntegerValue().intValue();
            if (v.length() > m)
            {
                context.invalid(
                    "String length (" + v.length() + ") is greater than " +
                        "max length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }
    }
    
    protected void validate_simpleval(String lexical, ValidationContext ctx)
    {
        validateLexical(stringValue(), schemaType(), ctx);
    }
    
}