package smarthome.devices;

import java.io.Serializable;

public abstract class SmartDevice implements Serializable {
    private final int id;
    private final String name;
    private boolean on;

    public SmartDevice(int id, String name) {
        this.id = id;
        this.name = name;
        this.on = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public abstract String getStatus();

    public abstract void performAction(String action);
}
