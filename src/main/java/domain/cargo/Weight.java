package domain.cargo;

import java.util.Objects;

import static com.google.common.base.Preconditions.*;

public class Weight {

    private final float value;

    public Weight(float weightInGrams) {
        checkArgument(weightInGrams >= 0, "Weight must be greater than 0");
        value = weightInGrams;
    }

    public float getGrams() {
        return value;
    }

    public float getKilo() {
        return value / 1000;
    }

    public float getTon() {
        return value / 1_000_000;
    }

    public Weight add(Weight weight) {
        float totalWeight = value + weight.getGrams();
        return new Weight(totalWeight);
    }

    public Weight subtract(Weight weight) {
        float totalWeight = value - weight.getGrams();
        return new Weight(totalWeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return getGrams() == weight.getGrams();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "grams=" + value +
                '}';
    }
}
