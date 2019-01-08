package by.tc.task01.entity.appliance;

public class Refrigerator extends Appliance {
    private double power_consumption;
    private double weight;
    private double freezer_capacity;
    private double overall_capacity;
    private double height;
    private double width;

    public Refrigerator(double power_consumption, double weight, double freezer_capacity, double overall_capacity, double height, double width) {
        this.power_consumption = power_consumption;
        this.weight = weight;
        this.freezer_capacity = freezer_capacity;
        this.overall_capacity = overall_capacity;
        this.height = height;
        this.width = width;
    }

    public Refrigerator() {
    }

    public double getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(double power_consumption) {
        this.power_consumption = power_consumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFreezer_capacity() {
        return freezer_capacity;
    }

    public void setFreezer_capacity(double freezer_capacity) {
        this.freezer_capacity = freezer_capacity;
    }

    public double getOverall_capacity() {
        return overall_capacity;
    }

    public void setOverall_capacity(double overall_capacity) {
        this.overall_capacity = overall_capacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refrigerator that = (Refrigerator) o;

        if (Double.compare(that.power_consumption, power_consumption) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.freezer_capacity, freezer_capacity) != 0) return false;
        if (Double.compare(that.overall_capacity, overall_capacity) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(power_consumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(freezer_capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(overall_capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "power_consumption=" + power_consumption +
                ", weight=" + weight +
                ", freezer_capacity=" + freezer_capacity +
                ", overall_capacity=" + overall_capacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
