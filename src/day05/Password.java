package day05;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by tjen on 06/12/16.
 */
public class Password {
    private final String[] password;

    public Password(int length) {
        this.password = new String[length];
    }

    public boolean isFull() {
        for (String letter : password) {
            if (letter == null)
                return false;
        }
        return true;
    }

    void add(String letter) {
        for (int i = 0; i < password.length; i++) {
            if (password[i] == null) {
                password[i] = letter;
                return;
            }
        }
    }

    void set(String letter, int position) {
        if (position >= password.length)
            return;
        if (password[position] != null)
            return;
        password[position] = letter;
        // ignore incorrect positions
    }

    @Override
    public String toString() {
        return Arrays.stream(password)
                .map(letter -> letter == null ? " " : letter)
                .collect(Collectors.joining());
    }

    public Password addIndex(String input) {
        String hash = MD5.hash(input);
        if ("00000".equals(hash.substring(0, 5))) {
            this.add(hash.substring(5, 6));
        }
        return this;
    }

    public Password addIndex2(String input) {
        String hash = MD5.hash(input);
        try {
            if ("00000".equals(hash.substring(0, 5))) {
                System.out.println(input + "=" + hash);
                int passwordPosition = Integer.parseInt(hash.substring(5, 6));
                String letter = hash.substring(6, 7);
                this.set(letter, passwordPosition);
            }
        } catch (NumberFormatException e) {
            //ignore
        }
        return this;
    }
}
