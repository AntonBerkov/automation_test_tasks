package framework.service;

import framework.model.CalculatorInstances;

public class InstanceCreator {
    private static final String NUMBER_OF_INSTANCES = "testdata.unstance.number";
    private static final String SOFTWARE = "testdata.unstance.software";
    private static final String MACHINE_CLASS = "testdata.unstance.machine.class";
    private static final String MACHINE_TYPE = "testdata.unstance.machine.type";
    private static final String LOCATION = "testdata.unstance.location";

    public static CalculatorInstances generateInstances() {
        return new CalculatorInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(SOFTWARE), TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(LOCATION));
    }
}
