package aero.smart4aviation2.smart4aviation.domain.cargo;

public class Load {
    private String id;
    private double weight;
    private WeightUnit weightUnit;
    private int pieces;

    public Load(String id, int weight, WeightUnit weightUnit, int pieces) {
        this.id = id;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public int getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "Load{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", weightUnit=" + weightUnit +
                ", pieces=" + pieces +
                '}';
    }
}
