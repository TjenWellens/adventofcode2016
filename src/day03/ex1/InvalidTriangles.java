package day03.ex1;

import java.util.List;

/**
 * Created by tjen on 03/12/16.
 */
public class InvalidTriangles {

    public static int calc(List<Triple> triples) {
        return (int) triples.stream()
                .filter(triple -> triple.a + triple.b > triple.c)
                .filter(triple -> triple.b + triple.c > triple.a)
                .filter(triple -> triple.c + triple.a > triple.b)
                .count();
    }
}
