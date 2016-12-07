package day02.ex1;

import day02.Coord;
import day02.Keypad;

/**
 * Created by tjen on 03/12/16.
 */
public class CodeULDR {

    private Coord coord;
    private Keypad keypad;

    public CodeULDR(Keypad keypad) {
        coord = keypad.getOrigin();
        this.keypad = keypad;
    }

    public void move(char dir) {
        Direction d = Direction.valueOf("" + dir);
        final Coord attempt = this.coord.move(d);
        if (keypad.isAllowed(attempt))
            this.coord = attempt;
    }

    public static String calc(String[] input, Keypad keypad) {
        String total = "";
        CodeULDR code = new CodeULDR(keypad);
        for (String in : input) {
            for (char dir : in.toCharArray()) {
                code.move(dir);
            }
            total += keypad.getKey(code.coord);
        }
        return total;
    }

    @Override
    public String toString() {
        return "" + keypad.getKey(this.coord);
    }

}
