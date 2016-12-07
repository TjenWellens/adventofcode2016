package day03.ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjen on 03/12/16.
 */
public class Triple {
    public final int a;
    public final int b;
    public final int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple triple = (Triple) o;

        if (a != triple.a) return false;
        if (b != triple.b) return false;
        return c == triple.c;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + "," + c + ')';
    }

    public static class Builder{
        List<Integer> numbers = new ArrayList<>();

        public boolean add(Integer integer) {
            return numbers.add(integer);
        }

        public Triple create() {
            return new Triple(
                    numbers.get(0),
                    numbers.get(1),
                    numbers.get(2)
            );
        }
    }
}
