package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.google.common.base.Preconditions.*;

public class Weight {

    private final BigDecimal value;

    public Weight(float weightInGrams) {
        checkArgument(weightInGrams > 0, "Weight must be greater than 0");
        value = new BigDecimal(weightInGrams);
    }

    public float getGrams() {
        return value.floatValue();
    }

    public float getKilo() {
        BigDecimal divider = new BigDecimal(1000);
        BigDecimal kilo = value.divide(divider, 6, RoundingMode.FLOOR);
        return kilo.floatValue();
    }

    public float getTon() {
        BigDecimal divider = new BigDecimal(1_000_000);
        BigDecimal ton = value.divide(divider, 6, RoundingMode.FLOOR);
        return ton.floatValue();
    }

}
