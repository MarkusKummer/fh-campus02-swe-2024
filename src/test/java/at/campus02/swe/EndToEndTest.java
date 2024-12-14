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

    private double parseTestXml(String xmlFile) throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        return (parser.parse(new File(xmlFile)));
    }
}
