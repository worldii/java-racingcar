package Car;

import java.util.Arrays;
import java.util.stream.Stream;

public class Car {
    private String name;
    private int curPosition ;

    Car(String name) {
        validateName(name);
        this.name = name;
        this.curPosition =0;
    }

    private void validateName(String name) {
        long count = Arrays.stream(name.split(",")).filter(s -> s.length() > 5).count();
        if (count > 0) throw new CarNameException();
    }

    public void move(int number) {
        if (number >= 4) curPosition++;
    }
    public int getCurPosition() {
        return curPosition;
    }
}
