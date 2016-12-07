package day05;

/**
 * Created by tjen on 05/12/16.
 */
public class Door {
    private final String id;

    public Door(String id) {
        this.id = id;
    }

    public String calc() {
        Password password = new Password(8);
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            while (!password.isFull()) {
                password.addIndex(this.id + counter);
                counter++;
            }
        }

        return password.toString();
    }

    public String calc2() {
        Password password = new Password(8);

        int counter = 0;
        for (int i = 0; i < 8; i++) {
            while (!password.isFull()) {
                password.addIndex2(this.id + counter);
                counter++;
            }
        }

        return password.toString();
    }

}
