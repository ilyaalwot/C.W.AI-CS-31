package smarthome.sensors;

import smarthome.events.EventType;
import smarthome.events.SmartEvent;

public class MotionSensor extends Sensor {
    public MotionSensor(int id, String name) {
        super(id, name);
    }

    @Override
    public SmartEvent generateEvent() {
        return new SmartEvent(
                EventType.MOTION_DETECTED,
                getName(),
                "Motion detected in the room"
        );
    }
}
