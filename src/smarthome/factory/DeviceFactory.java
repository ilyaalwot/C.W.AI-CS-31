package smarthome.factory;

import smarthome.devices.*;

public class DeviceFactory {
    public static SmartDevice createDevice(String type, int id, String name) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id, name);
            case "thermostat":
                return new Thermostat(id, name);
            case "coffeemachine":
                return new CoffeeMachine(id, name);
            case "smartwindow":
                return new SmartWindow(id, name);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}
