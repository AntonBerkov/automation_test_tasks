package framework.service;

import framework.model.CalculatorInstances;

public class InstanceCreator {
    public static final String NUMBER_OF_INSTANCES = "testdata.unstance.number";
    public static final String SOFTWARE = "testdata.unstance.software";
    public static final String MACHINE_CLASS = "testdata.unstance.machine.class";
    public static final String MACHINE_TYPE = "testdata.unstance.machine.type";
    public static final String LOCATION = "testdata.unstance.location";

    public static CalculatorInstances generateInstances() {
        return new CalculatorInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(SOFTWARE), TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(LOCATION));
    }
}
