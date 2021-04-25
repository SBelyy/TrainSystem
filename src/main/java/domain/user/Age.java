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
        return agesPool.computeIfAbsent((byte) age, Age::new);
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Age = " + value + " years";
    }

}
