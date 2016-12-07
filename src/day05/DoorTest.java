package day05;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by tjen on 05/12/16.
 */
public class DoorTest {

    // for id "abc"
    final String[] exampleInputs = new String[]{
            "abc3231929",
            "abc5017308",
            "abc5278568",
            "abc5357525",
            "abc5708769",
            "abc6082117",
            "abc8036669",
            "abc8605828",
            "abc8609554",
            "abc8760605",
            "abc9495334",
            "abc10767910",
            "abc11039607",
            "abc12763908",
            "abc13666005",
            "abc13753421"
    };

    // for id "abc"
    final String[] exampleHashes = new String[]{
            "00000155f8105dff7f56ee10fa9b9abd",
            "000008f82c5b3924a1ecbebf60344e00",
            "00000f9a2c309875e05c5a5d09f1b8c4",
            "000004e597bd77c5cd2133e9d885fe7e",
            "0000073848c9ff7a27ca2e942ac10a4c",
            "00000a9c311683dbbf122e9611a1c2d4",
            "000003c75169d14fdb31ec1593915cff",
            "0000000ea49fd3fc1b2f10e02d98ee96",
            "000006e42e097c536b8be5179d65f327",
            "000007b9278b049b172742aa82b5119a",
            "000009d6e11733ceb6566b9c925a0770",
            "00000cf8353c7d266a990865ea529f26",
            "00000d64ba3bbc8102ec6179e495d88e",
            "000006601753bceae1d061b3600deb3e",
            "0000058939cbc6a1d1ab3bf7d29b0764",
            "000002af5a2d97ef50063c37644d0166"
    };

    /*
// for Input.text (aka "wtnhxymk")
wtnhxymk2231254=0000027b9705c7e6fa3d4816c490bbfd
wtnhxymk2440385=00000468c8625d85571d250737c47b5a
wtnhxymk2640705=0000013e3293b49e4c78a5b43b21023b
wtnhxymk3115031=0000040bbe4509b48041007dec6123bd
wtnhxymk5045682=00000b11810477f9e49840991fb2151e
wtnhxymk8562236=00000cc461c8945671046cf632be4473
wtnhxymk9103137=000007c1da6865df78b2c0addf28913d
wtnhxymk9433034=00000700ce8beb0a8ffc83fa9986d577
wtnhxymk9669127=00000d76f344ea0a8643bb2bcf0323c4
wtnhxymk13753308=0000050301b17d598b52e2a343b80c95
wtnhxymk13976178=000006fe7545b487de2d003f3d4e1114
wtnhxymk15855849=000002d5272322770ff5e60b01455753
wtnhxymk16774052=000004f449e36332d8693c3a84f8bf70
wtnhxymk16837862=000002f6b67f02f6c7565a041503ea65
wtnhxymk18302330=0000022f1d102210cb4a6c9dd8cb6715
wtnhxymk19303492=000006fbc50b5e7d1e4c1c390bfc9370
wtnhxymk19808390=000003e432ea631581aefcce573d56dd
wtnhxymk19937884=00000bb78c4ed10825e030cd1c239ad1
wtnhxymk20311461=0000098a3982c7135ad8ad1999ba98a5
wtnhxymk20411973=0000053c41ec1a808dac438da19486ac
wtnhxymk20774189=000001922d8af3ae96feff1a35e2414f
wtnhxymk22811727=00000379365fc17224a1e1e3b672ab02
wtnhxymk23478701=00000eb02c7276f40e60a8e8e2185828
wtnhxymk23744188=000006a9336d4ae05f2dbff912e00604
wtnhxymk24462569=00000740e2fd901d7f98f007b48771cd
wtnhxymk24526626=00000155747b21cea30ef0222d0e7f3c
wtnhxymk25530151=000002f49ca6360dea1cd854d9032331
wtnhxymk27712456=00000048d155e2c930602533209b0154
*/

