package Assignment4;

abstract class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public abstract void turnOn();
}

interface VoiceControl {
    void controlByVoice(String command);
}

class SmartLight extends SmartDevice implements VoiceControl {

    public SmartLight(String deviceName) {
        super(deviceName);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on " + deviceName);
    }

    @Override
    public void controlByVoice(String command) {
        System.out.println(deviceName + " controlled by voice: '" + command + "'");
    }
}

class SmartAC extends SmartDevice implements VoiceControl {

    public SmartAC(String deviceName) {
        super(deviceName);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on " + deviceName);
    }

    @Override
    public void controlByVoice(String command) {
        System.out.println(deviceName + " controlled by voice: '" + command + "'");
    }
}

public class SmartHomeAutomationSystem {
    public static void main(String[] args) {
        SmartLight light = new SmartLight("Smart Light");
        light.turnOn();
        light.controlByVoice("Turn on the lights");

        SmartAC ac = new SmartAC("Smart AC");
        ac.turnOn();
        ac.controlByVoice("Set temperature to 22°C");
    }
}
