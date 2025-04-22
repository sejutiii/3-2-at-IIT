package io;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileIOTest {

    private FileIO fileIO;

    @Before
    public void setUp() throws Exception {
        fileIO= new FileIO();
    }

    @Test
    public void readFile() {
        int[] array = {3, 9, 0, 2, 10, 9, 3, 8, 0 , 3};

        assertArrayEquals(array, fileIO.readFile("C:\\Users\\User\\Desktop\\sejuti\\Semester-6\\3-2 IIT\\Testing\\unittesting\\src\\test\\resources\\grades_valid.txt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFile_whenNoFile()
    {
        fileIO.readFile("C:\\Users\\User\\Desktop\\sejuti\\Semester-6\\3-2 IIT\\Testing\\unittesting\\src\\test\\resources\\grades.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFile_whenFileEmpty()
    {
        fileIO.readFile("C:\\Users\\User\\Desktop\\sejuti\\Semester-6\\3-2 IIT\\Testing\\unittesting\\src\\test\\resources\\empty_file.txt");
    }

    @Test(expected = NumberFormatException.class)
    public void readFile_whenInvalidFile()
    {
        fileIO.readFile("C:\\Users\\User\\Desktop\\sejuti\\Semester-6\\3-2 IIT\\Testing\\unittesting\\src\\test\\resources\\grades_invalid.txt");
    }
}