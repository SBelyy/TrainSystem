package domain.train.wagon;

import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;

public class Locomotive extends Wagon {

    private TrainDriver driver;
    private final Logger logger = LoggerFactory.getLogger(Locomotive.class);

    public Locomotive(TrainDriver trainDriver) {
        setTrainDriver(trainDriver);
    }

    public TrainDriver getTrainDriver() {
        return driver;
    }

    public void setTrainDriver(TrainDriver driver) {
        checkArgument(driver.getTypeLicense() == LicenseType.VALID,
                "The driver's license is not valid");
        this.driver = driver;
        logger.debug("{} added to {}", driver, this);
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "number=" + getNumber() +
                '}';
    }
}
