package aero.smart4aviation2.smart4aviation.domain.cargo;

import java.util.List;

public class Cargo {
    private List<CargoData> cargoDataList;

    public Cargo(List<CargoData> cargoDataList) {
        this.cargoDataList = cargoDataList;
    }

    public List<CargoData> getCargoDataList() {
        return cargoDataList;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoDataList=" + cargoDataList +
                '}';
    }
}
