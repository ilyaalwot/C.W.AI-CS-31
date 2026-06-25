package smarthome.factory;

import smarthome.sensors.*;

public class SensorFactory {
    public static Sensor createSensor(String type, int id, String name) {
        switch (type.toLowerCase()) {
            case "motion":
                return new MotionSensor(id, name);
            case "temperature":
                return new TemperatureSensor(id, name);
            case "smoke":
                return new SmokeSensor(id, name);
            default:
                throw new IllegalArgumentException("Unknown sensor type: " + type);
        }
    }
}
