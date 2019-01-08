package by.tc.task01.entity.appliance;

public class Laptop extends Appliance {
    private double battery_capacity;
    private String os;
    private double memory_rom;
    private double system_memory;
    private double cpu;
    private double display_inchs;

    public Laptop(double battery_capacity, String os, double memory_rom, double system_memory, double cpu, double display_inchs) {
        this.battery_capacity = battery_capacity;
        this.os = os;
        this.memory_rom = memory_rom;
        this.system_memory = system_memory;
        this.cpu = cpu;
        this.display_inchs = display_inchs;
    }

    public Laptop() {
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(double memory_rom) {
        this.memory_rom = memory_rom;
    }

    public double getSystem_memory() {
        return system_memory;
    }

    public void setSystem_memory(double system_memory) {
        this.system_memory = system_memory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplay_inchs() {
        return display_inchs;
    }

    public void setDisplay_inchs(double display_inchs) {
        this.display_inchs = display_inchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.battery_capacity, battery_capacity) != 0) return false;
        if (Double.compare(laptop.memory_rom, memory_rom) != 0) return false;
        if (Double.compare(laptop.system_memory, system_memory) != 0) return false;
        if (Double.compare(laptop.cpu, cpu) != 0) return false;
        if (Double.compare(laptop.display_inchs, display_inchs) != 0) return false;
        return os.equals(laptop.os);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(battery_capacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + os.hashCode();
        temp = Double.doubleToLongBits(memory_rom);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(system_memory);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(display_inchs);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "battery_capacity=" + battery_capacity +
                ", os='" + os + '\'' +
                ", memory_rom=" + memory_rom +
                ", system_memory=" + system_memory +
                ", cpu=" + cpu +
                ", display_inchs=" + display_inchs +
                '}';
    }
    // you may add your own code here
}
