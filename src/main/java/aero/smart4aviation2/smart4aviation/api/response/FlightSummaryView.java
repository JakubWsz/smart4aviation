package aero.smart4aviation2.smart4aviation.api.response;

public class FlightSummaryView {
    private int numberOfDepartingFlights;
    private int numberOfArrivingFlights;
    private int totalNumberOfDepartingBaggage;
    private int totalNumberOfArrivingBaggage;

    public FlightSummaryView() {
    }

    public FlightSummaryView(int numberOfDepartingFlights,
                             int numberOfArrivingFlights,
                             int totalNumberOfDepartingBaggage,
                             int totalNumberOfArrivingBaggage) {
        this.numberOfDepartingFlights = numberOfDepartingFlights;
        this.numberOfArrivingFlights = numberOfArrivingFlights;
        this.totalNumberOfDepartingBaggage = totalNumberOfDepartingBaggage;
        this.totalNumberOfArrivingBaggage = totalNumberOfArrivingBaggage;
    }

    public int getNumberOfDepartingFlights() {
        return numberOfDepartingFlights;
    }

    public int getNumberOfArrivingFlights() {
        return numberOfArrivingFlights;
    }

    public int getTotalNumberOfDepartingBaggage() {
        return totalNumberOfDepartingBaggage;
    }

    public int getTotalNumberOfArrivingBaggage() {
        return totalNumberOfArrivingBaggage;
    }
}
