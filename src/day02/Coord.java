package day02;

import day02.ex1.CodeULDR;
import day02.ex1.Direction;

/**
 * Created by tjen on 03/12/16.
 */
public class Coord {
    public final int x;
    public final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (x != coord.x) return false;
        return y == coord.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Coord move(Direction d) {
        int x = this.x + d.dx;
        int y = this.y + d.dy;
        return new Coord(x, y);
    }

    private static int mod(int i) {
        return Math.abs(i) > 1 ? i / Math.abs(i) : i;
    }

    public int getDistanceFromOrigin() {
        return Math.abs(this.x) + Math.abs(this.y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
