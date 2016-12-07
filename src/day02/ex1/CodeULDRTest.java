package day02.ex1;

import day02.Day02;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tjen on 03/12/16.
 */
public class CodeULDRTest {

    @Test
    public void testEx1_1(){
        String[] input = new String[]{
                "ULL",
                "RRDDD",
                "LURDL",
                "UUUUD",
        };
        assertEquals("1985", CodeULDR.calc(input, Day02.KEYPAD_1));
    }

    @Test
    public void testEx1_2(){
        assertEquals("18843", CodeULDR.calc(Day02.input, Day02.KEYPAD_1));
    }

    @Test
    public void testEx2_1(){
        String[] input = new String[]{
                "ULL",
                "RRDDD",
                "LURDL",
                "UUUUD",
        };
        assertEquals("5DB3", CodeULDR.calc(input, Day02.KEYPAD_2));
    }

    @Test
    public void testEx2_2(){
        assertEquals("67BB9", CodeULDR.calc(Day02.input, Day02.KEYPAD_2));
    }
}