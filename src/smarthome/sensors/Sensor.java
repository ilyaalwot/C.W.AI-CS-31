package smarthome.sensors;

import java.io.Serializable;
import smarthome.events.SmartEvent;

public abstract class Sensor implements Serializable {
    private final int id;
    private final String name;

    public Sensor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract SmartEvent generateEvent();
}
