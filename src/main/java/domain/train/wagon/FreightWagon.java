package domain.train.wagon;

import domain.cargo.Cargo;
import domain.cargo.CargoType;
import domain.cargo.Weight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.*;

public class FreightWagon extends Wagon {

    private final List<Cargo> cargos = new ArrayList<>();
    private final Weight cargoCapacity;
    private final CargoType typeTransportedCargo;
    private final Logger logger = LoggerFactory.getLogger(FreightWagon.class);

    private Weight currentWeightCargo;

    public FreightWagon(CargoType typeTransportedCargo, Weight cargoCapacity) {
        this.typeTransportedCargo = typeTransportedCargo;
        this.cargoCapacity = cargoCapacity;
        currentWeightCargo = new Weight(0);
    }

    public boolean addCargo(Cargo cargo) {
        checkArgument(cargo.getTypeCargo() == typeTransportedCargo,
                "The type of cargo must correspond to type transported cargo");

        checkArgument(!cargos.contains(cargo), "The cargo is already loaded");

        Weight totalWeight = currentWeightCargo.add(cargo.getWeight());
        checkArgument(totalWeight.getGrams() <= cargoCapacity.getGrams(),
                "The weight of the cargo is too large");

        cargos.add(cargo);
        currentWeightCargo = totalWeight;
        logger.debug("{} added to {}", cargo, this);

        return true;
    }

    public void removeCargo(Cargo cargo) {
        if (cargos.remove(cargo)) {
            currentWeightCargo = currentWeightCargo.subtract(cargo.getWeight());
            logger.debug("{} cargo removed from {}", cargo, toString());
        }
    }

    public CargoType getTypeTransportedCargo() {
        return typeTransportedCargo;
    }

    public Weight getCargoCapacity() {
        return cargoCapacity;
    }

    public List<Cargo> getCargos() {
        return new ArrayList<>(cargos);
    }

    public Weight getCurrentWeightCargo() {
        return currentWeightCargo;
    }

    @Override
    public String toString() {
        return "FreightWagon{" +
                "number=" + getNumber() +
                " cargoCapacity=" + cargoCapacity +
                ", typeTransportedCargo=" + typeTransportedCargo +
                '}';
    }
}
