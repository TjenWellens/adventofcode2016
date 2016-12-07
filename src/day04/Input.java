package day04;

import day03.ex1.Triple;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by tjen on 04/12/16.
 */
public class Input {
    private static String filename = "./resources/day04.txt";

    public static List<String> numbersByRow = readLines(filename);

    private static List<String> readLines(String filename) {
        List<String> lines = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        return lines;
    }
}
