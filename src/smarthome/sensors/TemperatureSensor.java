package smarthome.sensors;

import smarthome.events.EventType;
import smarthome.events.SmartEvent;

public class TemperatureSensor extends Sensor {
    private int currentTemperature = 25;

    public TemperatureSensor(int id, String name) {
        super(id, name);
    }

    @Override
    public SmartEvent generateEvent() {
        return new SmartEvent(
                EventType.TEMPERATURE_CHANGED,
                getName(),
                "Temperature changed to " + currentTemperature + "°C"
        );
    }
}
