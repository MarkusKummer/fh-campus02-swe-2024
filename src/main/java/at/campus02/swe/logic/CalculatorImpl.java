package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.ArrayList;
import java.util.Stack;

import static at.campus02.swe.Calculator.Operation.*;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    private double performSingleOperation(Operation op) throws CalculatorException {
        double a = pop();

        switch (op) {
            case cos:
                return (Math.cos(Math.toRadians(a % 360)));
            case sin:
                return (Math.sin(Math.toRadians(a % 360)));
        }

        return 0.0;

    }

    private double performScalarproduct(Operation op) throws CalculatorException {
        int size = (int) pop();

        double[] a = new double[size];
        double[] b = new double[size];

        for(int i = 0; i < size; i++) {
            try{
                b[i] = pop();
            } catch (CalculatorException e) {
                throw new CalculatorException("Not Enough Elements", e);
            }
        }

        for(int i = 0; i < size; i++) {
            try{
                a[i] = pop();
            } catch (CalculatorException e) {
                throw new CalculatorException("Not Enough Elements", e);
            }
        }

        double returnValue = 0;
        for(int i = 0; i < size; i++) {
            returnValue += a[i] * b[i];
        }

        return returnValue;

    }

    @Override
    public double perform(Operation op) throws CalculatorException {
        if (op == sin || op == cos) return performSingleOperation(op);
        if (op == dotproduct) return performScalarproduct(op);

        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                double d = a / b;
                if (Double.isInfinite(d))
                    throw new CalculatorException("Division by zero");
                return a % b;
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
