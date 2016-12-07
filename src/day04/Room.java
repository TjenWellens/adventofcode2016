package day04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


/**
 * Created by tjen on 04/12/16.
 */
public class Room {
    public final String name;
    public final String checksum;
    public final int id;

    public Room(String s) {
        int startId = s.lastIndexOf('-');
        int startChecksum = s.indexOf('[');
        this.name = s.substring(0, startId);
        this.id = Integer.parseInt(s.substring(startId + 1, startChecksum));
        this.checksum = s.substring(startChecksum + 1, s.length() - 1);
    }

    public boolean isReal() {
        return this.checksum.equals(calculateChecksum(this.name));
    }

    String decryptName() {
        final int BASE = 'a';
        return Arrays.stream(this.name.split(""))
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        if("-".equals(s))
                            return " ";

                        int i = s.charAt(0) - BASE;
                        i += Room.this.id;
                        i %= 26;
                        i += BASE;
                        char c = (char) i;

                        return "" + c;
                    }
                })
                .collect(Collectors.joining());
    }

    static String calculateChecksum(String input) {

        return Arrays
                .stream(input.split(""))
                .filter(s -> !"-".equals(s))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(entryComparator.reversed())
                .limit(5)
                .map(entry -> entry.getKey())
                .collect(Collectors.joining());
    }

    private static final Comparator<Map.Entry<String, Long>> entryComparator = new Comparator<Map.Entry<String, Long>>() {
        @Override
        public int compare(Map.Entry<String, Long> a, Map.Entry<String, Long> b) {
            int comparison = a.getValue().compareTo(b.getValue());
            if (comparison == 0) {
                comparison = b.getKey().compareTo(a.getKey());
            }
            return comparison;
        }
    };
}
