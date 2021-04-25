package domain.train.wagon;

import domain.cargo.Cargo;
import domain.cargo.CargoType;
import domain.cargo.Weight;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.*;

public class FreightWagon extends Wagon {

    private final List<Cargo> cargos;
    private final Weight cargoCapacity;
    private final CargoType typeTransportedCargo;

    private Weight currentWeightCargo;

    public FreightWagon(CargoType typeTransportedCargo, Weight cargoCapacity) {
        this.typeTransportedCargo = typeTransportedCargo;
        this.cargoCapacity = cargoCapacity;
        currentWeightCargo = new Weight(0);
        cargos = new ArrayList<>();
    }

    public boolean addCargo(Cargo cargo) {
        checkArgument(cargo.getTypeCargo() == typeTransportedCargo,
                "The type of cargo must correspond to type transported cargo");

        Weight totalWeight = currentWeightCargo.add(cargo.getWeight());
        checkArgument(totalWeight.getGrams() <= cargoCapacity.getGrams(),
                "The weight of the cargo is too large");

        cargos.add(cargo);
        currentWeightCargo = totalWeight;

        return true;
    }

    public void removeCargo(Cargo cargo) {
        if (cargos.contains(cargo)) {
            cargos.remove(cargo);
            currentWeightCargo = currentWeightCargo.subtract(cargo.getWeight());
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
        return new Weight(currentWeightCargo.getGrams());
    }

}
