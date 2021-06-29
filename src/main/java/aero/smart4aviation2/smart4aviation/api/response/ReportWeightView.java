package aero.smart4aviation2.smart4aviation.api.response;

public class ReportWeightView {
    private double CargoWeight;
    private double BaggageWeight;
    private double TotalWeight;

    public ReportWeightView() {
    }

    public ReportWeightView(double cargoWeight, double baggageWeight, double totalWeight) {
        CargoWeight = cargoWeight;
        BaggageWeight = baggageWeight;
        TotalWeight = totalWeight;
    }

    public double getCargoWeight() {
        return CargoWeight;
    }

    public double getBaggageWeight() {
        return BaggageWeight;
    }

    public double getTotalWeight() {
        return TotalWeight;
    }
}
