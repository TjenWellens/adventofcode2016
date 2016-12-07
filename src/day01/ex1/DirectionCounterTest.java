package day01.ex1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tjen on 01/12/16.
 */
public class DirectionCounterTest {

    @Test
    public void test1(){
        assertEquals(5, DirectionCounter.calc("R2, L3"));
    }

    @Test
    public void test2(){
        assertEquals(2, DirectionCounter.calc("R2, R2, R2"));
    }

    @Test
    public void test3(){
        assertEquals(12, DirectionCounter.calc("R5, L5, R5, R3"));
    }
}