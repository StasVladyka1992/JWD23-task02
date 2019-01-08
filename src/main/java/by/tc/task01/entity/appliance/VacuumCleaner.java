package by.tc.task01.entity.appliance;

public class VacuumCleaner extends Appliance {
    private double power_consumption;
    private String filter_type;
    private String bag_type;
    private String wand_type;
    private double motor_speed_regulation;
    private double cleaning_width;

    public VacuumCleaner(double power_consumption, String filter_type, String bag_type, String wand_type, double motor_speed_regulation, double cleaning_width) {
        this.power_consumption = power_consumption;
        this.filter_type = filter_type;
        this.bag_type = bag_type;
        this.wand_type = wand_type;
        this.motor_speed_regulation = motor_speed_regulation;
        this.cleaning_width = cleaning_width;
    }

    public VacuumCleaner() {
    }

    public double getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(double power_consumption) {
        this.power_consumption = power_consumption;
    }

    public String getFilter_type() {
        return filter_type;
    }

    public void setFilter_type(String filter_type) {
        this.filter_type = filter_type;
    }

    public String getBag_type() {
        return bag_type;
    }

    public void setBag_type(String bag_type) {
        this.bag_type = bag_type;
    }

    public String getWand_type() {
        return wand_type;
    }

    public void setWand_type(String wand_type) {
        this.wand_type = wand_type;
    }

    public double getMotor_speed_regulation() {
        return motor_speed_regulation;
    }

    public void setMotor_speed_regulation(double motor_speed_regulation) {
        this.motor_speed_regulation = motor_speed_regulation;
    }

    public double getCleaning_width() {
        return cleaning_width;
    }

    public void setCleaning_width(double cleaning_width) {
        this.cleaning_width = cleaning_width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (Double.compare(that.power_consumption, power_consumption) != 0) return false;
        if (Double.compare(that.motor_speed_regulation, motor_speed_regulation) != 0) return false;
        if (Double.compare(that.cleaning_width, cleaning_width) != 0) return false;
        if (!filter_type.equals(that.filter_type)) return false;
        if (!bag_type.equals(that.bag_type)) return false;
        return wand_type.equals(that.wand_type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(power_consumption);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + filter_type.hashCode();
        result = 31 * result + bag_type.hashCode();
        result = 31 * result + wand_type.hashCode();
        temp = Double.doubleToLongBits(motor_speed_regulation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cleaning_width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "power_consumption=" + power_consumption +
                ", filter_type='" + filter_type + '\'' +
                ", bag_type='" + bag_type + '\'' +
                ", wand_type='" + wand_type + '\'' +
                ", motor_speed_regulation=" + motor_speed_regulation +
                ", cleaning_width=" + cleaning_width +
                '}';
    }

    // you may add your own code here
}