    final String[] inputInputs = new String[]{
            "wtnhxymk2231254",
            "wtnhxymk2440385",
            "wtnhxymk2640705",
            "wtnhxymk3115031",
            "wtnhxymk5045682",
            "wtnhxymk8562236",
            "wtnhxymk9103137",
            "wtnhxymk9433034",
            "wtnhxymk9669127",
            "wtnhxymk13753308",
            "wtnhxymk13976178",
            "wtnhxymk15855849",
            "wtnhxymk16774052",
            "wtnhxymk16837862",
            "wtnhxymk18302330",
            "wtnhxymk19303492",
            "wtnhxymk19808390",
            "wtnhxymk19937884",
            "wtnhxymk20311461",
            "wtnhxymk20411973",
            "wtnhxymk20774189",
            "wtnhxymk22811727",
            "wtnhxymk23478701",
            "wtnhxymk23744188",
            "wtnhxymk24462569",
            "wtnhxymk24526626",
            "wtnhxymk25530151",
            "wtnhxymk27712456"
    };

    final String[] inputHashes = new String[]{
            "0000027b9705c7e6fa3d4816c490bbfd",
            "00000468c8625d85571d250737c47b5a",
            "0000013e3293b49e4c78a5b43b21023b",
            "0000040bbe4509b48041007dec6123bd",
            "00000b11810477f9e49840991fb2151e",
            "00000cc461c8945671046cf632be4473",
            "000007c1da6865df78b2c0addf28913d",
            "00000700ce8beb0a8ffc83fa9986d577",
            "00000d76f344ea0a8643bb2bcf0323c4",
            "0000050301b17d598b52e2a343b80c95",
            "000006fe7545b487de2d003f3d4e1114",
            "000002d5272322770ff5e60b01455753",
            "000004f449e36332d8693c3a84f8bf70",
            "000002f6b67f02f6c7565a041503ea65",
            "0000022f1d102210cb4a6c9dd8cb6715",
            "000006fbc50b5e7d1e4c1c390bfc9370",
            "000003e432ea631581aefcce573d56dd",
            "00000bb78c4ed10825e030cd1c239ad1",
            "0000098a3982c7135ad8ad1999ba98a5",
            "0000053c41ec1a808dac438da19486ac",
            "000001922d8af3ae96feff1a35e2414f",
            "00000379365fc17224a1e1e3b672ab02",
            "00000eb02c7276f40e60a8e8e2185828",
            "000006a9336d4ae05f2dbff912e00604",
            "00000740e2fd901d7f98f007b48771cd",
            "00000155747b21cea30ef0222d0e7f3c",
            "000002f49ca6360dea1cd854d9032331",
            "00000048d155e2c930602533209b0154"
    };

        @Test
    public void md5() throws NoSuchAlgorithmException, CloneNotSupportedException {
        final String input = "abc3231929";
        assertEquals("00000155f8105dff7f56ee10fa9b9abd", MD5.hash(input));
    }

    @Test
    public void testHashes() {
        for (int i = 0; i < exampleInputs.length; i++) {
            assertEquals(exampleHashes[i], MD5.hash(exampleInputs[i]));
        }
        for (int i = 0; i < inputInputs.length; i++) {
            assertEquals(inputHashes[i], MD5.hash(inputInputs[i]));
        }
    }

        @Test
    public void example() {
        String password = new Door("abc").calc();
        assertEquals("18f", password.substring(0, 3));
    }

            @Test
    public void input() {
        String password = new Door(Input.text).calc();
        assertEquals(8, password.length());
        assertEquals("2414bc77", password);
    }

    @Test
    public void password() {
        assertEquals("1", new Password(1).addIndex("abc3231929").toString());
        assertEquals("8", new Password(1).addIndex("abc5017308").toString());
        assertEquals("f", new Password(1).addIndex("abc5278568").toString());

        assertEquals(" 5      ", new Password(8).addIndex2("abc3231929").toString());
        assertEquals("    e   ", new Password(8).addIndex2("abc5357525").toString());
        assertEquals(" 5  e   ", new Password(8).addIndex2("abc3231929").addIndex2("abc5357525").toString());
    }

    @Test
    public void manual1(){
        Password password = new Password(8);
        for (String input : inputInputs) {
            password.addIndex(input);
        }
        assertEquals("2414bc77", password.toString());
    }

    @Test
    public void manual2(){
        Password password = new Password(8);
        for (String input : inputInputs) {
            password.addIndex2(input);
        }
        assertNotEquals("45f7f3a4", password.toString());
        assertEquals("437e60fc", password.toString());
    }

        @Test
    public void example2() {
        assertEquals("437e60fc", new Door(Input.text).calc2());
    }
}