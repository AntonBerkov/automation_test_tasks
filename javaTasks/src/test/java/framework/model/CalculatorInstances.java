package framework.model;

public class CalculatorInstances {
    private String numberOfInstances;
    private String software;
    private String machineClass;
    private String machineType;
    private String location;

    public CalculatorInstances(String numberOfInstances, String software, String machineClass, String machineType, String location) {
        this.numberOfInstances = numberOfInstances;
        this.software = software;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.location = location;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getSoftware() {
        return software;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getLocation() {
        return location;
    }
}
