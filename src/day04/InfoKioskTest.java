package day04;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tjen on 04/12/16.
 */
public class InfoKioskTest {
    @Test
    public void createRoom() {
        Room room = new Room("aaaaa-bbb-z-y-x-123[abxyz]");
        assertEquals("aaaaa-bbb-z-y-x", room.name);
        assertEquals(123, room.id);
        assertEquals("abxyz", room.checksum);
    }

    @Test
    public void calculateChecksum() {
        assertEquals("abxyz", Room.calculateChecksum("aaaaa-bbb-z-y-x"));
    }

    @Test
    public void isRealRoom() {
        assertTrue(new Room("aaaaa-bbb-z-y-x-123[abxyz]").isReal());
        assertTrue(new Room("a-b-c-d-e-f-g-h-987[abcde]").isReal());
        assertTrue(new Room("not-a-real-room-404[oarel]").isReal());

        assertFalse(new Room("totally-real-room-200[decoy]").isReal());
    }

    @Test
    public void calc() {
        List<String> input = Arrays.asList(
                "aaaaa-bbb-z-y-x-123[abxyz]",
                "a-b-c-d-e-f-g-h-987[abcde]",
                "not-a-real-room-404[oarel]",
                "totally-real-room-200[decoy]" // not
        );
        assertEquals(123 + 987 + 404, InfoKiosk.calc(input));
    }

    @Test
    public void calcInput() {
        assertEquals(278221, InfoKiosk.calc(Input.numbersByRow));
    }

    @Test
    public void testDecrypt() {
        assertEquals("very encrypted name", new Room("qzmt-zixmtkozy-ivhz-343[]").decryptName());
    }

    @Test
    public void decryptInput() {
        final int actual = Input.numbersByRow
                .stream()
                .filter(s -> "northpole object storage".equals(new Room(s).decryptName()))
                .map(s -> new Room(s).id)
                .findFirst()
                .get();
        assertEquals(267, actual);
    }
}