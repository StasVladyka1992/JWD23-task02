package by.tc.task01.entity.appliance;

public class Speakers extends Appliance {
    private double power_consumption;
    private double number_of_speakers;
    private String frequency_range;
    private double cord_length;


    public Speakers(double power_consumption, double number_of_speakers, String frequency_range, double cord_length) {
        this.power_consumption = power_consumption;
        this.number_of_speakers = number_of_speakers;
        this.frequency_range = frequency_range;
        this.cord_length = cord_length;
    }

    public Speakers() {
    }

    public double getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(double power_consumption) {
        this.power_consumption = power_consumption;
    }

    public double getNumber_of_speakers() {
        return number_of_speakers;
    }

    public void setNumber_of_speakers(double number_of_speakers) {
        this.number_of_speakers = number_of_speakers;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public double getCord_length() {
        return cord_length;
    }

    public void setCord_length(double cord_length) {
        this.cord_length = cord_length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (Double.compare(speakers.power_consumption, power_consumption) != 0) return false;
        if (Double.compare(speakers.number_of_speakers, number_of_speakers) != 0) return false;
        if (Double.compare(speakers.cord_length, cord_length) != 0) return false;
        return frequency_range.equals(speakers.frequency_range);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(power_consumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(number_of_speakers);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + frequency_range.hashCode();
        temp = Double.doubleToLongBits(cord_length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "power_consumption=" + power_consumption +
                ", number_of_speakers=" + number_of_speakers +
                ", frequency_range='" + frequency_range + '\'' +
                ", cord_length=" + cord_length +
                '}';
    }
}
