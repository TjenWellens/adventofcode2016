import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tjen on 05/12/16.
 */
public abstract class BaseInput {
    protected final String filename;

    public BaseInput(String filename) {
        this.filename = "./resources/" + filename;
    }

    private List<String> readLines() {
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
