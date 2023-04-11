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
package org.apache.xmlbeans.samples.abstracttypes;

import abstractFigures.*;
import figures.*;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/**
 * Test class that builds a document using type substitution
 */
public class AbstractTypes
{
    public static void main(String[] args)
    {
      try
      {
        buildDocument(true);
      }
      catch (Throwable t)
      {
        t.printStackTrace();
      }
      try
      {
        buildDocument2(true);
      }
      catch (Throwable t)
      {
        t.printStackTrace();
      }
      try
      {
        parseDocument(true);
      }
      catch (Throwable t)
      {
        t.printStackTrace();
      }
    }

    public static XmlObject buildDocument(boolean enableOutput)
    {
        if (enableOutput)
            System.out.println("buildDocument:\n");
        XmlOptions opt = (new XmlOptions()).setSavePrettyPrint();

        // Build a new document
        RootDocument doc = RootDocument.Factory.newInstance();
        RootDocument.Root figures = doc.addNewRoot();
        if (enableOutput)
            System.out.println("Empty document:\n" + doc.xmlText(opt) + "\n");

        // Add abstract figures
        Shape s1 = figures.addNewFigure();
        s1.setId("001");
        Shape s2 = figures.addNewFigure();
        s2.setId("002");
        // Document contains two shapes now
        // Because the shape is abstract, the document will not yet be valid
        if (enableOutput)
        {
            System.out.println("Document containing the abstract types:\n" + doc.xmlText(opt));
            System.out.println("Valid = " + doc.validate() + "\n");
        }

        // Change the abstract figures to concrete ones
        Circle circle = (Circle) s1.changeType(Circle.type);
        circle.setRadius(10.0);
        Square square = (Square) s2.changeType(Square.type);
        square.setSide(20.0);
        // Document contains two concrete shapes and is valid
        if (enableOutput)
        {
            System.out.println("Final document:\n" + doc.xmlText(opt));
            System.out.println("Valid = " + doc.validate());
        }

        return doc;
    }

    public static XmlObject buildDocument2(boolean enableOutput)
    {
        if (enableOutput)
            System.out.println("buildDocument2:\n");
        XmlOptions opt = (new XmlOptions()).setSavePrettyPrint();

        // Build a new document
        RootDocument doc = RootDocument.Factory.newInstance();
        RootDocument.Root figures = doc.addNewRoot();
        if (enableOutput)
            System.out.println("Empty document:\n" + doc.xmlText(opt) + "\n");

        Circle circle = Circle.Factory.newInstance();
        circle.setRadius(10.0);
        Square square = Square.Factory.newInstance();
        square.setSide(20.0);
        figures.setFigureArray(new Shape[] {circle, square});

        // Document contains two concrete shapes and is valid
        if (enableOutput)
        {
            System.out.println("Final document:\n" + doc.xmlText(opt));
            System.out.println("Valid = " + doc.validate());
        }

        return doc;
    }
    
    public static void parseDocument(boolean enableOutput) throws XmlException
    {
        if (enableOutput)
            System.out.println("parseDocument:\n");
        XmlOptions opt = (new XmlOptions()).setSavePrettyPrint();

        String document = 
            "<abs:root xmlns:abs=\"AbstractFigures\">\r\n"
            + "  <figure xsi:type=\"fig:circle\" xmlns:fig=\"Figures\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
            + "    <radius>10.0</radius>\r\n"
            + "  </figure>\r\n"
            + "  <figure xsi:type=\"fig:square\" xmlns:fig=\"Figures\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
            + "    <side>20.0</side>\r\n"
            + "  </figure>\r\n"
            + "</abs:root>";
        RootDocument doc = RootDocument.Factory.parse(document);
        
        Shape[] shapeArray = doc.getRoot().getFigureArray();
        System.out.println("Shape #1 is a Circle? " + (shapeArray[0] instanceof Circle));
        System.out.println("Shape #2 is a Square? " + (shapeArray[1] instanceof Square));

        // Document contains two concrete shapes and is valid
        if (enableOutput)
        {
            System.out.println("Final document:\n" + doc.xmlText(opt));
            System.out.println("Valid = " + doc.validate());
        }
    }
}
