package by.tc.task01.entity.appliance;

public class TabletPC extends Appliance {
    private double battery_capacity;
    private double display_inches;
    private double memory_rom;
    private double flash_memory_capacity;
    private String color;


    public TabletPC(double battery_capacity, double display_inchs, double memory_rom, double flash_memory_capacity, String color) {
        this.battery_capacity = battery_capacity;
        this.display_inches = display_inchs;
        this.memory_rom = memory_rom;
        this.flash_memory_capacity = flash_memory_capacity;
        this.color = color;
    }

    public TabletPC() {
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public double getDisplay_inches() {
        return display_inches;
    }

    public void setDisplay_inches(double display_inchs) {
        this.display_inches = display_inchs;
    }

    public double getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(double memory_rom) {
        this.memory_rom = memory_rom;
    }

    public double getFlash_memory_capacity() {
        return flash_memory_capacity;
    }

    public void setFlash_memory_capacity(double flash_memory_capacity) {
        this.flash_memory_capacity = flash_memory_capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.battery_capacity, battery_capacity) != 0) return false;
        if (Double.compare(tabletPC.display_inches, display_inches) != 0) return false;
        if (Double.compare(tabletPC.memory_rom, memory_rom) != 0) return false;
        if (Double.compare(tabletPC.flash_memory_capacity, flash_memory_capacity) != 0) return false;
        return color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(battery_capacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(display_inches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memory_rom);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flash_memory_capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "battery_capacity=" + battery_capacity +
                ", display_inchs=" + display_inches +
                ", memory_rom=" + memory_rom +
                ", flash_memory_capacity=" + flash_memory_capacity +
                ", color='" + color + '\'' +
                '}';
    }
}
