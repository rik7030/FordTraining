package Assignment3;

public class SmartHomeSystem {
    private String deviceId;
    private String deviceName;
    private boolean status;

    public SmartHomeSystem(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.status = false;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void performAction() {
        System.out.println("Generic device action.");
    }

    public void displayInfo() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

class SmartLight extends SmartHomeSystem {
    public SmartLight(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    @Override
    public void performAction() {
        if (!getStatus()) {
            setStatus(true);
            System.out.println("Light turned ON.");
        } else {
            setStatus(false);
            System.out.println("Light turned OFF.");
        }
    }
}

class SmartLock extends SmartHomeSystem {
    public SmartLock(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    @Override
    public void performAction() {
        if (!getStatus()) {
            setStatus(true);
            System.out.println("Door locked.");
        } else {
            setStatus(false);
            System.out.println("Door unlocked.");
        }
    }

    public static void main(String arg[]) {
        SmartHomeSystem[] devices = new SmartHomeSystem[2];

        devices[0] = new SmartLight("DL01", "Living Room Light");
        devices[1] = new SmartLock("DL03", "Main Door Lock");

        for (SmartHomeSystem device : devices) {
            System.out.println("\n=== " + device.getDeviceName() + " ===");
            device.displayInfo();
            device.performAction();
            device.displayInfo();
        }
    }
}


