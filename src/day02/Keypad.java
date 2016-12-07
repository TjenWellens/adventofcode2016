package day02;

/**
 * Created by tjen on 03/12/16.
 */
public class Keypad {
    private char illegal = ' ';
    char[][] keys;
    Coord origin;

    public Keypad(char[][] keys, Coord origin) {
        this.keys = keys;
        this.origin = origin;
    }

    public char getKey(Coord coord) {
        return keys[coord.y][coord.x];
    }

    public boolean isAllowed(Coord coord) {
        return getKey(coord) != illegal;
    }

    public Coord getOrigin() {
        return origin;
    }
}
