package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;
import org.junit.experimental.theories.suppliers.TestedOn;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }


    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }

    @Test
    public void testModuloOperationSuccess() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(5);
        calc.push(2);

        double result = calc.perform(Operation.mod);

        assertEquals(1, result, 0);
    }

    @Test
    public void testModuloOperationResultZero() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(4);
        calc.push(2);

        double result = calc.perform(Operation.mod);

        assertEquals(0, result, 0);
    }

    @Test
    public void testModuloOperationFailure() throws CalculatorException {
        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }

    @Test
    public void testCosOperation() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(48);

        double result = calc.perform(Operation.cos);

        assertEquals(0.6691306063588582, result, 0);
    }

    @Test
    public void testSinOperation() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(90);

        double result = calc.perform(Operation.sin);

        assertEquals(1.0, result, 0);
    }

    @Test
    public void testScalarProduct() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(1.0); //a1
        calc.push(3.0); //a2
        calc.push(2.0); //b1
        calc.push(4.0); //b2

        calc.push(2.0); //size

        double result = calc.perform(Operation.dotproduct);

        assertEquals(14.0, result, 0);
    }

    @Test()
    public void testNegScalarProdukt() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(1.0); //a1
            calc.push(3.0); //a2
            calc.push(2.0); //b1

            calc.push(2.0); //size

            double result = calc.perform(Operation.dotproduct);


        } catch (CalculatorException e) {
            assertEquals("Not Enough Elements", e.getMessage());
        }

    }
}