package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticOperationsTest {
 private ArithmeticOperations arithmeticOperations;

    @org.junit.Before
    public void setUp() throws Exception {
        arithmeticOperations= new ArithmeticOperations();
    }

    @org.junit.Test
    public void divide() {
        assertEquals(2.0, arithmeticOperations.divide(10, 5), 0.0001);
    }

   @Test(expected = ArithmeticException.class)
   public void TestdividethrowsArithmeticExceptionWhenDenominatorZero() {
     arithmeticOperations.divide(10, 0);
   }

    @org.junit.Test
    public void multiply() {
     assertEquals(10.0, arithmeticOperations.multiply(2, 5), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestmultiplyWhenFirstNumberNegative()
    {
     arithmeticOperations.multiply(-5, 6);
    }

 @Test(expected = IllegalArgumentException.class)
 public void TestmultiplyWhenSecondNumberNegative()
 {
  arithmeticOperations.multiply(9, -7);
 }

 @Test(expected = IllegalArgumentException.class)
 public void TestmultiplyWhenProductNotInteger()
 {
  arithmeticOperations.multiply(1, Integer.MAX_VALUE+1);
 }
}