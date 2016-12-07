package day01.ex2;

import java.util.*;

/**
 * Created by tjen on 03/12/16.
 */
public class LocationStepper {

    public static int firstLocationTwice(String input) {
        String[] dirs = input.split(", ");

        Coord coord = Coord.ORIGIN;
        Direction direction = Direction.NORTH;

        Set<Coord> coords = new HashSet<>();
        coords.add(coord);

        for (String dir : dirs) {
            String lr = dir.substring(0, 1);
            int amount = Integer.parseInt(dir.substring(1));

            direction = direction.move(lr);
            for (Coord step: coord.move(direction, amount)) {
                coord = step;
                if(!coords.add(coord)) {
                    return coord.getDistanceFromOrigin();
                }
            }
        }
        return -1;
    }

    static class Coord {
        public static final Coord ORIGIN = new Coord(0, 0);
        private final int x;
        private final int y;

        private Coord(int x, int y) {
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

        public Collection<Coord> move(Direction direction, int amount) {
            Collection<Coord> steps = new LinkedList<>();

            for (int i = 1; i <= amount; i++) {
                int dx = direction.dx * i;
                int dy = direction.dy * i;
                steps.add(new Coord(this.x + dx, this.y + dy));
            }

            return steps;
        }

        public int getDistanceFromOrigin() {
            return Math.abs(this.x) + Math.abs(this.y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ')';
        }
    }
}
