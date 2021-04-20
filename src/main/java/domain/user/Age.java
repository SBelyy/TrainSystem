package domain.user;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.*;

public class Age {

    public static Map<Byte, Age> agesPool = new HashMap<>();
    private final byte value;

    private Age(byte value) {
        checkArgument(value >= 0, "Age must be positive");
        checkArgument(value <= 125, "Age must be <= 125");
        this.value = value;
    }

    public static Age valueOf(int age) {
        byte byteAge = (byte) age;
        final Age fromPool = agesPool.get(byteAge);
        if (fromPool != null) {
            return fromPool;
        }
        final Age newAge = new Age(byteAge);
        agesPool.put(byteAge, newAge);

        return newAge;
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Age = " + value + " years";
    }

}
