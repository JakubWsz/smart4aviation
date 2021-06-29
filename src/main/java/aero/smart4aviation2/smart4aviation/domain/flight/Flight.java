package aero.smart4aviation2.smart4aviation.domain.flight;

import java.util.List;

public class Flight {
    private List<FlightData> flightDataList;

    public Flight(List<FlightData> flightDataList) {
        this.flightDataList = flightDataList;
    }

    public List<FlightData> getFlightDataList() {
        return flightDataList;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightDataList=" + flightDataList +
                '}';
    }
}
