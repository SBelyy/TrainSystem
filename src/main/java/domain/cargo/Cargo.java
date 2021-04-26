package domain.cargo;

import java.util.Objects;

public class Cargo {

    private final int number;
    private final Weight weight;
    private final CargoType typeCargo;

    public Cargo(int number, Weight weight, CargoType typeCargo) {
        this.number = number;
        this.weight = weight;
        this.typeCargo = typeCargo;
    }

    public int getNumber() {
        return number;
    }

    public Weight getWeight() {
        return weight;
    }

    public CargoType getTypeCargo() {
        return typeCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return number == cargo.number && Objects.equals(weight, cargo.weight) && typeCargo == cargo.typeCargo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, weight, typeCargo);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "number=" + number +
                " " + weight +
                ", typeCargo=" + typeCargo +
                '}';
    }
}
