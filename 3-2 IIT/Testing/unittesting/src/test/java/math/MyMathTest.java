package math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {
    private MyMath myMath;

    @Before
    public void setUp() throws Exception {
        myMath= new MyMath();
    }

    @Test
    public void factorial() {
        assertEquals(24,myMath.factorial(4), 0.0001 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialWhen_n_isGreaterThan_12(){
        myMath.factorial(13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialWhen_n_isLessThan_0(){
        myMath.factorial(-1);
    }

    @Test
    public void isPrime() {
        assertTrue(myMath.isPrime(13));
    }

    @Test
    public void isNotPrime() {
        assertFalse(myMath.isPrime(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPrime_whenInputLessThan_2()
    {
        myMath.isPrime(1);
    }

}