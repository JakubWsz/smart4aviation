package aero.smart4aviation2.smart4aviation.domain.cargo;

import java.util.List;

public class CargoData {
    private String flightId;
    private List<Load> baggage;
    private List<Load> cargo;

    public CargoData(String flightId, List<Load> baggage, List<Load> cargo) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargo = cargo;
    }

    public String getFlightId() {
        return flightId;
    }

    public List<Load> getBaggage() {
        return baggage;
    }

    public List<Load> getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "CargoData{" +
                "flightId='" + flightId + '\'' +
                ", baggage=" + baggage +
                ", cargo=" + cargo +
                '}';
    }
}
