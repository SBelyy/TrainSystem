package domain.train.wagon;

import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;

import static com.google.common.base.Preconditions.checkArgument;

public class Locomotive extends Wagon {

    private TrainDriver driver;

    public Locomotive(TrainDriver trainDriver) {
        checkArgument(trainDriver.getTypeLicense() == LicenseType.VALID,
                "The driver's license is not valid");
        driver = trainDriver;
    }

    public TrainDriver getTrainDriver() {
        return driver;
    }

    public void setTrainDriver(TrainDriver driver) {
        this.driver = driver;
    }
}
