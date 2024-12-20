package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserTest03Xml() throws Exception {
        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));

        verify(cal).push(45.0);
        verify(cal).push(3.0);

        verify(cal).perform(Operation.sin);
;
        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testDotProduct05Xml() throws Exception {
        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test05.xml"));

        verify(cal).push(1.0);
        verify(cal, times(2)).push(2.0);
        verify(cal).push(3.0);
        verify(cal).push(4.0);
        verify(cal, times(2)).push(2.0);

        verify(cal).perform(Operation.dotproduct);



        verifyNoMoreInteractions(cal);
    }
}