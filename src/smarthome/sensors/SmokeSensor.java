package smarthome.sensors;

import smarthome.events.EventType;
import smarthome.events.SmartEvent;

public class SmokeSensor extends Sensor {
    public SmokeSensor(int id, String name) {
        super(id, name);
    }

    @Override
    public SmartEvent generateEvent() {
        return new SmartEvent(
                EventType.SMOKE_DETECTED,
                getName(),
                "Smoke detected! Check the room immediately."
        );
    }
}
