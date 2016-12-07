package day07;

import general.BaseInput;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tjen on 07/12/16.
 */
public class FooTest {

    // interior[hyperseq]...
    @Test
    public void shouldSupportTlsWhenContainsAbbaPattern(){
        assertTrue(new Foo("abba[mnop]qrst").supportsTLS());
        assertTrue(new Foo("bccb[mnop]qrst").supportsTLS());
        assertTrue(new Foo("qrst[mnop]qrst[mnop]bccb").supportsTLS());
    }

    @Test
    public void hypernetSequenceShouldNotContainAbbaPattern(){
        assertFalse(new Foo("abcd[bddb]xyyx").supportsTLS());
        assertFalse(new Foo("abcd[asff]????[bddb]xyyx").supportsTLS());
    }


    @Test
    public void theInteriorCharactersMustBeDifferent(){
        assertFalse(new Foo("aaaa[qwer]tyui").supportsTLS());
    }

    @Test
    public void abbaOutsideSquareBrackets(){
        assertTrue(new Foo("ioxxoj[asdfgh]zxcvbn").supportsTLS());
        assertTrue(new Foo("ioxxo[asdfgh]zxcvbn").supportsTLS());
        assertTrue(new Foo("zxcvbn[asdfgh]ioxxo").supportsTLS());
    }
//    @Test
//    public void foo(){
//        assertFalse(new Foo("dflaghirjcyhylbcenw[dndkrtbxackpdcphny]pnhqmjxdzkjycmdo[fryelfouoaesejoq]tdhcacxuqwfspqevq")
//                .supportsTLS());
//    }

    @Test
    public void inputGreaterThan116(){
        final long count = new BaseInput("day07.txt").readLines().stream()
                .filter(line -> new Foo(line).supportsTLS())
                .count();

        assertTrue(116 < count);
    }

    @Test
    public void inputLessThan161(){
        final long count = new BaseInput("day07.txt").readLines().stream()
                .filter(line -> new Foo(line).supportsTLS())
                .count();

        assertTrue(161 > count);
        assertTrue(123 > count);
    }

    @Test
    public void input(){
        final long count = new BaseInput("day07.txt").readLines().stream()
                .filter(line -> new Foo(line).supportsTLS())
                .count();

        assertEquals(118,  count);
    }

}