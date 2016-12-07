package day03.ex1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class InvalidTrianglesTest {
    @Test
    public void readInput() {
        assertEquals(new Triple(566, 477, 376), Input.numbersByRow.get(1 - 1));
        assertEquals(new Triple(252, 812, 623), Input.numbersByRow.get(284 - 1));
    }

    @Test
    public void testSimpleCase() {
        final Triple COUNT = new Triple(1, 1, 1);
        final Triple IGNORE = new Triple(1, 1, 5);
        assertEquals(1, InvalidTriangles.calc(Arrays.asList(
                new Triple(1, 1, 1)
        )));
        assertEquals(0, InvalidTriangles.calc(Arrays.asList(
                new Triple(5, 1, 1)
        )));
        assertEquals(0, InvalidTriangles.calc(Arrays.asList(
                new Triple(1, 5, 1)
        )));
        assertEquals(0, InvalidTriangles.calc(Arrays.asList(
                new Triple(1, 1, 5)
        )));


        assertEquals(1, InvalidTriangles.calc(Arrays.asList(
                IGNORE,
                COUNT
        )));
        assertEquals(2, InvalidTriangles.calc(Arrays.asList(
                IGNORE,
                COUNT,
                COUNT
        )));
    }

    @Test
    public void testInput() {
        assertEquals(1050, InvalidTriangles.calc(Input.numbersByRow));
    }

    @Test
    public void testInputByColumnConverter() {
        final List<Triple> triples = Arrays.stream(new int[][]{
                {101, 301, 501},
                {102, 302, 502},
                {103, 303, 503},
                {201, 401, 601},
                {202, 402, 602},
                {203, 403, 603}
        })
                .map(arr -> new Triple(arr[0], arr[1], arr[2]))
                .collect(Collectors.toList());

        final List<Triple> expected = Arrays.asList(
                new Triple(101, 102, 103),
                new Triple(301, 302, 303),
                new Triple(501, 502, 503),

                new Triple(201, 202, 203),
                new Triple(401, 402, 403),
                new Triple(601, 602, 603)
                );

        final List<Triple> actual = Input.readNumbersByColumn(triples);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputByColumn() {
        assertEquals(1921, InvalidTriangles.calc(Input.numbersByColumn));
    }
}