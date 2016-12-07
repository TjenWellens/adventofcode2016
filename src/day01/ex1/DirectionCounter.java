package day01.ex1;

import java.util.Arrays;

/**
 * Created by tjen on 01/12/16.
 */
public class DirectionCounter {
    int[] dirs = new int[4];
    int currentDirection = Direction.NORTH.ordinal();

    public void add(String dirString) {
        String lr = dirString.substring(0, 1);
        String amount = dirString.substring(1);

        if ("R".equals(lr)) {
            currentDirection--;
        } else if ("L".equals(lr)) {
            currentDirection++;
        } else {
            throw new IllegalArgumentException("unknown dirstring: " + dirString);
        }
        currentDirection += 4;
        currentDirection %= 4;
        dirs[currentDirection] += Integer.parseInt(amount);
    }


    public int getReduced() {
        int[] reduced = Arrays.copyOf(dirs, dirs.length);

        final int vertical = Math.min(reduced[0], reduced[2]);
        reduced[0] = reduced[0] - vertical;
        final int horizontal = Math.min(reduced[1], reduced[3]);
        reduced[1] = reduced[1] - horizontal;
        reduced[2] = reduced[2] - vertical;
        reduced[3] = reduced[3] - horizontal;

        int sum = 0;

        for (int i = 0; i < reduced.length; i++) {
            sum += reduced[i];
        }

        return sum;
    }

    public static int calc(String input){
        DirectionCounter directionCounter = new DirectionCounter();
        String[] dirs = input.split(", ");

        for (String dir: dirs) {
            directionCounter.add(dir);
        }

        return directionCounter.getReduced();
    }
}
