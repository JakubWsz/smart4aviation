package aero.smart4aviation2.smart4aviation.domain.flight;

import aero.smart4aviation2.smart4aviation.api.response.FlightSummaryView;
import aero.smart4aviation2.smart4aviation.domain.cargo.CargoData;
import aero.smart4aviation2.smart4aviation.domain.cargo.CargoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final CargoRepository cargoRepository;

    public FlightService(FlightRepository flightRepository, CargoRepository cargoRepository) {
        this.flightRepository = flightRepository;
        this.cargoRepository = cargoRepository;
    }

    public FlightSummaryView getFlightSummary(String iata, String departureDate) {

        List<FlightData> flightsFromDepartureAirport = flightRepository.getFlightsFromDepartureAirport(iata,
                LocalDate.parse(departureDate));
        List<FlightData> flightsFromArrivalAirport = flightRepository.getFlightsFromArrivalAirport(iata,
                LocalDate.parse(departureDate));

        int numberOfDepartureFlights = flightsFromDepartureAirport.size();
        int numberOfArrivalFlights = flightsFromArrivalAirport.size();

        int numberOfDepartureBaggage = 0;
        for (FlightData flightData : flightsFromDepartureAirport) {
            if (flightData.getDepartureAirportIATACode().equals(iata)) {
                Optional<CargoData> baggageData = cargoRepository.getCargo(flightData.getFlightId());
                if (baggageData.isPresent()) {
                    numberOfDepartureBaggage = baggageData.get().getBaggage().size();
                }
            }
        }

        int numberOfArrivalBaggage = 0;
        for (FlightData flightData : flightsFromArrivalAirport) {
            if (flightData.getArrivalAirportIATACode().equals(iata)) {
               Optional<CargoData> baggageData = cargoRepository.getCargo(flightData.getFlightId());
               if (baggageData.isPresent()){
                   numberOfArrivalBaggage += baggageData.get().getBaggage().size();
               }
            }
        }

        return new FlightSummaryView(numberOfDepartureFlights, numberOfArrivalFlights,
                numberOfDepartureBaggage, numberOfArrivalBaggage);
    }
}
