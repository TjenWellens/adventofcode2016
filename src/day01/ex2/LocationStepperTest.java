package day01.ex2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tjen on 01/12/16.
 */
public class LocationStepperTest {
    @Test
    public void test1(){
        assertEquals(4, LocationStepper.firstLocationTwice("R8, R4, R4, R8"));
    }
}