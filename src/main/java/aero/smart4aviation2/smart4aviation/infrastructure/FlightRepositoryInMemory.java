package aero.smart4aviation2.smart4aviation.infrastructure;

import aero.smart4aviation2.smart4aviation.domain.flight.Flight;
import aero.smart4aviation2.smart4aviation.domain.flight.FlightData;
import aero.smart4aviation2.smart4aviation.domain.flight.FlightRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@Repository
public class FlightRepositoryInMemory implements FlightRepository, ApplicationRunner {
   private final List<Flight> flightList = new ArrayList<>();

    @Override
    public Optional<FlightData> getFlight(int flightNumber, LocalDate date) {
        return flightList.stream()
                .flatMap(flight -> Stream.of(flight.getFlightDataList()))
                .flatMap(List::stream)
                .filter(flightData -> flightData.getFlightNumber() == flightNumber)
                .filter(flightData -> flightData.getDepartureData().equals(date))
                .findFirst();
    }

    @Override
    public List<FlightData> getFlightsFromDepartureAirport(String iata, LocalDate date) {
        List<FlightData> flightDataList= new ArrayList<>();
        flightList.forEach(flight -> {
            flight.getFlightDataList().forEach(flightData ->{
                if (flightData.getDepartureAirportIATACode().equals(iata) && flightData.getDepartureData().equals(date)){
                    flightDataList.add(flightData);
                }
            });
        });
        return flightDataList;
    }

    @Override
    public List<FlightData> getFlightsFromArrivalAirport(String iata, LocalDate date) {
        List<FlightData> flightDataList= new ArrayList<>();
        flightList.forEach(flight -> {
            flight.getFlightDataList().forEach(flightData ->{
                if (flightData.getArrivalAirportIATACode().equals(iata) && flightData.getDepartureData().equals(date)){
                    flightDataList.add(flightData);
                }
            });
        });
        return flightDataList;
    }

    @Override
    public void run(ApplicationArguments args) {
        flightList.add(generateFlight("1","2","3","4","5"));
        System.out.println(flightList);
    }

    private FlightData generateFlightData(String flightId){
        return new FlightData(flightId,new Random().nextInt(20000)+1,"LAX","LAX",
                LocalDate.now());
    }

    private Flight generateFlight(String... flightIds){
        List<FlightData> flightDataList = new ArrayList<>();
        for(String flightId : flightIds){
            flightDataList.add(generateFlightData(flightId));
        }
        return new Flight(flightDataList);
    }
}

