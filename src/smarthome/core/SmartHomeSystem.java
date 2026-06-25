package smarthome.core;

import smarthome.devices.SmartDevice;
import smarthome.events.*;
import smarthome.scenarios.Scenario;
import smarthome.scenarios.ScenarioAction;
import smarthome.sensors.Sensor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SmartHomeSystem implements Serializable {
    private static SmartHomeSystem instance;

    private Map<Integer, SmartDevice> devices = new HashMap<>();
    private Map<Integer, Sensor> sensors = new HashMap<>();
    private Map<String, Scenario> scenarios = new HashMap<>();

    private final EventPublisher publisher = new EventPublisher();
    private final StatisticsObserver statisticsObserver = new StatisticsObserver();

    private SmartHomeSystem() {
        publisher.subscribe(statisticsObserver);
        publisher.subscribe(new ConsoleNotificationObserver());
    }

    public static SmartHomeSystem getInstance() {
        if (instance == null) {
            instance = new SmartHomeSystem();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
    }

    public void addSensor(Sensor sensor) {
        sensors.put(sensor.getId(), sensor);
    }

    public void addScenario(Scenario scenario) {
        scenarios.put(scenario.getName(), scenario);
    }

    public void showDevices() {
        System.out.println("=== DEVICES ===");
        if (devices.isEmpty()) {
            System.out.println("No devices added.");
            return;
        }

        for (SmartDevice device : devices.values()) {
            System.out.println(device.getStatus());
        }
    }

    public void runScenario(String name) {
        Scenario scenario = scenarios.get(name);

        if (scenario == null) {
            System.out.println("Scenario not found.");
            return;
        }

        System.out.println("Running scenario: " + name);

        for (ScenarioAction action : scenario.getActions()) {
            SmartDevice device = devices.get(action.getDeviceId());
            if (device != null) {
                device.performAction(action.getAction());
                System.out.println("Action for device " + action.getDeviceId() + " executed");
            }
        }

        publishEvent(new SmartEvent(
                EventType.SCENARIO_EXECUTED,
                name,
                "Scenario finished successfully."
        ));
    }

    public void generateSensorEvent(int sensorId) {
        Sensor sensor = sensors.get(sensorId);

        if (sensor == null) {
            System.out.println("Sensor not found.");
            return;
        }

        publishEvent(sensor.generateEvent());
    }

    public void publishEvent(SmartEvent event) {
        publisher.notifyObservers(event);
    }

    public void showStatistics() {
        System.out.println(statisticsObserver.getStatistics());
    }

    public SmartHomeMemento saveState() {
        return new SmartHomeMemento(devices, sensors, scenarios);
    }

    public void restoreState(SmartHomeMemento memento) {
        this.devices = memento.getDevices();
        this.sensors = memento.getSensors();
        this.scenarios = memento.getScenarios();
    }
}
