package dg.mon.hw.ch02;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;


public class SVGSample {
    public static void main(String[] args) throws Exception {
        draw();
    }

    public static void draw() throws IOException {
        // THE FOLLOWING CODE BASED ON THE EXAMPLE IN THE BATIK DOCUMENTATION...
        // Get a DOMImplementation
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        // Create an instance of org.w3c.dom.Document
        Document document = domImpl.createDocument(null, "svg", null);
        // Create an instance of the SVG Generator
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        // set the precision to avoid a null pointer exception in Batik 1.5
        svgGenerator.getGeneratorContext().setPrecision(6);

        float size = 200;
        float offset = size / 2;

        int iOffset = (int) offset;

        Shape square = new Rectangle2D.Double(offset, offset, size, size);
        Shape rectangle = new Rectangle2D.Double(offset + 400, offset, size, size/2);

        Shape circle = new Ellipse2D.Double(offset, offset + 400, size, size);
        Shape ellipse = new Ellipse2D.Double(offset + 400, offset  / 2+ 400, size, size / 2);

//        Shape triangle = new Polygon(new int[] {150, 150 + iOffset, 150 -iOffset}, new int[] {150 -iOffset, 150 + iOffset, 150 + iOffset}, 3);
//        Shape diamond = new Polygon(new int[] {150, 150+iOffset, 150, 150-iOffset}, new int[] {150-iOffset, 150, 150+iOffset, 150}, 4);

        svgGenerator.setPaint(Color.red);
        svgGenerator.draw(square);
        svgGenerator.setPaint(Color.blue);
        svgGenerator.draw(rectangle);
        svgGenerator.setPaint(Color.yellow);
        svgGenerator.draw(circle);
        svgGenerator.setPaint(Color.green);
        svgGenerator.draw(ellipse);
//        svgGenerator.draw(triangle);
//        svgGenerator.draw(diamond);

        // stream out SVG to a file using UTF-8 character to byte encoding
        boolean useCSS = true;
        Writer out = new OutputStreamWriter(new FileOutputStream(new File("test.svg")), "UTF-8");
        svgGenerator.stream(out, useCSS);
    }
}
