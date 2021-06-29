package aero.smart4aviation2.smart4aviation.domain.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    Optional<FlightData> getFlight(int flightNumber, LocalDate date);
    List<FlightData> getFlightsFromDepartureAirport(String iata,LocalDate date);
    List<FlightData> getFlightsFromArrivalAirport(String iata,LocalDate date);
}
