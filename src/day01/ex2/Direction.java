package day01.ex2;

/**
 * Created by tjen on 01/12/16.
 */
public enum Direction {
    NORTH(0,-1),
    EAST(1,0),
    SOUTH(0,1),
    WEST(-1,0);

    private static final int AMOUNT = Direction.values().length;
    public final int dx;
    public final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction move(String lr) {
        int direction = this.ordinal();

        if ("R".equals(lr)) {
            direction--;
        } else if ("L".equals(lr)) {
            direction++;
        } else {
            throw new IllegalArgumentException("unknown move: " + lr);
        }

        direction += AMOUNT;
        direction %= AMOUNT;
        return Direction.values()[direction];
    }
}
