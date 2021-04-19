package domain;

public class Cargo {

    private final int number;
    private final Weight weight;

    public Cargo(int number, Weight weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public Weight getWeight() {
        return weight;
    }

}
