package day03.ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by tjen on 03/12/16.
 */
public class Input {
    private static String filename = "./resources/day03-input.txt";
    public static List<Triple> numbersByRow = readNumbersByRow();
    public static List<Triple> numbersByColumn = readNumbersByColumn(numbersByRow);

    private static List<Triple> readNumbersByRow() {
        List<Triple> numbers = new ArrayList<>();
        final File file = new File(filename);
        System.out.println(file.exists());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                numbers.add(new Triple(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ));
                if (st.hasMoreTokens())
                    throw new IllegalArgumentException("problem with input line: " + line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return numbers;
    }

    static List<Triple> readNumbersByColumn(List<Triple> numbersByRow) {
        List<Triple> numbers = new LinkedList<>();

        Triple.Builder aCol, bCol, cCol;
        aCol = bCol = cCol = null;

        for (int i = 0; i < numbersByRow.size(); i++) {
            if (i % 3 == 0) {
                if (aCol != null) {
                    numbers.add(aCol.create());
                    numbers.add(bCol.create());
                    numbers.add(cCol.create());
                }
                // start
                aCol = new Triple.Builder();
                bCol = new Triple.Builder();
                cCol = new Triple.Builder();
            }

            aCol.add(numbersByRow.get(i).a);
            bCol.add(numbersByRow.get(i).b);
            cCol.add(numbersByRow.get(i).c);
        }
        if (aCol != null) {
            numbers.add(aCol.create());
            numbers.add(bCol.create());
            numbers.add(cCol.create());
        }
        return numbers;
    }
}
