package day02.ex1;

/**
 * Created by tjen on 01/12/16.
 */
public enum Direction {
    U(0,-1),
    R(1,0),
    D(0,1),
    L(-1,0);

    private static final int AMOUNT = Direction.values().length;
    public final int dx;
    public final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
