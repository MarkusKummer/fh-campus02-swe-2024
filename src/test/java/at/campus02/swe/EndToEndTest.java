package at.campus02.swe;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class EndToEndTest {
    @Test
    public void testParserTest01Xml() throws Exception {
        assertEquals(5, parseTestXml("src/test/resources/testEnd2End01.xml"), 0);
    }

    @Test
    public void testParserTest02Xml() throws Exception {
        assertEquals(6, parseTestXml("src/test/resources/testEnd2End02.xml"), 0);
    }

    @Test
    public void testParserTest03XmlSin() throws Exception {
        assertEquals(34, parseTestXml("src/test/resources/testEnd2End03.xml"), 0);
    }

    @Test
    public void testParserTest04XmlCos() throws Exception {
        assertEquals(1, parseTestXml("src/test/resources/testEnd2End04.xml"), 0);
    }

    @Test
    public void testParserTest05Xml() throws Exception {
        assertEquals(14, parseTestXml("src/test/resources/testEnd2End05.xml"), 0);
    }

    private double parseTestXml(String xmlFile) throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        return (parser.parse(new File(xmlFile)));
    }
}
