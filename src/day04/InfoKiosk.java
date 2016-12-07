package day04;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tjen on 04/12/16.
 */
public class InfoKiosk {

    public static int calc(List<String> input) {
        return input
                .stream()
                .map(str -> new Room(str))
                .filter(room -> room.isReal())
                .collect(Collectors.summingInt(room -> room.id));
    }
}
