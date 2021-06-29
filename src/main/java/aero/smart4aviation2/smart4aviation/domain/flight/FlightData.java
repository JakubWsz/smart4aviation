package aero.smart4aviation2.smart4aviation.domain.flight;

import java.time.LocalDate;

public class FlightData {
    private String flightId;
    private int flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private LocalDate departureData;

    public FlightData(String flightId,
                      int flightNumber,
                      String departureAirportIATACode,
                      String arrivalAirportIATACode,
                      LocalDate departureData) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureAirportIATACode = departureAirportIATACode;
        this.arrivalAirportIATACode = arrivalAirportIATACode;
        this.departureData = departureData;
    }

    public String getFlightId() {
        return flightId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public LocalDate getDepartureData() {
        return departureData;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "flightId='" + flightId + '\'' +
                ", flightNumber=" + flightNumber +
                ", departureAirportIATACode='" + departureAirportIATACode + '\'' +
                ", arrivalAirportIATACode='" + arrivalAirportIATACode + '\'' +
                ", departureData=" + departureData +
                '}';
    }
}
