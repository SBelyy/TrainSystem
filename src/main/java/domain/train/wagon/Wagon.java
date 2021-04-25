package domain.train.wagon;

import com.google.common.base.Preconditions;

public abstract class Wagon {

    private int number;

    public Wagon() {
        number = 0;
    }

    public int getNumber() {
        Preconditions.checkArgument(number != 0,
                "The number of the wagon has not yet been determined");
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
