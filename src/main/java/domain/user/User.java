package domain.user;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class User {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    public User(String firstName, String lastName, LocalDate birthday) {
        checkArgument(birthday.isBefore(LocalDate.now()), "Such a person has not yet been born");
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }

}
