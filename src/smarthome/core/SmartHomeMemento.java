package smarthome.core;

import smarthome.devices.SmartDevice;
import smarthome.scenarios.Scenario;
import smarthome.sensors.Sensor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SmartHomeMemento implements Serializable {
    private final Map<Integer, SmartDevice> devices;
    private final Map<Integer, Sensor> sensors;
    private final Map<String, Scenario> scenarios;

    public SmartHomeMemento(Map<Integer, SmartDevice> devices,
                            Map<Integer, Sensor> sensors,
                            Map<String, Scenario> scenarios) {
        this.devices = new HashMap<>(devices);
        this.sensors = new HashMap<>(sensors);
        this.scenarios = new HashMap<>(scenarios);
    }

    public Map<Integer, SmartDevice> getDevices() {
        return new HashMap<>(devices);
    }

    public Map<Integer, Sensor> getSensors() {
        return new HashMap<>(sensors);
    }

    public Map<String, Scenario> getScenarios() {
        return new HashMap<>(scenarios);
    }
}
