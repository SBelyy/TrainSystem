package domain.user.driver;

import domain.user.User;

import java.time.LocalDate;
import java.util.Date;

import static com.google.common.base.Preconditions.*;

public class TrainDriver extends User {

    private LicenseType typeLicense;

    public TrainDriver(String firstName, String lastName, LocalDate birthday, LicenseType typeLicense) {
        super(firstName, lastName, birthday);
        checkArgument(getAge() >= 18, "The driver's age must be > 18");
        this.typeLicense = typeLicense;
    }

    public LicenseType getTypeLicense() {
        return typeLicense;
    }

    public void setTypeLicense(LicenseType typeLicense) {
        this.typeLicense = typeLicense;
    }

    @Override
    public String toString() {
        return "Train driver name: " + getFirstName() +
                " " + getLastName() +
                "\n" + getAge() +
                "\n" + "License: " + typeLicense;
    }

}
