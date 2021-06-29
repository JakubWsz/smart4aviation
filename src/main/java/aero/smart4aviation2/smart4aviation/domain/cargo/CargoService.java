package aero.smart4aviation2.smart4aviation.domain.cargo;

import aero.smart4aviation2.smart4aviation.api.response.ReportWeightView;
import aero.smart4aviation2.smart4aviation.domain.flight.FlightData;
import aero.smart4aviation2.smart4aviation.domain.flight.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private final FlightRepository flightRepository;

    public CargoService(CargoRepository cargoRepository, FlightRepository flightRepository) {
        this.cargoRepository = cargoRepository;
        this.flightRepository = flightRepository;
    }

    public ReportWeightView getReportWeight(int flightNumber, String departureDate) {
        FlightData selectedFlight = getFlightData(flightNumber, departureDate);
        CargoData cargodata = cargoRepository.getCargo(selectedFlight.getFlightId())
                .orElseThrow(() -> new RuntimeException("cargo not found"));

        double baggageWeight = cargodata.getBaggage().stream()
                .map(load -> {
                    if (load.getWeightUnit() == WeightUnit.KG) {
                        return load.getWeight();
                    } else {
                        return load.getWeight() * 0.45;
                    }
                })
                .reduce(0d, Double::sum);

        double cargoWeight = cargodata.getCargo().stream()
                .map(load -> {
                    if (load.getWeightUnit() == WeightUnit.KG) {
                        return load.getWeight();
                    } else {
                        return load.getWeight() * 0.45;
                    }
                })
                .reduce(0d, Double::sum);

        return new ReportWeightView(cargoWeight, baggageWeight, cargoWeight + baggageWeight);
    }

    public FlightData getFlightData(int flightNumber, String departureDate) {
        return flightRepository.getFlight(flightNumber, LocalDate.parse(departureDate))
                .orElseThrow(() -> new RuntimeException("flight not found"));
    }
}