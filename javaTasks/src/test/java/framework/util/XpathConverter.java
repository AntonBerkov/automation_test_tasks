package framework.util;

public class XpathConverter {
    private static String result;

    public static String convertMachineType(String machineType) {
        switch (machineType) {
            case "n1-standard-16 (vCPUs: 16, RAM: 60GB)": {
                result = "select_option_218";
                break;
            }
            default:
                result = "select_option_217";
        }
        return result;
    }

    public static String convertSoftware(String software) {
        switch (software) {
            case "Paid: Windows Server 2008r2, Windows Server 2012r2, Windows Server 2016, Windows Core": {
                result = "//*[@value='win']";
                break;
            }
            default:
                result = "//*[@value='free']";
        }
        return result;
    }

    public static String convertMachineClass(String machineClass) {
        switch (machineClass) {
            case "Preemptible": {
                result = "//*[@value='preemptible']";
                break;
            }
            default:
                result = "//*[@value='regular']";
        }
        return result;
    }

    public static String convertLocation(String location) {
        switch (location) {
            case "South Carolina": {
                result = "select_option_179";
                break;
            }
            default:
                result = "select_option_185";
        }
        return result;
    }
}
