package Car;

import java.util.Arrays;
import java.util.stream.Stream;

public class Car {
    private String name;
    Car (String name) {
        validateName(name);
        this.name = name;
    }
    private void validateName (String name) {
        Stream<String> stream = Arrays.stream(name.split(","));
        long count = stream.filter(s -> s.length() > 5).count();
        if (count>0) throw new CarNameException();
    }

}
