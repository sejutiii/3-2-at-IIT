package math;

import io.FileIO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOperationsTest {

    private ArrayOperations arrayOperations;

    @Before
    public void setUp() throws Exception {
        arrayOperations= new ArrayOperations();
    }

    @Test
    public void findPrimesInFile() {
        int[] array= {3,2,3,3};
        FileIO fileIO= new FileIO();
        MyMath myMath= new MyMath();
        assertArrayEquals(array, arrayOperations.findPrimesInFile(fileIO, "C:\\Users\\User\\Desktop\\sejuti\\Semester-6\\3-2 IIT\\Testing\\unittesting\\src\\test\\resources\\grades_array.txt", myMath));
    }
}