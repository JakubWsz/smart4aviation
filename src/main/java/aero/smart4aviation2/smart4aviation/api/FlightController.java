package aero.smart4aviation2.smart4aviation.api;

import aero.smart4aviation2.smart4aviation.api.response.FlightSummaryView;
import aero.smart4aviation2.smart4aviation.api.response.ReportWeightView;
import aero.smart4aviation2.smart4aviation.domain.cargo.CargoService;
import aero.smart4aviation2.smart4aviation.domain.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FlightController {
    private final FlightService flightService;
    private final CargoService cargoService;

    @Autowired
    public FlightController(FlightService flightService, CargoService cargoService) {
        this.flightService = flightService;
        this.cargoService = cargoService;
    }

    @GetMapping("/report-weight")
    public ReportWeightView getReportWeight(@RequestParam("flight-number") int flightNumber,
                                            @RequestParam("departure-date") String departureDate) {
       try{
           return cargoService.getReportWeight(flightNumber, departureDate);
       }catch (RuntimeException e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/flight-summary")
    public FlightSummaryView getFlightSummary(@RequestParam("iata") String iata,
                                              @RequestParam("departure-date") String departureDate) {
        return flightService.getFlightSummary(iata, departureDate);
    }
}
